/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class Salary {

    private String id;
    private String employeeID;
    private String date;
    private int month;
    private int basic;
    private int ot;
    private int allowance;
    private int incentive;
    private int epf;
    private int etf;
    private int loans;
    private int other;
    private int total;

    public Salary(String id, String employeeID, String date, int month, int basic, int ot, int allowance, int incentive, int epf, int etf, int loans, int other, int total) {
        this.id = id;
        this.employeeID = employeeID;
        this.date = date;
        this.month = month;
        this.basic = basic;
        this.ot = ot;
        this.allowance = allowance;
        this.incentive = incentive;
        this.epf = epf;
        this.etf = etf;
        this.loans = loans;
        this.other = other;
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getBasic() {
        return basic;
    }

    public void setBasic(int basic) {
        this.basic = basic;
    }

    public int getOt() {
        return ot;
    }

    public void setOt(int ot) {
        this.ot = ot;
    }

    public int getAllowance() {
        return allowance;
    }

    public void setAllowance(int allowance) {
        this.allowance = allowance;
    }

    public int getIncentive() {
        return incentive;
    }

    public void setIncentive(int incentive) {
        this.incentive = incentive;
    }

    public int getEpf() {
        return epf;
    }

    public void setEpf(int epf) {
        this.epf = epf;
    }

    public int getEtf() {
        return etf;
    }

    public void setEtf(int etf) {
        this.etf = etf;
    }

    public int getLoans() {
        return loans;
    }

    public void setLoans(int loans) {
        this.loans = loans;
    }

    public int getOther() {
        return other;
    }

    public void setOther(int other) {
        this.other = other;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
