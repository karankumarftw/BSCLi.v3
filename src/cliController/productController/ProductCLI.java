package cliController.productController;

import entity.Product;
import org.apache.commons.lang3.StringUtils;
import service.ProductService;

import java.sql.SQLException;
import java.util.Scanner;

public class ProductCLI {
  private ProductValidator productValidator = new ProductValidator();
  private ProductService productService = new ProductService();

  public void input(String command) throws SQLException {
    String[] commandSplitted = command.split("[ ,]");

    int elementCount = 0;
    for(String element : commandSplitted){
      elementCount+=1;
    }

    if(elementCount<3){
      switch (commandSplitted[1]){
        case "create" -> System.out.println(productCreateByEnter());
        case "edit" -> productEditByEnter();
      }
    }

    if (commandSplitted[2].equals("help")) {
      switch (commandSplitted[1]) {
        case "create" -> productCreateHelp();
        case "list" -> productListHelp();
        case "edit" -> productEditHelp();
        case "delete" -> productDeleteHelp();
      }
    }


  }

  String productCreateByEnter() throws SQLException {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Product create");
    System.out.print("> ");
    String[] productCreateInput = scanner.nextLine().split("[, ]");
    Product product = new Product(
            Integer.parseInt(productCreateInput[0]),
            productCreateInput[1],
            productCreateInput[2],
            productCreateInput[3],
            Double.parseDouble(productCreateInput[4]),
            Double.parseDouble(productCreateInput[5]));

    return productService.productCreate(product);
  }

  String productEditByEnter() throws SQLException {
    Scanner scanner = new Scanner(System.in);
    System.out.print("> ");
    String[] productCreateInput = scanner.nextLine().split("[, ]");
    Product product = new Product(
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
}
