package dao;

import beans.Author;
import beans.Book;
import interfaces.DAOout;

import java.sql.SQLException;

public class DBOut implements DAOout {
    @Override
    public Author getAuthor(String name, String surname) throws SQLException {
        return DBImplementation.getAuthor(name, surname);
    }

    @Override
    public Book getBook(String name) throws SQLException {
        return DBImplementation.getBook(name);
    }
}
