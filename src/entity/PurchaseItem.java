package entity;

public class PurchaseItem {
  private Integer invoice;
  private Integer code;
  private Double quantity;
  private Double costPrice;

  public PurchaseItem(Integer invoice, Integer code, Double quantity, Double costPrice) {
    this.setInvoice(invoice);
    this.setCode(code);
    this.setQuantity(quantity);
    this.setCostPrice(costPrice);
  }

  public Integer getInvoice() {
    return invoice;
  }

  public void setInvoice(Integer invoice) {
    this.invoice = invoice;
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public Double getQuantity() {
    return quantity;
  }

  public void setQuantity(Double quantity) {
    this.quantity = quantity;
  }

  public Double getCostPrice() {
    return costPrice;
  }

  public void setCostPrice(Double costPrice) {
    this.costPrice = costPrice;
  }
}
