package cliController;

import java.sql.SQLException;
import service.NotANumberException;
import service.ProductService;
import service.UserService;

public class InputHandler {
  ProductService productService = new ProductService();
  UserService userService = new UserService();
  UserValidator userValidator = new UserValidator();

  public void input() throws NotANumberException, SQLException {
    try {
      productService.productListWithPageLimit("10");
    } catch (Exception error) {
      System.out.println(error.getMessage());
    }
  }
}
