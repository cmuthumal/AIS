/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.LogDBAccess;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Employee;
import db.EmployeeDBAccess;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class EmployeeController {

    private EmployeeDBAccess employeeDBAccess = new EmployeeDBAccess();
    private LogDBAccess logDBAccess = new LogDBAccess();

    public boolean addEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        logDBAccess.addRecord("employee " + employee.getId() + " added");
        return employeeDBAccess.addEmployee(employee);
    }

    public boolean updateEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        logDBAccess.addRecord("employee " + employee.getId() + " updated");
        return employeeDBAccess.updateEmployee(employee);
    }

    public boolean deleteEmployee(String id) throws SQLException, ClassNotFoundException {
        logDBAccess.addRecord("employee " + id + " deleted");
        return employeeDBAccess.deleteEmployee(id);
    }

    public ArrayList<Employee> searchEmployee(String key, String type) throws SQLException, ClassNotFoundException {
        return employeeDBAccess.searchEmployee(key, type);
    }

    public ArrayList<Employee> getAllEmployees() throws SQLException, ClassNotFoundException {
        return employeeDBAccess.getAllEmployees();
    }

    public String getNextID() throws SQLException, ClassNotFoundException {
        return employeeDBAccess.getNextID();
    }
}
