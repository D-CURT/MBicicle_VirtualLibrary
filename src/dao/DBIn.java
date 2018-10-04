package dao;

import beans.Author;
import beans.Book;

import java.sql.SQLException;
import java.util.List;

public class DBIn extends DBImplementation {
    @Override
    public boolean addAuthor(String name, String surname, List<Book> books) throws SQLException {
        return super.addAuthor(name, surname, books);
    }

    @Override
    public boolean addBook(String name, List<Author> authors) throws SQLException {
        return super.addBook(name, authors);
    }
}
