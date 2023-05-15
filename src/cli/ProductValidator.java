package cli;

import dao.UnitDAO;
import modules.product.ProductCreateWithAttributes;

import java.sql.SQLException;

public class ProductValidator {
  enum productType {
    shampoo,
    soap,
    groceries,
    electronics,
    stationery,
  }

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
    if (UnitDAO.isAvailable(unit)) isUnitValid = true;
    else isUnitValid = false;
    if (!isUnitValid) {
      return "Unit is not available. Check Unit or Create one";
    }
    boolean isTypeValid = false;
    for (productType var : productType.values())
      if (String.valueOf(var).equals(type)) {
        isTypeValid = true;
      }
    if (!isTypeValid) {
      return "Type mismatch : Type is not available";
    }
    return ProductCreateWithAttributes.create(
        Integer.parseInt(productCode),
        name,
        unit,
        type,
        Double.parseDouble(price),
        Double.parseDouble(stock));
  }
}
