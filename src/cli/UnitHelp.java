package cli;

public class UnitHelp {
    static String unitHelp(){
        return "Edit unit using the following template\n" +
                "id: <id - 6>, name: <name-edited>, code: <code>,  description: <description>, isdividable: <isdividable>\n" +
                "\n" +
                "You can also restrict the user data by editable attributes. Id attribute is mandatory for all the edit operation.\n" +
                "id: <id - 6>, name: <name>, code: <code>\n" +
                "\n" +
                "You can not give empty or null values to the mandatory attributes.\n" +
                "id: <id - 6>, name: , code: null\n" +
                "\n" +
                "\t\t name - text, mandatory with 3 to 30 chars\t\n" +
                "     code - text, maximum 4 char, mandatory\n" +
                "     description - text\n" +
                "     isdividable - boolean, mandatory\n" +
                "     \n" +
                "unit edit id: <id - 6>, name: <name-edited>, code: <code>,  description: <description>, isdividable: <isdividable>\n" +
                "\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\tor\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "user edit :enter\n" +
                "id: <id - 6>, name: <name-edited>, code: <usernamcodee>,  description: <description>, isdividable: <isdividable>\n" +
                "\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\tor\n" +
                " id: <id - 6>, name: <name-edited>, code: <code-edited>\t";
    }
}
