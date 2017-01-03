/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import model.Item;
import verification.Verify;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class ItemDBAccess {

    private Connection connection = null;
    private Statement stm = null;
    private Date date = new Date();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private String d = dateFormat.format(date);
    private Calendar cal = Calendar.getInstance();

    public boolean addItem(Item it) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "INSERT INTO item VALUES('" + it.getCode() + "', '" + it.getBatchNo() + "',  '" + it.getDescription() + "'," + it.getBuyingPrice() + "," + it.getSellingPrice() + "," + it.getDiscount() + "," + it.getQtyOnHand() + ",'" + it.getSupplier() + "','" + it.getRegDate() + "','" + it.getExpDate() + "');";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public boolean updateItem(Item it) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "UPDATE item SET batchNo='" + it.getBatchNo() + "',description='" + it.getDescription() + "',buyingPrice=" + it.getBuyingPrice() + ",sellingPrice=" + it.getSellingPrice() + ",discount=" + it.getDiscount() + ",qtyOnHand=" + it.getQtyOnHand() + ",supplier='" + it.getSupplier() + "',regDate='" + it.getRegDate() + "',expDate='" + it.getExpDate() + "' WHERE code='" + it.getCode() + "';";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public boolean deleteItem(String code) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "DELETE FROM item WHERE code='" + code + "';";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public ArrayList<Item> searchItem(String key, String type) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT * FROM item WHERE " + type + " LIKE '" + key + "%';";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<Item> itList = new ArrayList<>();
        while (resultSet.next()) {
            Item it = new Item(resultSet.getString("code"), resultSet.getString("batchNo"), resultSet.getString("description"), resultSet.getDouble("buyingPrice"), resultSet.getDouble("sellingPrice"), resultSet.getDouble("discount"), resultSet.getInt("qtyOnHand"), resultSet.getString("supplier"), resultSet.getString("regDate"), resultSet.getString("expDate"));
            itList.add(it);
        }
        return itList;
    }

    public ArrayList<Item> getAllItems() throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT * FROM item;";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<Item> itList = new ArrayList<>();
        while (resultSet.next()) {
            Item it = new Item(resultSet.getString("code"), resultSet.getString("batchNo"), resultSet.getString("description"), resultSet.getDouble("buyingPrice"), resultSet.getDouble("sellingPrice"), resultSet.getDouble("discount"), resultSet.getInt("qtyOnHand"), resultSet.getString("supplier"), resultSet.getString("regDate"), resultSet.getString("expDate"));
            itList.add(it);
        }
        return itList;
    }

    public ArrayList<Item> getExpiredItems() throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT * FROM item WHERE expDate<'" + d + "' ORDER BY expDate;";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<Item> itList = new ArrayList<>();
        while (resultSet.next()) {
            Item it = new Item(resultSet.getString("code"), resultSet.getString("batchNo"), resultSet.getString("description"), resultSet.getDouble("buyingPrice"), resultSet.getDouble("sellingPrice"), resultSet.getDouble("discount"), resultSet.getInt("qtyOnHand"), resultSet.getString("supplier"), resultSet.getString("regDate"), resultSet.getString("expDate"));
            itList.add(it);
        }
        return itList;
    }

    public ArrayList<Item> getCriticalItems() throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        cal.setTime(date);
        cal.roll(Calendar.WEEK_OF_YEAR, true);

        String sql = "SELECT * FROM item WHERE expDate<'" + dateFormat.format(cal.getTime()) + "' AND expDate>'" + dateFormat.format(date) + "';";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<Item> itList = new ArrayList<>();
        while (resultSet.next()) {
            Item it = new Item(resultSet.getString("code"), resultSet.getString("batchNo"), resultSet.getString("description"), resultSet.getDouble("buyingPrice"), resultSet.getDouble("sellingPrice"), resultSet.getDouble("discount"), resultSet.getInt("qtyOnHand"), resultSet.getString("supplier"), resultSet.getString("regDate"), resultSet.getString("expDate"));
            itList.add(it);
        }
        return itList;
    }

    public String getNextID() throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String code = "";
        String sql = "SELECT code FROM item ORDER BY code DESC LIMIT 1;";
        ResultSet resultSet = stm.executeQuery(sql);

        if (resultSet.next()) {
            code = resultSet.getString("code");
        } else {
            code = "ITM000000";
        }
        String newID = new Verify().getNextID(code);
        return newID;
    }
}
