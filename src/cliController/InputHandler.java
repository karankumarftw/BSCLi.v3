package cliController;

import java.sql.SQLException;
import service.NotANumberException;
import service.ProductService;
import service.UserService;

public class InputHandler {
    ProductService productService = new ProductService();
    UserService userService = new UserService();
    public void input() throws NotANumberException, SQLException {
        System.out.println(userService.userList());
    }
}
