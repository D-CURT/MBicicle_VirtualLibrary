package dao.interfaces;

import beans.Author;
import beans.Book;

import java.sql.SQLException;
import java.util.List;

public interface DAOin {
    boolean addAuthor(String name, List<Book> books) throws SQLException;
    boolean addBook(String name, List<Author> authors) throws SQLException;
}
