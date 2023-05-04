package cli;
import java.sql.SQLException;
import java.util.Scanner;

public class UnitCreate {
    static String unitCreateByEnter() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Unit Name : ");
        String unitName = scanner.next();
        System.out.print("Unit code : ");
        String unitCode = scanner.next();
        System.out.print("Unit description : ");
        String unitDescription = scanner.next();
        System.out.print("is Dividable : ");
        String isDividable = scanner.next();
       return UnitValidator.unitCreateValidator(unitName,unitCode,unitDescription,isDividable);
    }
}
