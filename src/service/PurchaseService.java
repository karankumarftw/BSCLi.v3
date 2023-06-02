package service;

import entity.Purchase;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PurchaseService {
    void create(Purchase purchase) throws SQLException;
    ArrayList<Purchase> purchaseList() throws SQLException;
    Integer purchaseCount() throws SQLException;
    Integer purchaseCountOnDate(String date) throws SQLException;
    String purchaseDelete(Integer invoice) throws SQLException;
}
