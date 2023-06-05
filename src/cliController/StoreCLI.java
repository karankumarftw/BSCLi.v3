package cliController;

import entity.Store;
import java.sql.SQLException;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;
import service.StoreServiceImplementation;

public class StoreCLI {
  StoreServiceImplementation storeService = new StoreServiceImplementation();
  Scanner scanner = new Scanner(System.in);

  void commandSplitter(String command) throws Exception {
    String[] splitByComma = StringUtils.split(command, "[ ,]");
    int count = splitByComma.length;
    if (count < 3 && splitByComma[1].equals("create")) {
      createStoreByEnter();
    } else if (count < 3 && splitByComma[1].equals("edit")) {
      editStoreByEnter();
    } else if (splitByComma[2].equals("help")) {
      switch (splitByComma[1]) {
        case "create" -> storeCreateHelp();
        case "edit" -> storeEditHelp();
      }
    } else if (count > 3 && splitByComma[1].equals("create")) {
      storeCreate(command);
    } else if (count > 3 && splitByComma[1].equals("edit")) {
      editStore(command);
    }
  }

  void storeCreate(String command) throws Exception {

    String[] splitByComma = command.split("[, ]");
    String name = splitByComma[2];
    String phoneNumber = splitByComma[3];
    String address = splitByComma[4];
    String gstNumber = splitByComma[5];

    Store store = new Store(name, Long.parseLong(phoneNumber), address, gstNumber);

    storeService.create(store);
  }

  void createStoreByEnter() throws Exception {
    System.out.print("> ");
    String[] splitByComma = scanner.nextLine().split("[, ]");
    String name = splitByComma[0];
    String phoneNumber = splitByComma[1];
    String address = splitByComma[2];
    String gstNumber = splitByComma[3];

    Store store = new Store(name, Long.parseLong(phoneNumber), address, gstNumber);

    storeService.create(store);
  }

  void editStore(String command) throws Exception {

    String[] splitByComma = command.split("[, ]");
    String name = splitByComma[2];
    String phoneNumber = splitByComma[3];
    String address = splitByComma[4];
    String gstNumber = splitByComma[5];

    Store store = new Store(name, Long.parseLong(phoneNumber), address, gstNumber);

    storeService.edit(store);
  }

  void editStoreByEnter() throws Exception {

    System.out.print("> ");
    String[] splitByComma = scanner.nextLine().split("[, ]");
    String name = splitByComma[0];
    String phoneNumber = splitByComma[1];
    String address = splitByComma[2];
    String gstNumber = splitByComma[3];

    Store store = new Store(name, Long.parseLong(phoneNumber), address, gstNumber);

    storeService.edit(store);
  }

  String deleteStore() throws SQLException {
    storeService.delete();
    return null;
  }

  void storeCreateHelp() {
    System.out.println(
        "> store create help\n"
            + "\n"
            + ">> Create store using the following template,\n"
            + "     name, phone number, address, gst number\n"
            + " \n"
            + "\tname  - text, mandatory with 3 to 30 chars\t\n"
            + "\tphone - number, mandatory, ten digits, digit start with 9/8/7/6\n"
            + "\taddress - text, mandatory\n"
            + "\tgst number - text, 15 digit, mandatory\n"
            + "\n"
            + "\t\t\n"
            + "\n"
            + "> store create name, phone number, address, gst number\n"
            + "\t\t\t\t\tor\n"
            + "> store create :enter\n"
            + "> name, phone number, address, gst number");
  }

  void storeEditHelp() {
    System.out.println(
        "> store edit help\n"
            + "\n"
            + ">> Edit store uing the following template\t\n"
            + "\n"
            + "name, phone number, address, gst number\n"
            + " \n"
            + "\tname  - text, mandatory with 3 to 30 chars\t\n"
            + "\tphone - number, mandatory, ten digits, digit start with 9/8/7/6\n"
            + "\taddress - text, mandatory\n"
            + "\tgst number - text, 15 digit, mandatory\n"
            + "\n"
            + "\n"
            + "> store edit name, phone number, address, gst number\n"
            + "\t\t\t\t\tor\n"
            + "> store edit :enter\n"
            + "> name, phone number, address, gst number");
  }
}
