package dao;

import beans.Author;
import beans.Book;
import interfaces.DAOin;

import java.sql.SQLException;
import java.util.List;

public class DBIn implements DAOin {

    @Override
    public boolean addAuthor(String name, List<Book> books) throws SQLException {
        return DBImplementation.addAuthor(name, books);
    }

    @Override
    public boolean addBook(String name, List<Author> authors) throws SQLException {
        return DBImplementation.addBook(name, authors);
    }
}
