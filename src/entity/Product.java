package entity;

public class Product {
  private int code;
  private String name;
  private String unitCode;
  private String type;
  private double price;
  private double stock;

  public Product(int code, String name, String unitCode, String type, double price, double stock) {
    setCode(code);
    setName(name);
    setUnitCode(unitCode);
    setType(type);
    setPrice(price);
    setStock(stock);
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
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

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public double getStock() {
    return stock;
  }

  public void setStock(double stock) {
    this.stock = stock;
  }
}
