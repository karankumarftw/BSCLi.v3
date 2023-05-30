package cliController.salesController;

import connection.DBConnection;
import entity.Sales;
import entity.SalesItem;
import java.sql.ResultSet;
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

  public void salesList() throws SQLException {
    ResultSet rs1 = DBConnection.statement.executeQuery("select count(*) from sales");
    if (rs1.next()) {
      System.out.println(rs1.getString("count"));
    }
    ResultSet rs = DBConnection.statement.executeQuery("select * from sales");

    while (rs.next()) {
      String date = rs.getString("date");
      int invoice = rs.getInt("invoice");
      double grandTotal = 0;

      ArrayList<SalesItem> salesItems = new ArrayList<>();
      rs =
          DBConnection.statement.executeQuery(
              "select * from sales_items where invoice = " + invoice);
      while (rs.next()) {
        int SIInvoice = rs.getInt("invoice");
        int SICode = rs.getInt("code");
        double SIQuantity = rs.getDouble("quantity");
        double SIPrice = rs.getDouble("price");
        grandTotal += SIPrice;
        SalesItem salesItem = new SalesItem(SIInvoice, SICode, SIQuantity, SIPrice);
        salesItems.add(salesItem);
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
    }
  }

  void salesHelp() {
    System.out.println(
        "> sales help\n"
            + ">> sell products using following command\n"
            + "\n"
            + "sales date, [code1, quantity1], [code2, quantity2]....\n"
            + "\n"
            + "\t\tcode - text, min 3 - 30 char, mandatory\n"
            + "\t\tquantity - numbers, mandatory");
  }

  void salesListHelp() {
    System.out.println(
        "> sales list help\n"
            + "\n"
            + ">> List sales with the following options\n"
            + ">> sales list - will list all the sales default to maximum upto 20 sales\n"
            + ">> sales list -p 10 - pageable list shows 10 sales as default\n"
            + ">> sales list -p 10 3 - pagable list shows 10 sales in 3rd page, ie., sale from 21 to 30\n"
            + "\n"
            + ">> Use only the following attributes: id, date\n"
            + ">> sales list -s <attr>: searchtext - search the sale with the given search text in all the given attribute\n"
            + ">> sales list -s <attr>: searchtext -p 10 6 - pagable list shows 10 sales in 6th page with the given search text in the given attribute\n"
            + "\n"
            + "> sales list -s <date> : <23/03/2023> -p 5 2 \n"
            + "> sales list -s <id> : <10>");
  }

  void salesDeleteHelp() {
    System.out.println(
        "> sales delete help\n"
            + ">> Delete sales using following command \n"
            + "\n"
            + ">> sales delete <id>\n"
            + "\t\tid - numeric, mandatory\n"
            + "\t\t\n"
            + "> sales delete <6>");
  }
}
