/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.LogDBAccess;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Supplier;
import db.SupplierDBAccess;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class SupplierController {

    private SupplierDBAccess supplierDBAccess = new SupplierDBAccess();
    private LogDBAccess logDBAccess = new LogDBAccess();

    public boolean addSupplier(Supplier supplier) throws SQLException, ClassNotFoundException {
        logDBAccess.addRecord("supplier " + supplier.getId() + " added");
        return supplierDBAccess.addSupplier(supplier);
    }

    public boolean updateSupplier(Supplier supplier) throws SQLException, ClassNotFoundException {
        logDBAccess.addRecord("supplier " + supplier.getId() + " updated");
        return supplierDBAccess.updateSupplier(supplier);
    }

    public boolean deleteSupplier(String id) throws SQLException, ClassNotFoundException {
        logDBAccess.addRecord("supplier " + id + " deleted");
        return supplierDBAccess.deleteSupplier(id);
    }

    public ArrayList<Supplier> searchSupplier(String key, String type) throws SQLException, ClassNotFoundException {
        return supplierDBAccess.searchSupplier(key, type);
    }

    public ArrayList<Supplier> getAllSuppliers() throws SQLException, ClassNotFoundException {
        return supplierDBAccess.getAllSuppliers();
    }

    public String getNextID() throws SQLException, ClassNotFoundException {
        return supplierDBAccess.getNextID();
    }
}
