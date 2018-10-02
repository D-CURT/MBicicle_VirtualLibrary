package interfaces;

import beans.Author;
import beans.Book;

import java.sql.SQLException;
import java.util.List;

public interface DAO {
    Author getAuthor(String name, String surname) throws SQLException;
    Book getBook(String name) throws SQLException;
    boolean addAuthor(String name, String surname, List<Book> books) throws SQLException;
    boolean addBook(String name, List<Author> authors) throws SQLException;
}
