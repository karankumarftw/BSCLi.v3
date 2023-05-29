package cliController;

import entity.Store;
import service.StoreService;

public class StoreCLI {
  StoreService storeService = new StoreService();
  String input(String command) {
    return null;
  }

  String createStore(String command) throws Exception {
    StoreValidator storeValidator = new StoreValidator();
    Store store;
    try {
      store = storeValidator.storeValidator(command);
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
    return storeService.createStore(store);
  }
}
