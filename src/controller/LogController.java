/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import model.LogRecord;
import db.LogDBAccess;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class LogController {

    private LogDBAccess logDBAccess = new LogDBAccess();

    public boolean addRecord(String act) throws SQLException, ClassNotFoundException {
        return logDBAccess.addRecord(act);
    }

    public ArrayList<LogRecord> searchLogRecords(String from, String to) throws SQLException, ClassNotFoundException {
        return logDBAccess.searchLogRecords(from, to);
    }

    public ArrayList<LogRecord> getAllLogRecords() throws SQLException, ClassNotFoundException {
        return logDBAccess.getAllLogRecords();
    }
}
