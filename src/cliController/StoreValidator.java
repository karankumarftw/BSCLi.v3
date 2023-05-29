package cliController;

import entity.Store;
import java.sql.SQLException;
import org.apache.commons.lang3.StringUtils;
import service.StoreService;

public class StoreValidator {
  public Store storeValidator(String command) throws SQLException, StoreNotValidException {
    String[] splitByComma = StringUtils.split(command, "[ ,]");
    String name = splitByComma[2];
    String phoneNumber = splitByComma[3];
    String address = splitByComma[4];
    String gstNumber = splitByComma[5];

    if (name.length() < 3 || name.length() > 30) {
      throw new StoreNotValidException("Product name length should be 3 to 30 characters");
    }
    if (phoneNumber.length() != 10) {
      throw new StoreNotValidException("Phone number should be 10 digits");
    }
    if (!(phoneNumber.charAt(0) == '9'
        || phoneNumber.charAt(0) == '8'
        || phoneNumber.charAt(0) == '7'
        || phoneNumber.charAt(0) == '6')) {
      throw new StoreNotValidException(
          "Invalid phone number, The number should start with either one of these, 9,8,7,6");
    }

    if (gstNumber.length() != 15) {
      throw new StoreNotValidException("Invalid GST number, GST number should be 15 characters");
    }

    long storePhoneNumber;
    try {
      storePhoneNumber = Long.parseLong(phoneNumber);
    } catch (Exception e) {
      throw new StoreNotValidException("Phone number should be a number not any other characters");
    }
    Store store = new Store(name, storePhoneNumber, address, gstNumber);



    return store;
  }
}
