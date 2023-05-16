package cliController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import service.ProductService;
import service.UnitService;
import service.UserService;

public class InputHandler {
  public static void Input() throws SQLException {
    ProductService productService = new ProductService();
    UnitService unitService = new UnitService();
    do {
      System.out.print("> ");
      Scanner scanner = new Scanner(System.in);
      String inputData = scanner.nextLine();
      String[] cmdBySpaceAndComma = inputData.toLowerCase().split("[ ,]");

      switch (cmdBySpaceAndComma[0]) {
          // This is product Routing
        case "product":
          {
            if (cmdBySpaceAndComma[2].equals("help")) {
              System.out.println(ProductHelp.productHelp());
            }
            break;
          }

          // This is unit Routing
        case "unit":
          {
            if (cmdBySpaceAndComma[1].equals("help")) {
              System.out.println(UnitHelp.unitEditHelp());
            } else if (cmdBySpaceAndComma[1].equals("create")) {
              try {
                UnitValidator.unitCreateValidator(
                    cmdBySpaceAndComma[1],
                    cmdBySpaceAndComma[2],
                    cmdBySpaceAndComma[3],
                    cmdBySpaceAndComma[4],
                    cmdBySpaceAndComma[5]);
              } catch (Exception error) {
                UnitCreate.unitCreateByEnter();
              }
            }
          }

          // This is user Routing
        case "user":
          {
            UserService userService = new UserService();
            if (cmdBySpaceAndComma[1].equals("help")) {
              System.out.println(UserHelp.userHelp());
            } else if (cmdBySpaceAndComma[1].equals("create")) {
              System.out.println(UserCreateByEnter.userCreateByEnter());
            } else if (cmdBySpaceAndComma[1].equals("delete")) {
              System.out.println(userService.userDelete(Integer.parseInt(cmdBySpaceAndComma[2])));
            } else if (cmdBySpaceAndComma[1].equals("list")) {
              ResultSet rs = userService.userList();
              while (rs.next()) {
                System.out.println(rs.getString("user_name"));
              }
            }
          }
      }

      //      if (cmdBySpaceAndComma[0].equals("product") && cmdBySpaceAndComma[1].equals("create"))
      // {
      //        try {
      //          System.out.println(
      //              ProductValidator.productCreateValidator(
      //                  cmdBySpaceAndComma[2],
      //                  cmdBySpaceAndComma[3],
      //                  cmdBySpaceAndComma[4],
      //                  cmdBySpaceAndComma[5],
      //                  cmdBySpaceAndComma[6],
      //                  cmdBySpaceAndComma[7]));
      //        } catch (Exception e) {
      //          System.out.println(ProductCreate.productCreateByEnter());
      //        }
      //      } else if (cmdBySpaceAndComma[0].equals("product") &&
      // cmdBySpaceAndComma[1].equals("list")) {
      //        try {
      //          ResultSet rs =
      //              productService.productListWithPageLimitAndPageCount(
      //                  cmdBySpaceAndComma[3], cmdBySpaceAndComma[4]);
      //          while (rs.next()) {
      //            System.out.println(rs.getString("name"));
      //          }
      //        } catch (Exception error) {
      //          try {
      //            ResultSet rs = productService.productListWithPageLimit(cmdBySpaceAndComma[3]);
      //            while (rs.next()) {
      //              System.out.println(rs.getString("name"));
      //            }
      //          } catch (Exception err) {
      //            ResultSet rs = productService.productList();
      //            while (rs.next()) {
      //              System.out.println(rs.getString("name"));
      //            }
      //          }
      //        }
      //
      //      } else if (cmdBySpaceAndComma[0].equals("product") &&
      // cmdBySpaceAndComma[1].equals("help")) {
      //        System.out.println(ProductHelp.productHelp());
      //      } else if (cmdBySpaceAndComma[0].equals("product")
      //          && cmdBySpaceAndComma[1].equals("delete")) {
      //        System.out.println(productService.productDelete(cmdBySpaceAndComma[2]));
      //      } else if (cmdBySpaceAndComma[0].equals("unit") &&
      // cmdBySpaceAndComma[1].equals("create")) {
      //        try {
      //          System.out.println(
      //              UnitValidator.unitCreateValidator(
      //                  cmdBySpaceAndComma[1],
      //                  cmdBySpaceAndComma[2],
      //                  cmdBySpaceAndComma[3],
      //                  cmdBySpaceAndComma[4],
      //                  cmdBySpaceAndComma[5]));
      //        } catch (Exception e) {
      //          System.out.println(UnitCreate.unitCreateByEnter());
      //        }
      //      } else if (cmdBySpaceAndComma[0].equals("unit") &&
      // cmdBySpaceAndComma[1].equals("delete")) {
      //        System.out.println(unitService.unitDelete(cmdBySpaceAndComma[2]));
      //      } else if (cmdBySpaceAndComma[0].equals("unit") &&
      // cmdBySpaceAndComma[1].equals("help")) {
      //        System.out.println(UnitHelp.unitHelp());
      //      } else if (cmdBySpaceAndComma[0].equals("unit") &&
      // cmdBySpaceAndComma[1].equals("list")) {
      //        ResultSet rs = unitService.unitList();
      //        while (rs.next()) {
      //          System.out.println(
      //              String.format("%20s", rs.getString("unit_code"))
      //                  + String.format("%20s", rs.getString("unit_name"))
      //                  + String.format("%40s", rs.getString("description"))
      //                  + String.format("%20s", rs.getString("is_dividable")));
      //        }
      //      } else if (cmdBySpaceAndComma[0].equals("unit") &&
      // cmdBySpaceAndComma[1].equals("edit")) {
      //        try {
      //          System.out.println(
      //              UnitValidator.unitCreateValidator(
      //                  cmdBySpaceAndComma[1],
      //                  cmdBySpaceAndComma[2],
      //                  cmdBySpaceAndComma[3],
      //                  cmdBySpaceAndComma[4],
      //                  cmdBySpaceAndComma[5]));
      //        } catch (Exception e) {
      //          System.out.println(UnitEdit.unitEditByEnter());
      //        }
      //      } else if(cmdBySpaceAndComma[0].equals("product") &&
      // cmdBySpaceAndComma[1].equals("edit")){
      //          try {
      //              System.out.println(
      //                      ProductValidator.productCreateValidator(
      //                              cmdBySpaceAndComma[2],
      //                              cmdBySpaceAndComma[3],
      //                              cmdBySpaceAndComma[4],
      //                              cmdBySpaceAndComma[5],
      //                              cmdBySpaceAndComma[6],
      //                              cmdBySpaceAndComma[7]));
      //          } catch (Exception e) {
      //              System.out.println(ProductEditByEnter.productEditByEnter());
      //          }
      //      } else if(cmdBySpaceAndComma[0].equals("user")){
      //        if(cmdBySpaceAndComma[1].equals("help")){
      //          UserHelp.userHelp();
      //        }
      //      }
    } while (true);
  }

