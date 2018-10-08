package dao;

import support.exceptions.MBicicleSQLException;
import support.sections.SQLSection;

import java.sql.SQLException;
import java.util.List;

public class DB_in extends AbstractDAO {
    @Override
    public boolean adding(String name, List<String> tiedNames, SQLSection sqlSection) {
        try {
            return add(name, tiedNames, sqlSection);
        } catch (SQLException e) {
            throw new MBicicleSQLException(e.getMessage());
        }
    }
}
