package dao;

import entity.SalesItem;
import java.sql.SQLException;
import java.util.ArrayList;

public interface SalesItemDAO {
  String insert(int invoice, SalesItem salesItem) throws SQLException;

  ArrayList<SalesItem> list() throws SQLException;
}
