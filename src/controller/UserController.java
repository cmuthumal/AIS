/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.LogDBAccess;
import java.sql.SQLException;
import db.UserDBAccess;
import java.util.ArrayList;
import model.User;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class UserController {

    private UserDBAccess userDBAccess = new UserDBAccess();
    private LogDBAccess logDBAccess = new LogDBAccess();

    public boolean addUser(User user) throws SQLException, ClassNotFoundException {
        logDBAccess.addRecord("user " + user.getId() + " added");
        return userDBAccess.addUser(user);
    }

    public boolean updateUser(User user) throws SQLException, ClassNotFoundException {
        logDBAccess.addRecord("user " + user.getId() + " updated");
        return userDBAccess.updateUser(user);
    }

    public boolean deleteUser(String id) throws SQLException, ClassNotFoundException {
        logDBAccess.addRecord("user " + id + " deleted");
        return userDBAccess.deleteUser(id);
    }

    public ArrayList<User> getAllUsers() throws SQLException, ClassNotFoundException {
        return userDBAccess.getAllUsers();
    }

    public User getUser(String userName) throws SQLException, ClassNotFoundException {
        return userDBAccess.getUser(userName);
    }

    public boolean checkPassword(String userName, String password) throws SQLException, ClassNotFoundException {
        boolean b = userDBAccess.checkPassword(userName, password);
        if (b) {
            logDBAccess.addRecord(userName + " logged in");
        } else {
            logDBAccess.addRecord("failed login attempt : " + userName + " | " + password);
        }
        return b;
    }

    public String getNextID() throws SQLException, ClassNotFoundException {
        return userDBAccess.getNextID();
    }
}