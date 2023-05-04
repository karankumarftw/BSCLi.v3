package cli;

import org.postgresql.util.OSUtil;

public class ProductHelp {
    static String productHelp(){
       return "create product using the following template\n" +
                "code, name, unit, type, price, stock\n" +
                "\t\n" +
                "\tcode - text, min - 2 - 6, mandatory\n" +
                "\tname - text, min 3 - 30 char, mandatory\n" +
                "\tunitcode - text, kg/l/piece/combo, mandatory\n" +
                "\ttype - text, between enumerated values, mandatory \n" +
                "\tprice - number, mandatory\n" +
                "\tstock - number, default 0\n" +
                "\t\n" +
                "\tproduct create code, productname, unitcode, type, costprice\n" +
                "                         or\n" +
                "product create :enter\n" +
                "code, name, unitcode, type, costprice";
    }
}
