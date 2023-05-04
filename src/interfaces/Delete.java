package interfaces;

import java.sql.SQLException;

public interface Delete {
    String delete(String code) throws SQLException;
}
