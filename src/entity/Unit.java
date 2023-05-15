package entity;

public class Unit {
  private String name;
  private String code;
  private String description;
  private boolean isDividable;

  public Unit(String name, String code, String description, boolean isDividable) {
    setCode(code);
    setName(name);
    setDescription(description);
    setDividable(isDividable);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean getIsDividable() {
    return isDividable;
  }

  public void setDividable(boolean dividable) {
    isDividable = dividable;
  }
}
