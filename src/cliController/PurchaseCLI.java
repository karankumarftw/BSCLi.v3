package cliController;

import entity.Purchase;
import entity.PurchaseItem;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;
import service.NotANumberException;
import service.ProductService;
import service.PurchaseItemService;
import service.PurchaseService;

public class PurchaseCLI {
  private final PurchaseItemService purchaseItemService = new PurchaseItemService();
  private final PurchaseService purchaseService = new PurchaseService();
  private final ProductService productService = new ProductService();
  private final Scanner scanner = new Scanner(System.in);

  void commandSplitter(String command) throws SQLException, NotANumberException {
    String[] commandSplit = command.split("[ ,]");
    int count = commandSplit.length;

    if (commandSplit[0].equals("purchase") && commandSplit[1].equals("list")) {
      purchaseList();
    } else if (count < 3 && commandSplit[1].equals("count")) {
      System.out.println(purchaseCount());

    } else if (commandSplit[1].equals("count")) {
      System.out.println(purchaseCountOnDate(commandSplit[3]));

    } else if (commandSplit[1].equals("help")) {
      purchaseHelp();
    } else if (commandSplit[2].equals("help")) {
      switch (commandSplit[1]) {
        case "list" -> purchaseListHelp();
        case "delete" -> {
          try {
            System.out.println(purchaseDelete(commandSplit[2]));

          } catch (Exception e) {
            purchaseDeleteHelp();
          }
        }
      }
    } else if (count < 4 && commandSplit[1].equals("delete")) {
      System.out.println(purchaseDelete(commandSplit[2]));
    } else if (commandSplit[0].equals("purchase")) {
      System.out.println(purchaseCreate(command));
    } else if (commandSplit[0].equals("stock")) {
      System.out.println(stockUpdate(commandSplit[2], commandSplit[3]));
    } else if (commandSplit[0].equals("price")) {
      System.out.println(priceUpdate(commandSplit[2], commandSplit[3]));
    }
  }

  public void purchaseList() throws SQLException {
    ArrayList<Purchase> purchaseList = purchaseService.purchaseList();
    ArrayList<PurchaseItem> purchaseItemsList = purchaseItemService.purchaseItemsList();
    for (Purchase purchase : purchaseList) {
      System.out.println(purchase.getInvoice() + " : \n");
      for (PurchaseItem purchaseItem : purchaseItemsList) {
        if (Objects.equals(purchase.getInvoice(), purchaseItem.getInvoice())) {
          System.out.println(
              purchaseItem.getCode()
                  + "   "
                  + purchaseItem.getCostPrice()
                  + "   "
                  + purchaseItem.getQuantity());
        }
      }
    }
  }

  String purchaseCreate(String command) throws SQLException {
    String[] splitByComma = StringUtils.split(command, "[\\[\\]\\ \\,\\]");
    String date = splitByComma[1];
    int invoice = Integer.parseInt(splitByComma[2]);
    double grandTotal = 0;

    ArrayList<PurchaseItem> purchaseItems = new ArrayList<>();

    try {
      for (int i = 3; i < splitByComma.length; i += 3) {
        int code = Integer.parseInt(splitByComma[i]);
        double quantity = Double.parseDouble(splitByComma[i + 1]);
        double costPrice = Double.parseDouble(splitByComma[i + 2]);
        grandTotal += quantity * costPrice;

        PurchaseItem purchaseItem = new PurchaseItem(invoice, code, quantity, costPrice);
        purchaseItems.add(purchaseItem);
      }
    } catch (Exception err) {
      throw new NumberFormatException("Code, Quantity and CostPrice should be numeric values");
    }
    System.out.println("____________________________________________________________");
    System.out.println(date + "\t\t\t\tPURCHASE BILL\t\t\t" + String.format("%10s", invoice));
    System.out.println("____________________________________________________________");
    System.out.println(
        String.format("%20s", "Code")
            + String.format("%20s", "Quantity")
            + String.format("%20s", "CostPrice"));
    for (PurchaseItem purchaseItem : purchaseItems) {
      System.out.println(
          String.format("%20s", purchaseItem.getCode())
              + String.format("%20s", purchaseItem.getQuantity())
              + String.format("%20s", purchaseItem.getCostPrice()));
    }

    System.out.println("____________________________________________________________");
    System.out.println("GRAND TOTAL\t\t\t\t\t\t\t\t\t\t\t\t" + grandTotal);
    System.out.println("____________________________________________________________");

    System.out.print("Are you sure want to proceed purchase ? (y/n) : ");
    String choice = scanner.next().toLowerCase();
    if (choice.equals("y") || choice.equals("yes")) {
      try {
        Purchase purchase = new Purchase(1, date, invoice, grandTotal);

        purchaseService.newPurchase(purchase);

        purchaseItemService.createNewPurchaseItems(invoice, purchaseItems);

        return "Purchase Successful";
      } catch (Exception e) {
        throw new SQLException(e.getMessage());
      }
    }
    return "Purchase cancelled";
  }

