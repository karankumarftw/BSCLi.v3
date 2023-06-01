package cliController;

import entity.Unit;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import service.UnitService;

public class UnitCLI {
  private final Scanner scanner = new Scanner(System.in);
  private final UnitService unitService = new UnitService();

  public void commandSplitter(String command) throws SQLException {
    String[] commandSplit = command.split("[ ,]");
    int elementCount = commandSplit.length;
    if (elementCount > 2 && commandSplit[2].equals("help")) {
      switch (commandSplit[1]) {
        case "create" -> unitCreateHelp();
        case "edit" -> System.out.println(unitEditByEnter());
        case "delete" -> unitDeleteHelp();
        case "list" -> unitListHelp();
      }
    } else if (commandSplit[1].equals("list")) {
      unitList();
    } else if (commandSplit[1].equals("delete")) {
      System.out.println(delete(commandSplit[2]));
    } else if (commandSplit[1].equals("create")) {
      try {
        Unit unit =
            new Unit(
                commandSplit[2],
                commandSplit[3],
                commandSplit[4],
                Boolean.parseBoolean(commandSplit[5]));
        unitService.unitCreate(unit);
      } catch (Exception e) {
        System.out.println(unitCreateByEnter());
      }
    } else if (commandSplit[1].equals("edit")) {
      try {
        Unit unit =
            new Unit(
                commandSplit[2],
                commandSplit[3],
                commandSplit[4],
                Boolean.parseBoolean(commandSplit[5]));
        unitService.unitEdit(unit);
      } catch (Exception e) {
        unitEditByEnter();
      }
    }
  }

  String unitCreateByEnter() throws SQLException {
    System.out.print("> ");
    String[] commandSplitted = scanner.nextLine().split("[ ,]");
    Unit unit =
        new Unit(
            commandSplitted[0],
            commandSplitted[1],
            commandSplitted[2],
            Boolean.parseBoolean(commandSplitted[3]));

    return unitService.unitCreate(unit);
  }

  String unitEditByEnter() throws SQLException {
    System.out.print("> ");
    String[] commandSplit = scanner.nextLine().split("[ ,]");
    Unit unit =
        new Unit(
            commandSplit[0],
            commandSplit[1],
            commandSplit[2],
            Boolean.parseBoolean(commandSplit[3]));

    return unitService.unitEdit(unit);
  }

  void unitList() {
    try {
      ArrayList<Unit> units = unitService.unitList();
      System.out.println("---------------------");
      System.out.println("       UNIT CODE     ");
      for (int i = 0; i < units.size(); i++) {
        System.out.printf("%10s%n", units.get(i).getName());
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  String delete(String unitCode) throws SQLException {
    return unitService.unitDelete(unitCode);
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
