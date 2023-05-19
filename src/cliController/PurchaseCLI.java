package cliController;

import entity.Purchase;
import entity.PurchaseItem;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;
import service.PurchaseItemService;
import service.PurchaseService;

public class PurchaseCLI {
  private PurchaseItemService purchaseItemService = new PurchaseItemService();
  private PurchaseService purchaseService = new PurchaseService();
  private Scanner scanner = new Scanner(System.in);

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

  int purchaseCount() throws SQLException {
    return purchaseService.purchaseCount();
  }
}
