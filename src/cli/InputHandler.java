package cli;
import service.ProductService;
import service.UnitService;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class InputHandler {
	static public void Input() throws SQLException {
		ProductService productService = new ProductService();
		UnitService unitService = new UnitService();
		do {
			System.out.print("> ");
			Scanner scanner = new Scanner(System.in);
			String inputData = scanner.nextLine();
			String[] cmdBySpaceAndComma = inputData.toLowerCase().split("[ ,]");
			if (cmdBySpaceAndComma[0].equals("product") && cmdBySpaceAndComma[1].equals("create")) {
				try{
					System.out.println(ProductValidator.productCreateValidator(cmdBySpaceAndComma[2], cmdBySpaceAndComma[3], cmdBySpaceAndComma[4], cmdBySpaceAndComma[5], cmdBySpaceAndComma[6], cmdBySpaceAndComma[7]));
				} catch (Exception e ){
					System.out.println(ProductCreate.productCreateByEnter());

				}

			} else if (cmdBySpaceAndComma[0].equals("product") && cmdBySpaceAndComma[1].equals("list")) {
				ResultSet rs = productService.productList();
				while (rs.next()) {
					System.out.println(rs.getString("name"));
				}
			} else if (cmdBySpaceAndComma[0].equals("product") && cmdBySpaceAndComma[1].equals("help")) {
				System.out.println(ProductHelp.productHelp());
			} else if (cmdBySpaceAndComma[0].equals("product") && cmdBySpaceAndComma[1].equals("delete")) {
				System.out.println(productService.productDelete(cmdBySpaceAndComma[2]));
			} else if (cmdBySpaceAndComma[0].equals("unit") && cmdBySpaceAndComma[1].equals("create")) {
				try{
					System.out.println(UnitValidator.unitCreateValidator(cmdBySpaceAndComma[2], cmdBySpaceAndComma[3], cmdBySpaceAndComma[4], cmdBySpaceAndComma[5]));
				} catch (Exception e){
					System.out.println(UnitCreate.unitCreateByEnter());
				}
			} else if (cmdBySpaceAndComma[0].equals("unit") && cmdBySpaceAndComma[1].equals("delete")) {
				System.out.println(unitService.unitDelete(cmdBySpaceAndComma[2]));
			} else if (cmdBySpaceAndComma[0].equals("unit") && cmdBySpaceAndComma[1].equals("help")) {
				System.out.println(UnitHelp.unitHelp());
			} else if (cmdBySpaceAndComma[0].equals("unit") && cmdBySpaceAndComma[1].equals("list")) {
				ResultSet rs = unitService.unitList();
				while (rs.next()) {
					System.out.println(rs.getString("unit_name"));
				}
			}
		} while (true);
	}
}
