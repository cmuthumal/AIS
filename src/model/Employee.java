/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class Employee {

    private String id;
    private String name;
    private String address;
    private int mobile;
    private int phone;
    private int nic;
    private String regDate;

    public Employee(String id, String name, String address, int mobile, int phone, int nic, String regDate) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.mobile = mobile;
        this.phone = phone;
        this.nic = nic;
        this.regDate = regDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getNic() {
        return nic;
    }

    public void setNic(int nic) {
        this.nic = nic;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }
}
