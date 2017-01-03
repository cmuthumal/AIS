/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Workshift;
import verification.Verify;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class WorkshiftDBAccess {

    private Connection connection = null;
    private Statement stm = null;

    public boolean addWorkshift(Workshift wk) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();
        String sql = "INSERT INTO workshift VALUES('" + wk.getId() + "','" + wk.getEmployeeID() + "','" + wk.getDate() + "'," + wk.getStarting() + "," + wk.getEnding() + ",'" + wk.getPresent() + "') ;";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public boolean updateWorkshift(Workshift wk) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();
        String sql = "UPDATE workshift SET employeeID='" + wk.getEmployeeID() + "',date='" + wk.getDate() + "',start=" + wk.getStarting() + ",end=" + wk.getEnding() + ",present='" + wk.getPresent() + "' WHERE id='" + wk.getId() + "';";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public boolean deleteWorkshift(String id) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();
        String sql = "DELETE FROM workshift WHERE id='" + id + "';";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public ArrayList<Workshift> getWorkshift(String date) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT * FROM workshift WHERE date='" + date + "';";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<Workshift> wkList = new ArrayList<>();
        while (resultSet.next()) {
            Workshift wk = new Workshift(resultSet.getString("id"), resultSet.getString("employeeID"), resultSet.getString("date"), resultSet.getInt("start"), resultSet.getInt("end"), resultSet.getString("present"));
            wkList.add(wk);
        }
        return wkList;
    }

    public ArrayList<Workshift> getAllWorkshifts() throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT * FROM workshift;";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<Workshift> wkList = new ArrayList<>();
        while (resultSet.next()) {
            Workshift wk = new Workshift(resultSet.getString("id"), resultSet.getString("employeeID"), resultSet.getString("date"), resultSet.getInt("start"), resultSet.getInt("end"), resultSet.getString("present"));
            wkList.add(wk);
        }
        return wkList;
    }

    public String getNextID() throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();
        String lastID = null, nextID = null;

        String sql = "SELECT id FROM workshift ORDER BY id desc LIMIT 1;";

        ResultSet resultSet = stm.executeQuery(sql);
        if (resultSet.next()) {
            lastID = resultSet.getString(1);
        }

        if (lastID.equals("")) {
            lastID = "WRK000000";
        }

        nextID = new Verify().getNextID(lastID);
        return nextID;
    }
}
