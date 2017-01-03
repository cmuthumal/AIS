/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.LogDBAccess;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Customer;
import db.CustomerDBAccess;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class CustomerController {

    private CustomerDBAccess customerDBAccess = new CustomerDBAccess();
    private LogDBAccess logDBAccess = new LogDBAccess();

    public boolean addCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        logDBAccess.addRecord("customer " + customer.getId() + " added");
        return customerDBAccess.addCustomer(customer);
    }

    public boolean updateCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        logDBAccess.addRecord("customer " + customer.getId() + " updated");
        return customerDBAccess.updateCustomer(customer);
    }

    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        logDBAccess.addRecord("customer " + id + " deleted");
        return customerDBAccess.deleteCustomer(id);
    }

    public ArrayList<Customer> searchCustomer(String key, String type) throws SQLException, ClassNotFoundException {
        return customerDBAccess.searchCustomer(key, type);
    }

    public ArrayList<Customer> getAllCustomers() throws SQLException, ClassNotFoundException {
        return customerDBAccess.getAllCustomers();
    }

    public String getNextID() throws SQLException, ClassNotFoundException {
        return customerDBAccess.getNextID();
    }
}
