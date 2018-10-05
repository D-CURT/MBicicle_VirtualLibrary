package dao.interfaces;

import beans.Author;
import beans.Book;

import java.sql.SQLException;

public interface DAO_out {
    Author getAuthor(String name) throws SQLException;
    Book getBook(String name) throws SQLException;
}
