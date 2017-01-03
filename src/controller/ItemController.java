/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.LogDBAccess;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Item;
import db.ItemDBAccess;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class ItemController {

    private ItemDBAccess itemDBAccess = new ItemDBAccess();
    private LogDBAccess logDBAccess = new LogDBAccess();

    public boolean addItem(Item item) throws SQLException, ClassNotFoundException {
        logDBAccess.addRecord("item " + item.getCode() + " added");
        return itemDBAccess.addItem(item);
    }

    public boolean updateItem(Item item) throws SQLException, ClassNotFoundException {
        logDBAccess.addRecord("item " + item.getCode() + " updated");
        return itemDBAccess.updateItem(item);
    }

    public boolean deleteItem(String id) throws SQLException, ClassNotFoundException {
        logDBAccess.addRecord("item " + id + " deleted");
        return itemDBAccess.deleteItem(id);
    }

    public ArrayList<Item> searchItem(String key, String type) throws SQLException, ClassNotFoundException {
        return itemDBAccess.searchItem(key, type);
    }

    public ArrayList<Item> getAllItems() throws SQLException, ClassNotFoundException {
        return itemDBAccess.getAllItems();
    }

    public ArrayList<Item> getExpiredItems() throws SQLException, ClassNotFoundException {
        return itemDBAccess.getExpiredItems();
    }

    public ArrayList<Item> getCriticalItems() throws SQLException, ClassNotFoundException {
        return itemDBAccess.getCriticalItems();
    }

    public String getNextID() throws SQLException, ClassNotFoundException {
        return itemDBAccess.getNextID();
    }
}
