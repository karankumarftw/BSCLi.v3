package cliController;

import entity.Sales;
import entity.SalesItem;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;
import service.ProductService;
import service.SalesItemService;
import service.SalesService;

public class SalesCLI {
  private final SalesItemService salesItemService = new SalesItemService();
  private final SalesService salesService = new SalesService();
  private final Scanner scanner = new Scanner(System.in);
  private final ProductService productService = new ProductService();

  public void commandSplitter(String command) throws SQLException {
    String[] commandSplit = command.split("[ ,]");
    int count = commandSplit.length;

    if (count < 3 && commandSplit[1].equals("count")) {
      System.out.println(salesCount());

    } else if (commandSplit[0].equals("sales") && commandSplit[1].equals("list")) {
      salesList();
    } else if (commandSplit[1].equals("count")) {
      System.out.println(salesCountOnDate(commandSplit[3]));
    } else if (commandSplit[1].equals("help")) {
      salesHelp();
    } else if (commandSplit[2].equals("help")) {
      switch (commandSplit[1]) {
        case "list" -> salesListHelp();
        case "delete" -> {
          //          try {
          //            System.out.println(purchaseDelete(commandSplit[2]));
          //
          //          } catch (Exception e) {
          //            purchaseDeleteHelp();
          //          }
        }
      }
    } else if (count > 4 && commandSplit[0].equals("sales")) {
      System.out.println(salesCreate(command));
    }
  }

  public int salesCount() throws SQLException {
    return salesService.salesCount();
  }

  public int salesCountOnDate(String date) throws SQLException {
    return salesService.salesCountOnDate(date);
  }

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
    ArrayList<Sales> salesList = salesService.salesList();
    ArrayList<SalesItem> salesItemsList = salesItemService.salesItemList();
    for (Sales sales : salesList) {
      System.out.println(sales.getInvoice() + " : \n");
      for (SalesItem salesItem : salesItemsList) {
        if (Objects.equals(sales.getInvoice(), salesItem.getInvoice())) {
          System.out.println(
              salesItem.getCode()
                  + "   "
                  + salesItem.getItemPrice()
                  + "   "
                  + salesItem.getQuantity());
        }
      }
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
