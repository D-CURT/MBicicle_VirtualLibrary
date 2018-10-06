package dao;

import dao.interfaces.DAO_inApplier;
import support.exceptions.MBicicleSQLException;
import support.sections.SQLSection;

import java.sql.SQLException;
import java.util.List;

public class DB_in extends AbstractDAO implements DAO_inApplier {
    @Override
    public boolean apply(String name, List<String> list, SQLSection sqlSection) {
        try {
            return add(name, list, sqlSection);
        } catch (SQLException e) {
            throw new MBicicleSQLException(e.getMessage());
        }
    }
}
