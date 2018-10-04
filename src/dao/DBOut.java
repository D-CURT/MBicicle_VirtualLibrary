package dao;

import beans.Author;
import beans.Book;

import java.sql.SQLException;

public class DBOut extends DBImplementation {
    @Override
    public Author getAuthor(String name, String surname) throws SQLException {
        return super.getAuthor(name, surname);
    }

    @Override
    public Book getBook(String name) throws SQLException {
        return super.getBook(name);
    }
}
