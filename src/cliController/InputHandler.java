package cliController;

import java.sql.SQLException;
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

  public void input() throws NotANumberException, SQLException {
    //		try {
    //      			System.out.println(
    //      					purchaseCLI.purchaseCreate(
    //      							"purchase 12-03-2023, 898374238, [11, 2, 23],[12, 2, 20],[13, 1, 50],[11, 2,
    // 23],[12, 2, 20][12, 2, 20],[13, 1, 50]"));
    //      //System.out.println(purchaseCLI.purchaseCount());
    //
    //		} catch (Exception exception) {
    //			System.err.print(exception.getMessage());
    //		}
    //    for(Product product: productService.productList()){
    //      System.out.println(product.getName());
    //	}

    // System.out.println(salesCLI.salesCreate("sales 29-05-2023, 879872329, [1,12],[2,20]"));

    // storeCLI.input("store create vels, 798798799, udumalpet, 12710272");
    try {
      System.out.println(
          storeCLI.createStore(
              "store create kkk, 9876543210, udumalpet, 127102721212138"));
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
