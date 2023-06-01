package service;

import entity.Sales;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SalesServiceInterface {
    public String newSales(Sales sales) throws SQLException;
    public int salesCount() throws SQLException;
    public int salesCountOnDate(String date) throws SQLException;
    public ArrayList<Sales> salesList();
}