  class UnitCreate {
    static String unitCreateByEnter() throws SQLException {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Unit Name : ");
      String unitName = scanner.nextLine();
      System.out.print("Unit code : ");
      String unitCode = scanner.nextLine();
      System.out.print("Unit description : ");
      String unitDescription = scanner.nextLine();
      System.out.print("is Dividable : ");
      String isDividable = scanner.nextLine();
      return UnitValidator.unitCreateValidator(
          "create", unitName, unitCode, unitDescription, isDividable);
    }
  }

  class UnitEdit {
    static String unitEditByEnter() throws SQLException {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Unit Name : ");
      String unitName = scanner.next();
      System.out.print("Unit code : ");
      String unitCode = scanner.next();
      System.out.print("Unit description : ");
      String unitDescription = scanner.next();
      System.out.print("is Dividable : ");
      String isDividable = scanner.next();
      return UnitValidator.unitCreateValidator(
          "edit", unitName, unitCode, unitDescription, isDividable);
    }
  }

  class ProductCreate {
    static String productCreateByEnter() throws SQLException {
      Scanner scanner = new Scanner(System.in);
      System.out.print("code : ");
      String code = scanner.nextLine();
      System.out.println("name : ");
      String name = scanner.nextLine();
      System.out.print("unit : ");
      String unit = scanner.nextLine();
      System.out.print("type : ");
      String type = scanner.nextLine();
      System.out.print("price : ");
      String price = scanner.nextLine();
      System.out.print("Stock (If no stock just leave it and press Enter) : ");
      String stock = scanner.nextLine();
      return ProductValidator.productCreateValidator(code, name, unit, type, price, stock);
    }
  }

