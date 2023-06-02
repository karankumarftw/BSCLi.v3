package service;

import dao.ProductDAOImplementation;
import entity.Product;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductServiceImplementation implements ProductService {
	ProductDAOImplementation productDAO = new ProductDAOImplementation();
	ProductValidator productValidator = new ProductValidator();

	public String delete(String code) throws NotANumberException {
		try {
			return productDAO.delete(code);
		} catch (Exception e) {
			throw new NotANumberException("Product code should be a number");
		}
	}

	public ArrayList<Product> list() throws SQLException {
		return productDAO.list();
	}

	public String create(Product product) throws ProductNotValidException {
		try {
			productValidator.validator(product);
			return productDAO.create(product);
		} catch (Exception e) {
			throw new ProductNotValidException(e.getMessage());
		}
	}

	public Integer count() throws SQLException {
		return productDAO.count();
	}

	public String edit(Product product) throws ProductNotValidException {
		try {
			productValidator.validator(product);
			return productDAO.edit(product);
		} catch (Exception e) {
			throw new ProductNotValidException(e.getMessage());
		}
	}

	public ArrayList<Product> listWithPageLimit(String pageLimit) throws NotANumberException {
		try {
			return productDAO.listWithPageLimit(Integer.parseInt(pageLimit));
		} catch (Exception e) {
			throw new NotANumberException("Page count should be a number");
		}
	}

	public ArrayList<Product> listWithPageLimitAndPageCount(String pageLimit, String pageCount)
			throws NotANumberException {
		try {
			return productDAO.listWithPageLimitAndPageCount(
					Integer.parseInt(pageLimit), Integer.parseInt(pageCount));
		} catch (Exception e) {
			throw new NotANumberException("Page Count and Page number should be numbers");
		}
	}

	public ArrayList<Product> globalSearch(String searchValue) throws SQLException {
		return productDAO.globalSearch(searchValue);
	}

	public Double getItemPrice(int code) throws SQLException {

		return productDAO.getItemPrice(code);
	}

	public ArrayList<Product> searchWithAttribute(String attr, String searchValue)
			throws SQLException {

		return productDAO.searchWithAttribute(attr, searchValue);
	}

	public ArrayList<Product> searchWithAttributeWithPaging(
			String attr, String searchValue, int pageLimit, int pageCount) throws SQLException {
		return productDAO.searchWithAttributeAndPaging(attr, searchValue, pageLimit, pageCount);
	}

	public String priceUpdate(String productCode, String newPrice) throws NotANumberException {
		try {
			int code = Integer.parseInt(productCode);
			Double price = Double.parseDouble(newPrice);
			return productDAO.priceUpdate(code, price);
		} catch (Exception e) {
			throw new NotANumberException("Code and price should be numeric values");
		}
	}

	public String productStockUpdate(String productCode, String newStock) throws NotANumberException {
		try {
			int code = Integer.parseInt(productCode);
			Double stock = Double.parseDouble(newStock);
			return productDAO.stockUpdate(code, stock);
		} catch (Exception e) {
			throw new NotANumberException("Code and stock should be numeric values");
		}
	}
}