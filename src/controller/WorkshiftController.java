/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.LogDBAccess;
import java.sql.SQLException;
import db.WorkshiftDBAccess;
import java.util.ArrayList;
import model.Workshift;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class WorkshiftController {

    private WorkshiftDBAccess wkDBAccess = new WorkshiftDBAccess();
    private LogDBAccess logDBAccess = new LogDBAccess();

    public boolean addWorkshift(Workshift wk) throws SQLException, ClassNotFoundException {
        logDBAccess.addRecord("workshift " + wk.getId() + " added");
        return wkDBAccess.addWorkshift(wk);
    }

    public boolean updateWorkshift(Workshift wk) throws SQLException, ClassNotFoundException {
        logDBAccess.addRecord("workshift " + wk.getId() + " updated");
        return wkDBAccess.updateWorkshift(wk);
    }

    public boolean deleteWorkshift(String id) throws SQLException, ClassNotFoundException {
        logDBAccess.addRecord("workshift " + id + " deleted");
        return wkDBAccess.deleteWorkshift(id);
    }

    public ArrayList<Workshift> getAllWorkshifts() throws SQLException, ClassNotFoundException {
        return wkDBAccess.getAllWorkshifts();
    }

    public ArrayList<Workshift> getWorkshift(String date) throws SQLException, ClassNotFoundException {
        return wkDBAccess.getWorkshift(date);
    }

    public String getNextID() throws SQLException, ClassNotFoundException {
        return wkDBAccess.getNextID();
    }
}
