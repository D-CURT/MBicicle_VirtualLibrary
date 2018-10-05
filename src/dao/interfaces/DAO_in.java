package dao.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface DAO_in {
    boolean addAuthor(String name, List<String> books) throws SQLException;
    boolean addBook(String name, List<String> authors) throws SQLException;
}
