package service;

import dao.UnitDAOImplementation;
import entity.Product;
import java.sql.SQLException;

public class ProductValidator {
  UnitDAOImplementation unitDAO = new UnitDAOImplementation();
  // String code, String name, String unit, String type, String price, String stock
  public Boolean validator(Product product)
      throws SQLException, ProductNotValidException, NotANumberException {

    String code = String.valueOf(product.getCode());
    String name = product.getName();
    String unit = product.getUnitCode();
    String type = product.getType();
    String price = String.valueOf(product.getPrice());
    String stock = String.valueOf(product.getStock());
    if (code.length() < 3 || code.length() > 6) {
      throw new ProductNotValidException("Product code length should be 2 to 6 characters");
    }
    int productCode;
    try {
      productCode = Integer.parseInt(code);
    } catch (Exception e) {
      throw new NotANumberException("Product code should be a whole number");
    }
    if (name.length() < 3 || name.length() > 30) {
      throw new ProductNotValidException("Product name length should be 3 to 30 characters");
    }
    boolean isUnitValid;
    isUnitValid = unitDAO.isAvailable(unit);
    if (!isUnitValid) {
      throw new ProductNotValidException("Unit is not available. Check Unit or Create one");
    }
    boolean isTypeValid = false;
    for (productType var : productType.values())
      if (String.valueOf(var).equals(type)) {
        isTypeValid = true;
        break;
      }
    if (!isTypeValid) {
      throw new ProductNotValidException("Type mismatch : Type is not available");
    }

    double productPrice;
    try {
      productPrice = Double.parseDouble(price);
    } catch (Exception e) {
      throw new NotANumberException("The price of the product should be numeric");
    }

    double productStock;
    try {
      productStock = Double.parseDouble(stock);
    } catch (Exception e) {
      throw new NotANumberException("The product stock should be numeric");
    }

    return true;
  }

  enum productType {
    shampoo,
    soap,
    groceries,
    electronics,
    stationery,
    vegetables,
    oil,
    others
  }
}
