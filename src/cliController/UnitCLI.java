package cliController;

import entity.Unit;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import service.UnitService;
import service.UnitValidator;

public class UnitCLI {
  private UnitValidator unitValidator = new UnitValidator();
  private Scanner scanner = new Scanner(System.in);
  private String[] command;
  private UnitService unitService = new UnitService();

  String unitCreateByEnter() throws SQLException {
    System.out.print("> ");
    command = scanner.nextLine().split("[ ,]");
    Unit unit = new Unit(command[0], command[1], command[2], Boolean.parseBoolean(command[3]));

    return unitService.unitCreate(unit);
  }

  String unitEditByEnter() throws SQLException {
    System.out.print("> ");
    command = scanner.nextLine().split("[ ,]");
    Unit unit = new Unit(command[0], command[1], command[2], Boolean.parseBoolean(command[3]));

    return unitService.unitEdit(unit);
  }

  void unitList() {
    try {
      ArrayList<Unit> units = unitService.unitList();
      System.out.println("Unit :");
      for (int i = 0; i < units.size(); i++) {
        System.out.println((i + 1) + " " + units.get(i).getName());
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  void delete(String unitCode) throws SQLException {
    unitService.unitDelete(unitCode);
  }

  void unitEditHelp() {
    System.out.println(
        "Edit unit using the following template\n"
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
            + " id: <id - 6>, name: <name-edited>, code: <code-edited>\t");
  }

  void unitCreateHelp() {
    System.out.println(
        "> unit create help\n"
            + ">> Create unit using the following template,\n"
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
            + "\tname, code, description, isdividable");
  }

  void unitListHelp() {
    System.out.println(
        ">> List unit with the following options\n" + ">> unit list - will list all the units");
  }

  void unitDeleteHelp() {
    System.out.println(
        "> unit delete help \n"
            + ">> delete unit using the following template\n"
            + "\t \tcode\n"
            + "\t \n"
            + "\t  code - text, min 3 - 30 char, mandatory,existing\n"
            + "\n"
            + "\n"
            + "> unit delete <code>");
  }
}
