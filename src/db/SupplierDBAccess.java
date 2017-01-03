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
import model.Supplier;
import verification.Verify;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class SupplierDBAccess {

    private Connection connection = null;
    private Statement stm = null;

    public boolean addSupplier(Supplier sup) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "INSERT INTO supplier VALUES('" + sup.getId() + "', '" + sup.getName() + "',  '" + sup.getAddress() + "'," + sup.getMobile() + "," + sup.getPhone() + ",'" + sup.getRegDate() + "');";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public boolean updateSupplier(Supplier sup) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "UPDATE supplier SET name='" + sup.getName() + "',address='" + sup.getAddress() + "',mobile=" + sup.getMobile() + ",phone=" + sup.getPhone() + ",regDate='" + sup.getRegDate() + "' WHERE id='" + sup.getId() + "';";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public boolean deleteSupplier(String id) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "DELETE FROM supplier WHERE id='" + id + "';";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public ArrayList<Supplier> searchSupplier(String key, String type) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT * FROM supplier WHERE " + type + " LIKE '" + key + "%';";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<Supplier> supList = new ArrayList<>();
        while (resultSet.next()) {
            Supplier sup = new Supplier(resultSet.getString("id"), resultSet.getString("name"), resultSet.getString("address"), resultSet.getInt("mobile"), resultSet.getInt("phone"), resultSet.getString("regDate"));
            supList.add(sup);
        }
        return supList;
    }

    public ArrayList<Supplier> getAllSuppliers() throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT * FROM supplier;";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<Supplier> supList = new ArrayList<>();
        while (resultSet.next()) {
            Supplier sup = new Supplier(resultSet.getString("id"), resultSet.getString("name"), resultSet.getString("address"), resultSet.getInt("mobile"), resultSet.getInt("phone"), resultSet.getString("regDate"));
            supList.add(sup);
        }
        return supList;
    }

    public String getNextID() throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String id = "";
        String sql = "SELECT id FROM supplier ORDER BY id DESC LIMIT 1;";
        ResultSet resultSet = stm.executeQuery(sql);

        if (resultSet.next()) {
            id = resultSet.getString("id");
        } else {
            id = "SUP000000";
        }
        String newID = new Verify().getNextID(id);
        return newID;
    }
}
