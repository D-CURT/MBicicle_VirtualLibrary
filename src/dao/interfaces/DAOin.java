package dao.interfaces;

import beans.Author;
import beans.Book;

import java.sql.SQLException;
import java.util.List;

public interface DAOin {
    boolean addAuthor(String name, List<String> books) throws SQLException;
    boolean addBook(String name, List<String> authors) throws SQLException;
}
