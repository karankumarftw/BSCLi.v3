package cliController;

import cliController.productController.ProductCLI;
import cliController.purchaseController.PurchaseCLI;
import cliController.salesController.SalesCLI;
import cliController.storeController.StoreCLI;
import cliController.storeController.StoreValidator;
import cliController.unitController.UnitCLI;
import cliController.userController.UserCLI;
import cliController.userController.UserValidator;
import java.sql.SQLException;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;
import service.*;

public class InputHandler {
  ProductService productService = new ProductService();
  UserService userService = new UserService();
  UserValidator userValidator = new UserValidator();
  PurchaseService purchaseService = new PurchaseService();
  PurchaseCLI purchaseCLI = new PurchaseCLI();
  UnitService unitService = new UnitService();
  SalesCLI salesCLI = new SalesCLI();
  StoreCLI storeCLI = new StoreCLI();
  StoreValidator storeValidator = new StoreValidator();
  ProductCLI productCLI = new ProductCLI();
  UserCLI userCLI = new UserCLI();
  UnitCLI unitCLI = new UnitCLI();
  AuthenticationService authenticationService = new AuthenticationService();
  Scanner scanner = new Scanner(System.in);

  public void authentication() throws SQLException, NotANumberException {
    while (true) {
      System.out.print("\nEnter user name : ");
      String userName = scanner.nextLine();
      System.out.print("Enter password : ");
      String password = scanner.nextLine();

      String userType = authenticationService.authenticate(userName, password);
      if (!StringUtils.isEmpty(userType)) {
        AccessControl.userType = userType;
        System.out.println("\nLOGIN SUCCESSFUL");
        input();
      } else {
        System.out.println("Incorrect username or password . . .");
      }
    }
  }

  public void input() throws SQLException {
    while (true) {
      System.out.print("> ");
      String command = scanner.nextLine();
      String[] moduleName = command.split(" ");
      switch (moduleName[0]) {
        case "product" -> productCLI.input(command);
      }
    }
  }
}
