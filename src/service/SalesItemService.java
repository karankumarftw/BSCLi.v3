package service;

import dao.PurchaseItemDAO;
import dao.SalesItemDAO;
import entity.PurchaseItem;
import entity.SalesItem;

import java.sql.SQLException;
import java.util.ArrayList;

public class SalesItemService {
	public void createNewSalesItems(int invoiceNo, ArrayList<SalesItem> salesItems)
			throws SQLException {
		SalesItemDAO salesItemDAO = new SalesItemDAO();
		for (SalesItem salesItem : salesItems) {
			salesItemDAO.insertSalesItem(invoiceNo, salesItem);
		}

	}
}
