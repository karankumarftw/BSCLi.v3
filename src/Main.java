import cliController.InputHandler;
import java.sql.SQLException;
import service.ProductNotValidException;

public class Main {
  public static void main(String[] args) throws SQLException, ProductNotValidException {
    InputHandler inputHandler = new InputHandler();
    inputHandler.authentication();
  }
}
