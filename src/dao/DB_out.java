package dao;

import beans.Author;
import beans.Content;
import dao.interfaces.DAO_outApplier;
import support.exceptions.MBicicleSQLException;
import support.sections.SQLSection;

import java.sql.SQLException;

public class DB_out extends AbstractDAO implements DAO_outApplier {
    @Override
    public Content apply(String name, SQLSection sqlSection) {
        try {
            return get(name, sqlSection);
        } catch (SQLException e) {
            throw new MBicicleSQLException(e.getMessage());
        }
    }
}
