package entity;

public class SalesItem {
  private Integer invoice;
  private Integer code;
  private Double quantity;
  private Double itemPrice;

  public SalesItem(Integer invoice, Integer code, Double quantity, Double itemPrice) {
    this.setInvoice(invoice);
    this.setCode(code);
    this.setQuantity(quantity);
    this.setItemPrice(itemPrice);
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

  public Double getItemPrice() {
    return itemPrice;
  }

  public void setItemPrice(Double itemPrice) {
    this.itemPrice = itemPrice;
  }
}
