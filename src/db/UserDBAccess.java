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
import model.User;
import verification.Verify;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class UserDBAccess {

    private Connection connection = null;
    private Statement stm = null;

    public boolean addUser(User user) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();
        String sql = "INSERT INTO user VALUES('" + user.getId() + "','" + user.getUserName() + "', (SELECT PASSWORD('" + user.getPassword() + "')),'" + user.getUserLevel() + "') ;";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public boolean updateUser(User user) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();
        String sql = "UPDATE user SET userName='" + user.getUserName() + "',password=(SELECT PASSWORD('" + user.getPassword() + "')),userLevel='" + user.getUserLevel() + "' WHERE id='" + user.getId() + "';";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public boolean deleteUser(String id) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();
        String sql = "DELETE FROM user WHERE id='" + id + "';";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public boolean checkPassword(String userName, String pwd) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT * FROM user WHERE username='" + userName + "' AND password=(SELECT PASSWORD('" + pwd + "'));";
        ResultSet resultSet = connection.createStatement().executeQuery(sql);

        if (resultSet.first()) {
            return true;
        } else {
            return false;
        }
    }

    public User getUser(String userName) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT * FROM user WHERE userName='" + userName + "';";
        ResultSet resultSet = stm.executeQuery(sql);

        User user = null;
        while (resultSet.next()) {
            user = new User(resultSet.getString("id"), resultSet.getString("userName"), "", resultSet.getString("userLevel"));
        }
        return user;
    }

    public ArrayList<User> getAllUsers() throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT * FROM user;";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<User> userList = new ArrayList<>();
        while (resultSet.next()) {
            User user = new User(resultSet.getString("id"), resultSet.getString("userName"), "", resultSet.getString("userLevel"));
            userList.add(user);
        }
        return userList;
    }

    public String getNextID() throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();
        String lastID = null, nextID = null;

        String sql = "SELECT id FROM user ORDER BY id desc LIMIT 1;";

        ResultSet resultSet = stm.executeQuery(sql);
        if (resultSet.next()) {
            lastID = resultSet.getString(1);
        }

        if (lastID.equals("")) {
            lastID = "USR000000";
        }

        nextID = new Verify().getNextID(lastID);
        return nextID;
    }
}
