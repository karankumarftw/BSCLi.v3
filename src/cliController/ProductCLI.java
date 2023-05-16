package cliController;

import java.sql.SQLException;
import java.util.Scanner;

public class ProductCLI {
    ProductValidator productValidator = new ProductValidator();

    class ProductCreate {
        String productCreateByEnter() throws SQLException {
            Scanner scanner = new Scanner(System.in);
            System.out.print("> ");
            String[] productCreateInput = scanner.nextLine().split("[, ]");
            return productValidator.productCreateValidator(
                    productCreateInput[0],
                    productCreateInput[1],
                    productCreateInput[2],
                    productCreateInput[3],
                    productCreateInput[4],
                    productCreateInput[5]);
        }
    }

    class ProductEditByEnter {
        ProductValidator productValidator = new ProductValidator();

        String productEditByEnter() throws SQLException {
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
            return productValidator.productCreateValidator(code, name, unit, type, price, stock);
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
}
