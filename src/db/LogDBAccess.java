/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.LogRecord;
import verification.Verify;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class LogDBAccess {

    private Connection connection = null;
    private Statement stm = null;

    public boolean addRecord(String act) throws SQLException, ClassNotFoundException {
        LogRecord record = setRecord(act);

        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "INSERT INTO log VALUES ('" + record.getId() + "', '" + record.getDate() + "', '" + record.getTime() + "', '" + record.getActivity() + "');";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public ArrayList<LogRecord> getAllLogRecords() throws ClassNotFoundException, SQLException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT * FROM log ORDER BY id DESC;";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<LogRecord> recList = new ArrayList<>();
        while (resultSet.next()) {
            LogRecord record = new LogRecord(resultSet.getString("id"), resultSet.getString("date"), resultSet.getString("time"), resultSet.getString("activity"));
            recList.add(record);
        }
        return recList;
    }

    public ArrayList<LogRecord> searchLogRecords(String from, String to) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT * FROM log WHERE date<'" + to + "' AND date>'" + from + "' ORDER BY id DESC;";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<LogRecord> recList = new ArrayList<>();
        while (resultSet.next()) {
            LogRecord record = new LogRecord(resultSet.getString("id"), resultSet.getString("date"), resultSet.getString("time"), resultSet.getString("activity"));
            recList.add(record);
        }
        return recList;
    }

    public String getNextID() throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();
        String lastID = "", nextID = null;

        String sql = "SELECT id FROM log ORDER BY id desc LIMIT 1;";

        ResultSet resultSet = stm.executeQuery(sql);
        if (resultSet.next()) {
            lastID = resultSet.getString(1);
        }

        if (lastID.equals("")) {
            lastID = "REC000000";
        }

        nextID = new Verify().getNextID(lastID);
        return nextID;
    }

    private LogRecord setRecord(String act) {
        String id = "", date = "", time = "";

        try {
            id = getNextID();
        } catch (SQLException ex) {
            Logger.getLogger(LogDBAccess.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LogDBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }

        Date d = new Date();
        date = new SimpleDateFormat("yyyy-MM-dd").format(d);
        time = new SimpleDateFormat("HH:mm:ss").format(d);

        return new LogRecord(id, date, time, act);
    }
}
