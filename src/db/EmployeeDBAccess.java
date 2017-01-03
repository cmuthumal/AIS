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
import model.Employee;
import verification.Verify;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class EmployeeDBAccess {

    private Connection connection = null;
    private Statement stm = null;

    public boolean addEmployee(Employee emp) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "INSERT INTO employee VALUES('" + emp.getId() + "', '" + emp.getName() + "',  '" + emp.getAddress() + "'," + emp.getMobile() + "," + emp.getPhone() + "," + emp.getNic() + ",'" + emp.getRegDate() + "');";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public boolean updateEmployee(Employee emp) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "UPDATE employee SET name='" + emp.getName() + "',address='" + emp.getAddress() + "',mobile=" + emp.getMobile() + ",phone=" + emp.getPhone() + ",nic=" + emp.getNic() + ",regDate='" + emp.getRegDate() + "' WHERE id='" + emp.getId() + "';";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public boolean deleteEmployee(String id) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "DELETE FROM employee WHERE id='" + id + "';";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public ArrayList<Employee> searchEmployee(String key, String type) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT * FROM employee WHERE " + type + " LIKE '" + key + "%';";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<Employee> empList = new ArrayList<>();
        while (resultSet.next()) {
            Employee emp = new Employee(resultSet.getString("id"), resultSet.getString("name"), resultSet.getString("address"), resultSet.getInt("mobile"), resultSet.getInt("phone"), resultSet.getInt("nic"), resultSet.getString("regDate"));
            empList.add(emp);
        }
        return empList;
    }

    public ArrayList<Employee> getAllEmployees() throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT * FROM employee;";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<Employee> empList = new ArrayList<>();
        while (resultSet.next()) {
            Employee emp = new Employee(resultSet.getString("id"), resultSet.getString("name"), resultSet.getString("address"), resultSet.getInt("mobile"), resultSet.getInt("phone"), resultSet.getInt("nic"), resultSet.getString("regDate"));
            empList.add(emp);
        }
        return empList;
    }

    public String getNextID() throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String id = "";
        String sql = "SELECT id FROM employee ORDER BY id DESC LIMIT 1;";
        ResultSet resultSet = stm.executeQuery(sql);

        if (resultSet.next()) {
            id = resultSet.getString("id");
        } else {
            id = "EMP000000";
        }
        String newID = new Verify().getNextID(id);
        return newID;
    }
}
