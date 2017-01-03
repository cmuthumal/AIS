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
import model.Customer;
import verification.Verify;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class CustomerDBAccess {

    private Connection connection = null;
    private Statement stm = null;

    public boolean addCustomer(Customer cus) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "INSERT INTO customer VALUES('" + cus.getId() + "', '" + cus.getName() + "',  '" + cus.getAddress() + "'," + cus.getMobile() + "," + cus.getPhone() + ",'" + cus.getRegDate() + "');";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public boolean updateCustomer(Customer cus) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "UPDATE customer SET name='" + cus.getName() + "',address='" + cus.getAddress() + "',mobile=" + cus.getMobile() + ",phone=" + cus.getPhone() + ",regDate='" + cus.getRegDate() + "' WHERE id='" + cus.getId() + "';";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "DELETE FROM customer WHERE id='" + id + "';";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public ArrayList<Customer> searchCustomer(String key, String type) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT * FROM customer WHERE " + type + " LIKE '" + key + "%';";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<Customer> cusList = new ArrayList<>();
        while (resultSet.next()) {
            Customer cus = new Customer(resultSet.getString("id"), resultSet.getString("name"), resultSet.getString("address"), resultSet.getInt("mobile"), resultSet.getInt("phone"), resultSet.getString("regDate"));
            cusList.add(cus);
        }
        return cusList;
    }

    public ArrayList<Customer> getAllCustomers() throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT * FROM customer;";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<Customer> cusList = new ArrayList<>();
        while (resultSet.next()) {
            Customer cus = new Customer(resultSet.getString("id"), resultSet.getString("name"), resultSet.getString("address"), resultSet.getInt("mobile"), resultSet.getInt("phone"), resultSet.getString("regDate"));
            cusList.add(cus);
        }
        return cusList;
    }

    public String getNextID() throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String id = "";
        String sql = "SELECT id FROM customer ORDER BY id DESC LIMIT 1;";
        ResultSet resultSet = stm.executeQuery(sql);

        if (resultSet.next()) {
            id = resultSet.getString("id");
        } else {
            id = "CUS000000";
        }
        String newID = new Verify().getNextID(id);
        return newID;
    }
}
