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
import model.Salary;
import verification.Verify;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class SalaryDBAccess {

    private Connection connection = null;
    private Statement stm = null;

    public boolean addSalary(Salary sal) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "INSERT INTO salary VALUES('" + sal.getId() + "', '" + sal.getEmployeeID() + "',  '" + sal.getDate() + "'," + sal.getMonth() + "," + sal.getBasic() + "," + sal.getOt() + "," + sal.getAllowance() + "," + sal.getIncentive() + "," + sal.getEpf() + "," + sal.getEtf() + "," + sal.getLoans() + "," + sal.getOther() + "," + sal.getTotal() + ");";
        System.out.println("Insert : " + sql);
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public boolean updateSalary(Salary sal) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "UPDATE salary SET employeeID='" + sal.getEmployeeID() + "',date='" + sal.getDate() + "',month=" + sal.getMonth() + ",basic=" + sal.getBasic() + ",ot=" + sal.getOt() + ",allowance=" + sal.getAllowance() + ",epf=" + sal.getEpf() + ",etf=" + sal.getEtf() + ",loans=" + sal.getLoans() + ",otherDeductions=" + sal.getOther() + ",total=" + sal.getTotal() + " WHERE id='" + sal.getId() + "';";
        System.out.println("Update : " + sql);
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public boolean deleteSalary(String id) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "DELETE FROM salary WHERE id='" + id + "';";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public ArrayList<Salary> searchSalary(String key, String type) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT * FROM salary WHERE " + type + " LIKE '" + key + "%';";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<Salary> salList = new ArrayList<>();
        while (resultSet.next()) {
            Salary sal = new Salary(resultSet.getString("id"), resultSet.getString("employeeID"), resultSet.getString("date"), resultSet.getInt("month"), resultSet.getInt("basic"), resultSet.getInt("ot"), resultSet.getInt("allowance"), resultSet.getInt("incentive"), resultSet.getInt("epf"), resultSet.getInt("etf"), resultSet.getInt("loans"), resultSet.getInt("otherDeductions"), resultSet.getInt("total"));
            salList.add(sal);
        }
        return salList;
    }

    public ArrayList<Salary> getAllSalaries() throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT * FROM salary;";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<Salary> salList = new ArrayList<>();
        while (resultSet.next()) {
            Salary sal = new Salary(resultSet.getString("id"), resultSet.getString("employeeID"), resultSet.getString("date"), resultSet.getInt("month"), resultSet.getInt("basic"), resultSet.getInt("ot"), resultSet.getInt("allowance"), resultSet.getInt("incentive"), resultSet.getInt("epf"), resultSet.getInt("etf"), resultSet.getInt("loans"), resultSet.getInt("otherDeductions"), resultSet.getInt("total"));
            salList.add(sal);
        }
        return salList;
    }

    public String getNextID() throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String id = "";
        String sql = "SELECT id FROM salary ORDER BY id DESC LIMIT 1;";
        ResultSet resultSet = stm.executeQuery(sql);

        if (resultSet.next()) {
            id = resultSet.getString("id");
        } else {
            id = "SLR000000";
        }
        String newID = new Verify().getNextID(id);
        return newID;
    }
}
