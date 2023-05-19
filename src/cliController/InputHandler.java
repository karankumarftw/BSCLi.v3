package cliController;

import java.sql.SQLException;
import service.NotANumberException;
import service.ProductService;
import service.PurchaseService;
import service.UserService;

public class InputHandler {
	ProductService productService = new ProductService();
	UserService userService = new UserService();
	UserValidator userValidator = new UserValidator();
	PurchaseService purchaseService = new PurchaseService();
	PurchaseCLI purchaseCLI = new PurchaseCLI();

	public void input() throws NotANumberException, SQLException {
		try {
      			System.out.println(
      					purchaseCLI.purchaseCreate(
      							"purchase 12-03-2023, 898374238, [11, 2, 23],[12, 2, 20],[13, 1, 50],[11, 2, 23],[12, 2, 20][12, 2, 20],[13, 1, 50]"));
      //System.out.println(purchaseCLI.purchaseCount());

		} catch (Exception exception) {
			System.err.print(exception.getMessage());
		}
	}
}
