package dao;

import dao.interfaces.DAO_in;

import java.sql.SQLException;
import java.util.List;

public class DBIn implements DAO_in {

    @Override
    public boolean addAuthor(String name, List<String> books) throws SQLException {
        return DBImplementation.addAuthor(name, books);
    }

    @Override
    public boolean addBook(String name, List<String> authors) throws SQLException {
        return DBImplementation.addBook(name, authors);
    }
}
