package entity;

public class User {
  private Integer userID;
  private String userType;
  private String userName;
  private String password;
  private String firstName;
  private String lastName;
  private Long userPhoneNumber;

  public User(
      Integer userId,
      String userType,
      String userName,
      String password,
      String firstName,
      String lastName,
      Long userPhoneNumber) {
    setUserID(userId);
    setUserType(userType);
    setUserName(userName);
    setPassword(password);
    setFirstName(firstName);
    setLastName(lastName);
    setUserPhoneNumber(userPhoneNumber);
  }

  public Integer getUserID() {
    return userID;
  }

  public void setUserID(Integer userID) {
    this.userID = userID;
  }

  public String getUserType() {
    return userType;
  }

  public void setUserType(String userType) {
    this.userType = userType;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Long getUserPhoneNumber() {
    return userPhoneNumber;
  }

  public void setUserPhoneNumber(Long userPhoneNumber) {
    this.userPhoneNumber = userPhoneNumber;
  }
}