  class ProductEditByEnter {
    static String productEditByEnter() throws SQLException {
      Scanner scanner = new Scanner(System.in);
      System.out.print("code : ");
      String code = scanner.nextLine();
      System.out.println("name : ");
      String name = scanner.nextLine();
      System.out.print("unit : ");
      String unit = scanner.nextLine();
      System.out.print("type : ");
      String type = scanner.nextLine();
      System.out.print("price : ");
      String price = scanner.nextLine();
      System.out.print("Stock (If no stock just leave it and press Enter) : ");
      String stock = scanner.nextLine();
      return ProductValidator.productCreateValidator(code, name, unit, type, price, stock);
    }
  }

  class UnitHelp {
    static String unitEditHelp() {
      return "Edit unit using the following template\n"
          + "id: <id - 6>, name: <name-edited>, code: <code>,  description: <description>, isdividable: <isdividable>\n"
          + "\n"
          + "You can also restrict the user data by editable attributes. Id attribute is mandatory for all the edit operation.\n"
          + "id: <id - 6>, name: <name>, code: <code>\n"
          + "\n"
          + "You can not give empty or null values to the mandatory attributes.\n"
          + "id: <id - 6>, name: , code: null\n"
          + "\n"
          + "\t\t name - text, mandatory with 3 to 30 chars\t\n"
          + "     code - text, maximum 4 char, mandatory\n"
          + "     description - text\n"
          + "     isdividable - boolean, mandatory\n"
          + "     \n"
          + "unit edit id: <id - 6>, name: <name-edited>, code: <code>,  description: <description>, isdividable: <isdividable>\n"
          + "\n"
          + "\t\t\t\t\t\t\t\t\t\t\t\tor\n"
          + "\t\t\t\t\t\t\t\t\t\t\t\t\n"
          + "user edit :enter\n"
          + "id: <id - 6>, name: <name-edited>, code: <usernamcodee>,  description: <description>, isdividable: <isdividable>\n"
          + "\n"
          + "\t\t\t\t\t\t\t\t\t\t\t\t\tor\n"
          + " id: <id - 6>, name: <name-edited>, code: <code-edited>\t";
    }

    static String unitCreateHelp() {

      return null;
    }
  }

  class ProductHelp {
    static String productHelp() {
      return "create product using the following template\n"
          + "code, name, unit, type, price, stock\n"
          + "\t\n"
          + "\tcode - text, min - 2 - 6, mandatory\n"
          + "\tname - text, min 3 - 30 char, mandatory\n"
          + "\tunitcode - text, kg/l/piece/combo, mandatory\n"
          + "\ttype - text, between enumerated values, mandatory \n"
          + "\tprice - number, mandatory\n"
          + "\tstock - number, default 0\n"
          + "\t\n"
          + "\tproduct create code, productname, unitcode, type, costprice\n"
          + "                         or\n"
          + "product create :enter\n"
          + "code, name, unitcode, type, costprice";
    }
  }

  class UserHelp {
    static String userHelp() {
      return "Create unit using the following template,\n"
          + "     name, code, description, isdividable\n"
          + "     \n"
          + "     name - text, mandatory with 3 to 30 chars\t\n"
          + "     code - text, maximum 4 char, mandatory\n"
          + "     description - text\n"
          + "     isdividable - boolean, mandatory\n"
          + "    \n"
          + "> unit create name, code, description, isdividable\n"
          + "\t\t\t\t\t\t\tor\n"
          + "\tunit create :enter\n"
          + "\tname, code, description, isdividable";
    }
  }

  class UserCreateByEnter {
    static String userCreateByEnter() throws SQLException {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Enter user Type : ");
      String userType = scanner.nextLine();
      System.out.print("Enter user name : ");
      String userName = scanner.nextLine();
      System.out.print("Enter password : ");
      String userPassword = scanner.nextLine();
      System.out.print("Enter first name : ");
      String userFirstName = scanner.nextLine();
      System.out.print("Enter last name : ");
      String userLastName = scanner.nextLine();
      System.out.print("Enter phone number : ");
      String userPhoneNumber = scanner.nextLine();

      return UserValidator.userValidator(
          userType, userName, userPassword, userFirstName, userLastName, userPhoneNumber);
    }
  }
}
