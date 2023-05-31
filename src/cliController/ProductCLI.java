package cliController;

import entity.Product;
import java.sql.SQLException;
import java.util.Scanner;
import service.NotANumberException;
import service.ProductNotValidException;
import service.ProductService;
import service.ProductValidator;

public class ProductCLI {
  private ProductValidator productValidator = new ProductValidator();
  private ProductService productService = new ProductService();

  public void input(String command)
      throws SQLException, ProductNotValidException, NotANumberException {
    String[] commandSplit = command.split("[ ,]");
    int elementCount = commandSplit.length;

    if (elementCount < 3) {
      switch (commandSplit[1]) {
        case "create" -> productCreateByEnter();
        case "edit" -> productEditByEnter();
        case "list" -> productList();
      }
    } else if (commandSplit[2].equals("help")) {
      switch (commandSplit[1]) {
        case "create" -> productCreateHelp();
        case "list" -> productListHelp();
        case "edit" -> productEditHelp();
        case "delete" -> productDeleteHelp();
      }
    } else if (commandSplit[1].equals("delete")) {
      productService.productDelete(commandSplit[2]);
    }
  }


  void productList() throws SQLException {
    for (Product product : productService.productList()) {
      System.out.println(product.getName());
    }
  }

  String productCreateByEnter() throws SQLException, ProductNotValidException {
    Scanner scanner = new Scanner(System.in);
   try{
     System.out.print("> ");
     String[] productCreateInput = scanner.nextLine().split("[, ]");
     Product product =
             new Product(
                     Integer.parseInt(productCreateInput[0]),
                     productCreateInput[1],
                     productCreateInput[2],
                     productCreateInput[3],
                     Double.parseDouble(productCreateInput[4]),
                     Double.parseDouble(productCreateInput[5]));

     return productService.productCreate(product);
   }
   catch(Exception e){
      System.out.println(e.getMessage());
   }
return null;
  }

  String productEditByEnter() throws SQLException, ProductNotValidException {
    Scanner scanner = new Scanner(System.in);
    System.out.print("> ");
    String[] productCreateInput = scanner.nextLine().split("[, ]");
    Product product =
        new Product(
            Integer.parseInt(productCreateInput[0]),
            productCreateInput[1],
            productCreateInput[2],
            productCreateInput[3],
            Double.parseDouble(productCreateInput[4]),
            Double.parseDouble(productCreateInput[5]));

    return productService.productEdit(product);
  }

  void productCreateHelp() {
    System.out.println(
        "create product using the following template\n"
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
            + "code, name, unitcode, type, costprice");
  }

  void productListHelp() {
    System.out.println(
        "> product list help\n"
            + "\n"
            + ">> List product with the following options\n"
            + ">> product list - will list all the products default to maximum upto 20 products\n"
            + ">> product list -p 10 - pageable list shows 10 products as default\n"
            + ">> product list -p 10 3 - pagable list shows 10 products in 3rd page, ie., product from 21 to 30\n"
            + ">> product list -s searchtext - search the product with the given search text in all the searchable attributes\n"
            + ">> product list -s <attr>: searchtext - search the product with the given search text in all the given attribute\n"
            + ">> product list -s <attr>: searchtext -p 10 6 - pagable list shows 10 products in 6th page with the given search text in the given attribute\n"
            + "\n"
            + "\n"
            + "> product list -s type: chocolate -p 5 2 ");
  }

  void productEditHelp() {
    System.out.println(
        "> product edit help   \n"
            + "\n"
            + ">> Edit product using following template. Copy the product data from the list, edit the attribute values. \n"
            + ">> id: <id - 6>, name: <name-edited>, unitcode: <unitcode>,  type: <type>, price: <price>\n"
            + "\n"
            + ">> You can also restrict the product data by editable attributes. Id attribute is mandatory for all the edit operation.\n"
            + ">> id: <id - 6>, name: <name-edited>, unitcode: <unitcode-edited>\n"
            + "\n"
            + ">> You can not give empty or null values to the mandatory attributes.\n"
            + ">> id: <id - 6>, name: , unitcode: null\n"
            + ">>\n"
            + " \n"
            + " \tid\t - number, mandatory\t\n"
            + "\tname - text, min 3 - 30 char, mandatory\n"
            + "\tunitcode - text, kg/l/piece/combo, mandatory\n"
            + "\ttype - text, between enumerated values, mandatory \n"
            + "\tcostprice - numeric, mandatory\n"
            + "\t\n"
            + ">\tproduct edit id:<id - 6>, name: <name-edited>, unitcode: <unitcode>,  type: <type>, price: <price>\n"
            + "                         or\n"
            + "> product edit :enter\n"
            + "> id: <id - 6>, name: <name-edited>, unitcode: <unitcode>,  type: <type>, price: <price>\n"
            + "\t\t\t\t\t\n"
            + "\t\t\t\t\tor\n"
            + "\t\t\t\t\t\n"
            + "> id: <id - 6>, name: <name-edited>, unitcode: <unitcode-edited>\t\t");
  }

  void productDeleteHelp() {
    System.out.println(
        "> product delete help \n"
            + ">> delete product using the following template\n"
            + "\t\n"
            + "\t\tproductid - numeric, existing\n"
            + ">> product delete -c <code>\n"
            + "\t \n"
            + "\n"
            + "> product delete <id>");
  }

  void priceUpdateHelp() {
    System.out.println(
        "Update sales price per unit using the following template\n"
            + "\t\tcode, price\n"
            + "\t\t\n"
            + "\t\tcode - text, mandatory\n"
            + "\t\tprice - number, mandatory\n"
            + "\t\t\n"
            + "> price update <code> <price>\t");
  }

  void stockUpdateHelp() {
    System.out.println(
        "stock update help\n"
            + ">> update stock using following template\n"
            + "\t\tcode, quantity\n"
            + "\t\t\n"
            + "\t\tcode - text, mandatory\n"
            + "\t\tquantity - number, mandatory\n"
            + "\n"
            + "> stock update <code> <quantity>");
  }
}
