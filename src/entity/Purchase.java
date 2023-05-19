package entity;

public class Purchase {
  private int id;
  private String date;
  private int invoice;
  private double grandTotal;

  public Purchase(int id, String date, int invoice, double grandTotal) {
    this.setId(id);
    this.setDate(date);
    this.setInvoice(invoice);
    this.setGrandTotal(grandTotal);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public int getInvoice() {
    return invoice;
  }

  public void setInvoice(int invoice) {
    this.invoice = invoice;
  }

  public double getGrandTotal() {
    return grandTotal;
  }

  public void setGrandTotal(double grandTotal) {
    this.grandTotal = grandTotal;
  }
}
