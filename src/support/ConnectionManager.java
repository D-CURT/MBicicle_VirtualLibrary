package support;

import support.constants.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import static support.constants.Constants.DB_URL;
import static support.constants.Constants.PASSWORD;
import static support.constants.Constants.USER_NAME;

public class ConnectionManager {

    static {
        try {
            Class.forName(Constants.DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
    }

    public static void closeResultSet(ResultSet set) throws SQLException {
        if (set != null) {
            set.close();
        }
    }
}
