import cliController.InputHandler;
import service.NotANumberException;

import java.sql.SQLException;

public class Main {
  public static void main(String[] args) throws SQLException, NotANumberException {
    InputHandler inputHandler = new InputHandler();
    inputHandler.input();
  }
}
