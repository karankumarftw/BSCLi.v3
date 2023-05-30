package cliController.storeController;

import entity.Store;
import java.sql.SQLException;
import service.StoreService;

public class StoreCLI {
    StoreService storeService = new StoreService();

    private StoreValidator storeValidator = new StoreValidator();

    String input(String command) {
        return null;
    }

    String createStore(String command) throws Exception {

        Store store;
        try {
            store = storeValidator.storeValidator(command);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return storeService.createStore(store);
    }

    String editStore(String command) throws Exception {
        Store store;
        try {
            store = storeValidator.storeValidator(command);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return storeService.editStore(store);
    }

    String deleteStore() throws SQLException {
        storeService.deleteStore();
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
