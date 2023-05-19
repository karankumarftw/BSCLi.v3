package entity;

public class PurchaseItem {
   private int invoice;
  private int code;
  private double quantity;
  private double costPrice;

  public PurchaseItem(int invoice, int code, double quantity, double costPrice) {
    this.setInvoice(invoice);
    this.setCode(code);
    this.setQuantity(quantity);
    this.setCostPrice(costPrice);
  }

  public int getInvoice() {
    return invoice;
  }

  public void setInvoice(int invoice) {
    this.invoice = invoice;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public double getQuantity() {
    return quantity;
  }

  public void setQuantity(double quantity) {
    this.quantity = quantity;
  }

  public double getCostPrice() {
    return costPrice;
  }

  public void setCostPrice(double costPrice) {
    this.costPrice = costPrice;
  }
}
