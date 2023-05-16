package cliController;

import dao.UnitDAO;
import entity.Product;
import java.sql.SQLException;
import service.ProductService;

public class ProductValidator {
  public static String productCreateValidator(
      String productCode, String name, String unit, String type, String price, String stock)
      throws SQLException {
    if (productCode.length() < 3 || productCode.length() > 6) {
      return "Product code length should be 2 to 6 characters";
    }
    if (name.length() < 3 || name.length() > 30) {
      return "Product name length should be 3 to 30 characters";
    }
    boolean isUnitValid;
    isUnitValid = UnitDAO.isAvailable(unit);
    if (!isUnitValid) {
      return "Unit is not available. Check Unit or Create one";
    }
    boolean isTypeValid = false;
    for (productType var : productType.values())
      if (String.valueOf(var).equals(type)) {
        isTypeValid = true;
        break;
      }
    if (!isTypeValid) {
      return "Type mismatch : Type is not available";
    }

    Product product =
        new Product(
            Integer.parseInt(productCode),
            name,
            unit,
            type,
            Integer.parseInt(price),
            Integer.parseInt(stock));
    ProductService productService = new ProductService();
    return productService.productCreate(product);
  }

  enum productType {
    shampoo,
    soap,
    groceries,
    electronics,
    stationery,
  }
}
