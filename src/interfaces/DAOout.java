package interfaces;

import beans.Author;
import beans.Book;

import java.sql.SQLException;

public interface DAOout {
    Author getAuthor(String name, String surname) throws SQLException;
    Book getBook(String name) throws SQLException;
}
