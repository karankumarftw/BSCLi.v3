package cliController;

import entity.User;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import service.UserServiceImplementation;

public class UserCLI {
  private final Scanner scanner = new Scanner(System.in);
  UserServiceImplementation userService = new UserServiceImplementation();

  public void commandSplitter(String command) throws Exception {
    String[] commandSplit = command.split("[ ,]");
    int count = commandSplit.length;

    if (count < 3 && commandSplit[1].equals("create")) {
      System.out.println(userCreateByEnter());
    } else if (count < 3 && commandSplit[1].equals("edit")) {
      System.out.println(userEditByEnter());
    } else if (count < 3 && commandSplit[1].equals("list")) {
      userList();
    } else if (count > 4 && commandSplit[1].equals("create")) {
      System.out.println(userCreate(command));
    } else if (count > 5 && commandSplit[1].equals("edit")) {
      System.out.println(userEdit(command));
    }
  }

  String userCreateByEnter() throws Exception {
    System.out.print("> ");
    String[] command = scanner.nextLine().split("[ ,]");
    User user =
        new User(
            1,
            command[0],
            command[1],
            command[2],
            command[3],
            command[4],
            Long.parseLong(command[5]));

    return userService.create(user);
  }

  String userCreate(String commandString) throws SQLException {

    String[] command = commandString.split("[ ,]");

    try {
      User user =
          new User(
              1,
              command[2],
              command[3],
              command[4],
              command[5],
              command[6],
              Long.parseLong(command[7]));

      return userService.create(user);

    } catch (Exception e) {
      throw new NumberFormatException(e.getMessage());
    }
  }

  String userEdit(String commandString) {
    String[] command = commandString.split("[ ,]");

    try {
      User user =
          new User(
              1,
              command[2],
              command[3],
              command[4],
              command[5],
              command[6],
              Long.parseLong(command[7]));

      return userService.edit(user);

    } catch (Exception e) {
      throw new NumberFormatException(e.getMessage());
    }
  }

  String userEditByEnter() throws Exception {
    System.out.print("> ");
    String[] command = scanner.nextLine().split("[ ,]");
    User user =
        new User(
            1,
            command[0],
            command[1],
            command[2],
            command[3],
            command[4],
            Long.parseLong(command[5]));

    return userService.edit(user);
  }

  void userList() throws SQLException {
    ArrayList<User> userList = userService.list();
    for (User user : userList) {
      System.out.println(user.getUserName() + "   " + user.getUserType());
    }
  }

  void userCreateHelp() {
    System.out.println(
        "create user using following template\n"
            + ">>  usertype, username,  password, first name, last name, phone number\n"
            + "\tusertype - text, purchase/sales, mandatory\n"
            + "\tusername - text, min 3 - 30 char, mandatory\n"
            + "\tpassword - text, alphanumeric, special char, min 8 char, mandatory\n"
            + "\tfirstname - text, mandatory with 3 to 30 chars\n"
            + "\tlastname  - text, optional\n"
            + "\tphone - number, mandatory, ten digits, digit start with 9/8/7/6");
  }

  void userListHelp() {
    System.out.println(
        ">> List user with the following options\n"
            + ">> user list - will list all the users default to maximum upto 20 users\n"
            + ">> user list -p 10 - pageable list shows 10 users as default\n"
            + ">> user list -p 10 3 - pagable list shows 10 users in 3rd page, ie., user from 21 to 30\n"
            + ">> user list -s searchtext - search the user with the given search text in all the searchable attributes\n"
            + ">> user list -s <attr>: searchtext - search the user with the given search text in all the given attribute\n"
            + ">> user list -s <attr>: searchtext -p 10 6 - pagable list shows 10 users in 6th page with the given search text in the given attribute"
            + "> user list -s usertype: purchase -p 5 2 ");
  }

  void userEditHelp() {
    System.out.println(
        ">> Edit user using following template. Copy the user data from the list, edit the attribute values. \n"
            + ">> id: <id - 6>, usertype: <usertype-edited>, username: <username>,  password: <password>, first name: <first name>, last name: <last name>, phone number: <phone number>\n"
            + "\n"
            + ">> You can also restrict the user data by editable attributes. Id attribute is mandatory for all the edit operation.\n"
            + ">> id: <id - 6>, usertype: <usertype-edited>, username: <username-edited>\n"
            + "\n"
            + ">> You can not give empty or null values to the mandatory attributes.\n"
            + ">> id: <id - 6>, usertype: , username: null\n"
            + "\t\n"
            + "\tid\t\t\t - number, mandatory\t\n"
            + "\tusertype - text, purchase/sales, mandatory\n"
            + "\tusername - text, min 3 - 30 char, mandatory\n"
            + "\tpassword - text, alphanumeric, special char, min 8 char, mandatory\n"
            + "\tfirstname - text, mandatory with 3 to 30 chars\n"
            + "\tlastname  - text, optional\n"
            + "\tphone - number, mandatory, ten digits, digit start with 9/8/7/6\n"
            + "\n"
            + "> user edit id: <id - 6>, usertype: <usertype-edited>, username: <username>,  password: <password>, first name: <first name>, last name: <last name>, phone number: <phone number>\n"
            + "\n"
            + "\t\t\t\t\tor\n"
            + "\t\t\t\t\t\n"
            + "> user edit :enter\n"
            + "> id: <id - 6>, usertype: <usertype-edited>, username: <username>,  password: <password>, first name: <first name>, last name: <last name>, phone number: <phone number>\n"
            + "\t\t\t\t\t\n"
            + "\t\t\t\t\tor\n"
            + "\t\t\t\t\t\n"
            + "> id: <id - 6>, usertype: <usertype-edited>, username: <username-edited>");
  }

  void userDeleteHelp() {
    System.out.println(
        "> user delete help \n"
            + ">> delete user using the following template\n"
            + "\t username\n"
            + "\t \n"
            + "\t  username - text, min 3 - 30 char, mandatory,existing\n"
            + "\n"
            + "\n"
            + "> user delete <username>");
  }
}
