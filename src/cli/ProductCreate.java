package cli;

import java.sql.SQLException;
import java.util.Scanner;

public class ProductCreate {
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
        return ProductValidator.productCreateValidator(code,name,unit,type,price,stock);
    }
}
