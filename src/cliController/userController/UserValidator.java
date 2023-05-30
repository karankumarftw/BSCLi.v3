package cliController.userController;

import cliController.unitController.UnitNotValidException;
import entity.User;

public class UserValidator {
  public User userValidator(
      String userType,
      String userName,
      String userPassword,
      String userFirstName,
      String userLastName,
      String userPhoneNumber)
      throws Exception {
    if (!userType.equals("sales") && !userType.equals("purchase")) {
      throw new UserNotValidException("User Type either should be sales or purchase");
    }

    if (userName.length() > 30 || userName.length() < 3) {
      throw new UserNotValidException("User name length should be between 3 to 30 characters");
    }

    if (userPassword.length() < 8) {
      throw new UserNotValidException("Password length should be minimum of 8 characters");
    }

    if (userFirstName.length() < 3 || userFirstName.length() > 30) {
      throw new UserNotValidException("First name length should be  between 3 to 30 characters");
    }

    if (userPhoneNumber.length() != 10) {
      throw new UserNotValidException("Phone number should be 10 digits");
    }

    if (!(userPhoneNumber.charAt(0) == '9'
        || userPhoneNumber.charAt(0) == '8'
        || userPhoneNumber.charAt(0) == '7'
        || userPhoneNumber.charAt(0) == '6')) {
      throw new UserNotValidException(
          "Invalid phone number, The number should start with either one of these, 9,8,7,6");
    }
    
    long phoneNumber;
    try{
      phoneNumber = Long.parseLong(userPhoneNumber);
    }
    catch (NumberFormatException e){
      throw new UnitNotValidException("Phone number of the user should ");
    }

    return new User(
        1,
        userType,
        userName,
        userPassword,
        userFirstName,
        userLastName,
        phoneNumber);
  }
}
