package cliController;

import java.sql.SQLException;
import java.util.Scanner;

public class UnitCLI {

	class UnitCreate {
		static String unitCreateByEnter() throws SQLException {
			Scanner scanner = new Scanner(System.in);
			System.out.print("Unit Name : ");
			String unitName = scanner.nextLine();
			System.out.print("Unit code : ");
			String unitCode = scanner.nextLine();
			System.out.print("Unit description : ");
			String unitDescription = scanner.nextLine();
			System.out.print("is Dividable : ");
			String isDividable = scanner.nextLine();
			return UnitValidator.unitCreateValidator(
					"create", unitName, unitCode, unitDescription, isDividable);
		}
	}

	class UnitEdit {
		static String unitEditByEnter() throws SQLException {
			Scanner scanner = new Scanner(System.in);
			System.out.print("Unit Name : ");
			String unitName = scanner.next();
			System.out.print("Unit code : ");
			String unitCode = scanner.next();
			System.out.print("Unit description : ");
			String unitDescription = scanner.next();
			System.out.print("is Dividable : ");
			String isDividable = scanner.next();
			return UnitValidator.unitCreateValidator(
					"edit", unitName, unitCode, unitDescription, isDividable);
		}
	}

	class UnitHelp {
		static String unitEditHelp() {
			return "Edit unit using the following template\n"
					+ "id: <id - 6>, name: <name-edited>, code: <code>,  description: <description>, isdividable: <isdividable>\n"
					+ "\n"
					+ "You can also restrict the user data by editable attributes. Id attribute is mandatory for all the edit operation.\n"
					+ "id: <id - 6>, name: <name>, code: <code>\n"
					+ "\n"
					+ "You can not give empty or null values to the mandatory attributes.\n"
					+ "id: <id - 6>, name: , code: null\n"
					+ "\n"
					+ "\t\t name - text, mandatory with 3 to 30 chars\t\n"
					+ "     code - text, maximum 4 char, mandatory\n"
					+ "     description - text\n"
					+ "     isdividable - boolean, mandatory\n"
					+ "     \n"
					+ "unit edit id: <id - 6>, name: <name-edited>, code: <code>,  description: <description>, isdividable: <isdividable>\n"
					+ "\n"
					+ "\t\t\t\t\t\t\t\t\t\t\t\tor\n"
					+ "\t\t\t\t\t\t\t\t\t\t\t\t\n"
					+ "user edit :enter\n"
					+ "id: <id - 6>, name: <name-edited>, code: <usernamcodee>,  description: <description>, isdividable: <isdividable>\n"
					+ "\n"
					+ "\t\t\t\t\t\t\t\t\t\t\t\t\tor\n"
					+ " id: <id - 6>, name: <name-edited>, code: <code-edited>\t";
		}

		static String unitCreateHelp() {

			return null;
		}
	}
}
