package dao;

import beans.Author;
import beans.Book;
import interfaces.DAO;
import support.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static support.constants.Constants.*;

public class DBImplementation implements DAO {
    private static Connection connection;

    static {
        try {
            connection = ConnectionManager.createConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Author getAuthor(String name, String surname) {
        int idAuthor = 0;
        int idBook;
        String nameBook;
        List<Book> books = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(FIND_AUTHOR)) {

            statement.setString(FIRST_ARGUMENT, name);
            statement.setString(SECOND_ARGUMENT, surname);

            ResultSet result = statement.executeQuery();
            result = getBooksId_byAuthor(idAuthor = result.getInt(FIRST_ARGUMENT));

            while (result.next()) {
                idBook = result.getInt(FIRST_ARGUMENT);
                nameBook = result.getString(SECOND_ARGUMENT);
                books.add(new Book(idBook, nameBook));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Author(idAuthor, name, surname, books);
    }

    @Override
    public Book getBook(String name) {
        return null;
    }

    @Override
    public boolean addAuthor(String name, String surname, List<Book> books) {
        return false;
    }

    @Override
    public boolean addBook(String name, List<Author> authors) {
        return false;
    }

    private ResultSet getBooksId_byAuthor(int idAuthor) {
        ResultSet set = null;
        try (PreparedStatement statement = connection.prepareStatement(FIND_BOOK_BY_AUTHOR)) {

            statement.setInt(FIRST_ARGUMENT, idAuthor);
            set = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return set;
    }

    private boolean insertAuthor(String name, String surname) {

        return true;
    }

    private boolean insertBook(String name) {

        return true;
    }
}
