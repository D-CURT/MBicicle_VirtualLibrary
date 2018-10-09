package dao;

import beans.Content;
import support.exceptions.MBicycleSQLException;
import support.sections.SQLSection;

import java.sql.SQLException;

public class DB_out extends AbstractDAO {
    @Override
    public Content apply(String name, SQLSection sqlSection) {
        try {
            return get(name, sqlSection);
        } catch (SQLException e) {
            throw new MBicycleSQLException(e.getMessage());
        }
    }
}
