package entity;

public class SalesItem {
	private int invoice;
	private int code;
	private double quantity;
	private double itemPrice;

	public SalesItem(int invoice, int code, double quantity,double itemPrice) {
		this.setInvoice(invoice);
		this.setCode(code);
		this.setQuantity(quantity);
		this.setItemPrice(itemPrice);
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

	public double getItemPrice(){
		return itemPrice;
	}

	public void setItemPrice(double itemPrice){
		this.itemPrice = itemPrice;
	}
}
