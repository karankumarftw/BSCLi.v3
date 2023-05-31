package cliController;

import java.sql.SQLException;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;
import service.*;
import service.StoreValidator;
import service.UserValidator;

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

  public void authentication() throws Exception {
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

  public void input() throws Exception {
    while (true) {
      System.out.print("> ");
      String command = scanner.nextLine();
      String[] moduleName = command.split(" ");
      if (command.equals("switch user")) {
        authentication();
      }
      if (AccessControl.userType.equals("sales")) {
        if (!moduleName[0].equals("sales")) {
          System.out.println("You are only allowed to do sales operations !!!");
        }
        salesAccess(command);
      } else if (AccessControl.userType.equals("purchase")) {
        if (!moduleName[0].equals("purchase")) {
          System.out.println("You are only allowed to do purchase operations !!!");
        }

      } else if (AccessControl.userType.equals("admin")) {
        if (moduleName[0].equals("purchase") || moduleName[0].equals("sales")) {
          System.out.println(
              "You are allowed to do Store, unit, stock, price, product, user operations");
        } else {
          adminAccess(command, moduleName[0]);
        }
      }
    }
  }

  public void adminAccess(String command, String module) throws Exception {
    switch (module) {
      case "unit" -> unitCLI.commandSplitter(command);
      case "user" -> userCLI.commandSplitter(command);
      case "product" -> productCLI.input(command);
      case "store" -> storeCLI.input(command);
    }
  }

  public void salesAccess(String command) throws SQLException {
    String[] operation = command.split(" ");

    switch (operation[1]){
      case "create" -> salesCLI.salesCreate(command);
      case "list" -> salesCLI.salesList();
    }
  }

  public void purchaseAccess() {

  }
}
