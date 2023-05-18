package cliController;

import java.sql.SQLException;
import java.util.Scanner;

public class UserCLI {
  UserValidator userValidator = new UserValidator();

  class UserHelp {
    String userHelp() {
      return "Create unit using the following template,\n"
          + "     name, code, description, isdividable\n"
          + "     \n"
          + "     name - text, mandatory with 3 to 30 chars\t\n"
          + "     code - text, maximum 4 char, mandatory\n"
          + "     description - text\n"
          + "     isdividable - boolean, mandatory\n"
          + "    \n"
          + "> unit create name, code, description, isdividable\n"
          + "\t\t\t\t\t\t\tor\n"
          + "\tunit create :enter\n"
          + "\tname, code, description, isdividable";
    }
  }

  class UserCreateByEnter {
    String userCreateByEnter() throws SQLException {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Enter user Type : ");
      String userType = scanner.nextLine();
      System.out.print("Enter user name : ");
      String userName = scanner.nextLine();
      System.out.print("Enter password : ");
      String userPassword = scanner.nextLine();
      System.out.print("Enter first name : ");
      String userFirstName = scanner.nextLine();
      System.out.print("Enter last name : ");
      String userLastName = scanner.nextLine();
      System.out.print("Enter phone number : ");
      String userPhoneNumber = scanner.nextLine();

      return userValidator.userValidator(
          userType, userName, userPassword, userFirstName, userLastName, userPhoneNumber);
    }
  }

  class UserEditByEnter {
    String userEditByEnter() throws SQLException {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Enter user Type : ");
      String userType = scanner.nextLine();
      System.out.print("Enter user name : ");
      String userName = scanner.nextLine();
      System.out.print("Enter password : ");
      String userPassword = scanner.nextLine();
      System.out.print("Enter first name : ");
      String userFirstName = scanner.nextLine();
      System.out.print("Enter last name : ");
      String userLastName = scanner.nextLine();
      System.out.print("Enter phone number : ");
      String userPhoneNumber = scanner.nextLine();

      return userValidator.userValidator(
          userType, userName, userPassword, userFirstName, userLastName, userPhoneNumber);
    }
  }
}
