/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.LogDBAccess;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Salary;
import db.SalaryDBAccess;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class SalaryController {

    private SalaryDBAccess salaryDBAccess = new SalaryDBAccess();
    private LogDBAccess logDBAccess = new LogDBAccess();

    public boolean addSalary(Salary salary) throws SQLException, ClassNotFoundException {
        logDBAccess.addRecord("salary " + salary.getId() + " added");
        return salaryDBAccess.addSalary(salary);
    }

    public boolean updateSalary(Salary salary) throws SQLException, ClassNotFoundException {
        logDBAccess.addRecord("salary " + salary.getId() + " updated");
        return salaryDBAccess.updateSalary(salary);
    }

    public boolean deleteSalary(String id) throws SQLException, ClassNotFoundException {
        logDBAccess.addRecord("salary " + id + " deleted");
        return salaryDBAccess.deleteSalary(id);
    }

    public ArrayList<Salary> searchSalary(String key, String type) throws SQLException, ClassNotFoundException {
        return salaryDBAccess.searchSalary(key, type);
    }

    public ArrayList<Salary> getAllSalaries() throws SQLException, ClassNotFoundException {
        return salaryDBAccess.getAllSalaries();
    }

    public String getNextID() throws SQLException, ClassNotFoundException {
        return salaryDBAccess.getNextID();
    }
}
