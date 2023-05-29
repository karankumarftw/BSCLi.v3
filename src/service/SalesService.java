package service;

import dao.SalesDAO;
import entity.Purchase;
import entity.Sales;

import java.sql.SQLException;

public class SalesService {

	private SalesDAO salesDAO = new SalesDAO();
	public String newSales(Sales sales) throws SQLException {

		boolean successOrFail = salesDAO.createSales(sales);

		if (successOrFail) {
			return "New sale is successful";
		}
		return "Sales failed";
	}
}