  public int purchaseCount() throws SQLException {
    return purchaseService.purchaseCount();
  }

  public int purchaseCountOnDate(String date) throws SQLException {
    return purchaseService.purchaseCountOnDate(date);
  }

  public String purchaseDelete(String invoice) throws SQLException {
    int invoiceNo = Integer.parseInt(invoice);
    purchaseItemService.deletePurchaseItem(invoiceNo);
    return purchaseService.purchaseDelete(invoiceNo);
  }

  public String priceUpdate(String code, String price) throws NotANumberException {
    return productService.productPriceUpdate(code, price);
  }

  public String stockUpdate(String code, String stock) throws NotANumberException {
    return productService.productStockUpdate(code, stock);
  }

  void purchaseHelp() {
    System.out.println(
        "purchase products using following command\n"
            + "\n"
            + "purchase date, invoice, [code1, quantity1, costprice1], [code2, quantity2, costprice2]....\n"
            + "\n"
            + "\t  date - format( DD-MM-YYYY ), mandatory\n"
            + "\t\tinvoice - numbers, mandatory\n"
            + "\t\t\n"
            + "\t\tThe following purchase items should be given as array of items\n"
            + "\t\tcode - text, min 2 - 6 char, mandatory\n"
            + "\t\tquantity - numbers, mandatory\n"
            + "\t\tcostprice - numbers, mandatory");
  }

  void purchaseListHelp() {
    System.out.println(
        "purchase list help\n"
            + "\n"
            + ">> List purchase with the following options\n"
            + ">> purchase list - will list all the purchases default to maximum upto 20 purchases\n"
            + ">> purchase list -p 10 - pageable list shows 10 purchases as default\n"
            + ">> purchase list -p 10 3 - pagable list shows 10 purchases in 3rd page, ie., purchase from 21 to 30\n"
            + "\n"
            + ">> Use only the following attributes: id, date, invoice\n"
            + ">> purchase list -s <attr>: searchtext - search the purchase with the given search text in all the given attribute\n"
            + ">> purchase list -s <attr>: searchtext -p 10 6 - pagable list shows 10 purchases in 6th page with the given search text in the given attribute\n"
            + "\n"
            + "> purchase list -s <date> : <23-03-2023> -p 5 2 \n"
            + "> purchase list -s <invoice> : <785263>");
  }

  void purchaseDeleteHelp() {
    System.out.println(
        "> purchase delete help\n"
            + ">> Delete purchase using following command \n"
            + "\n"
            + ">> purchase delete <invoice>\n"
            + "\t\tinvoice - numeric, mandatory\n"
            + "\t\t\n"
            + "> purchase delete <6>");
  }

  void stockUpdateHelp() {
    System.out.println(
        "> stock update help\n"
            + ">> update stock using following template\n"
            + "\t\tcode, quantity\n"
            + "\t\t\n"
            + "\t\tcode - text, mandatory\n"
            + "\t\tquantity - number, mandatory\n"
            + "\n"
            + "> stock update <code> <quantity>");
  }

  void priceUpdateHelp() {
    System.out.println(
        ">> Update sales price per unit using the following template\n"
            + "\t\tcode, price\n"
            + "\t\t\n"
            + "\t\tcode - text, mandatory\n"
            + "\t\tprice - number, mandatory\n"
            + "\t\t\n"
            + "> price update <code> <price>\t");
  }

}
