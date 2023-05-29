package cliController;

import entity.Sales;
import entity.SalesItem;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;
import service.ProductService;
import service.SalesItemService;
import service.SalesService;

public class SalesCLI {
  private SalesItemService salesItemService = new SalesItemService();
  private SalesService salesService = new SalesService();
  private Scanner scanner = new Scanner(System.in);
  private ProductService productService = new ProductService();

  public String salesCreate(String command) throws SQLException {
    String[] splitByComma = StringUtils.split(command, "[\\[\\]\\ \\,\\]");
    String date = splitByComma[1];
    int invoice = Integer.parseInt(splitByComma[2]);
    double grandTotal = 0;

    ArrayList<SalesItem> salesItems = new ArrayList<>();

    try {
      for (int i = 3; i < splitByComma.length; i += 2) {
        int code = Integer.parseInt(splitByComma[i]);
        double quantity = Double.parseDouble(splitByComma[i + 1]);
        double itemPrice = productService.getItemPrice(code);
        grandTotal += quantity * itemPrice;

        SalesItem salesItem = new SalesItem(invoice, code, quantity, itemPrice);
        salesItems.add(salesItem);
      }
    } catch (Exception err) {
      System.out.println(err.getMessage());
    }

    System.out.println("____________________________________________________________");
    System.out.println(date + "\t\t\t\tSALES BILL\t\t\t" + String.format("%10s", invoice));
    System.out.println("____________________________________________________________");
    System.out.println(
        String.format("%20s", "Code")
            + String.format("%20s", "Quantity")
            + String.format("%20s", "Price"));
    for (SalesItem salesItem : salesItems) {
      System.out.println(
          String.format("%20s", salesItem.getCode())
              + String.format("%20s", salesItem.getQuantity())
              + String.format("%20s", salesItem.getItemPrice()));
    }

    System.out.println("____________________________________________________________");
    System.out.println("GRAND TOTAL\t\t\t\t\t\t\t\t\t\t\t\t" + grandTotal);
    System.out.println("____________________________________________________________");

    System.out.print("Are you sure want to proceed purchase ? (y/n) : ");
    String choice = scanner.next().toLowerCase();
    if (choice.equals("y") || choice.equals("yes")) {
      try {
        Sales sales = new Sales(1, date, invoice, grandTotal);

        salesService.newSales(sales);

        salesItemService.createNewSalesItems(invoice, salesItems);

        return "Sale Successful";
      } catch (Exception e) {
        throw new SQLException(e.getMessage());
      }
    }
    return "Sale cancelled";
  }
}
