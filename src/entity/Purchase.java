package entity;

public class Purchase {
  private Integer id;
  private String date;
  private Integer invoice;
  private Double grandTotal;

  public Purchase(Integer id, String date, Integer invoice, Double grandTotal) {
    this.setId(id);
    this.setDate(date);
    this.setInvoice(invoice);
    this.setGrandTotal(grandTotal);
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public Integer getInvoice() {
    return invoice;
  }

  public void setInvoice(Integer invoice) {
    this.invoice = invoice;
  }

  public Double getGrandTotal() {
    return grandTotal;
  }

  public void setGrandTotal(Double grandTotal) {
    this.grandTotal = grandTotal;
  }
}
