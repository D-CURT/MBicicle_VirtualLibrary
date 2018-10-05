package dao;

import beans.Author;
import beans.Book;
import dao.interfaces.DAO_out;

import java.sql.SQLException;

public class DBOut implements DAO_out {
    @Override
    public Author getAuthor(String name) throws SQLException {
        return DBImplementation.getAuthor(name);
    }

    @Override
    public Book getBook(String name) throws SQLException {
        return DBImplementation.getBook(name);
    }
}
