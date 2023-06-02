package service;

import entity.Sales;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SalesService {
    public void create(Sales sales) throws SQLException;
    public int count() throws SQLException;
    public int countOnDate(String date) throws SQLException;
    public ArrayList<Sales> list();
}
