package entity;

public class Product {
	private Integer code;
	private String name;
	private String unitCode;
	private String type;
	private Double price;
	private Double stock;

	public Product(Integer code, String name, String unitCode, String type, Double price, Double stock) {
		setCode(code);
		setName(name);
		setUnitCode(unitCode);
		setType(type);
		setPrice(price);
		setStock(stock);
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getStock() {
		return stock;
	}

	public void setStock(Double stock) {
		this.stock = stock;
	}
}
