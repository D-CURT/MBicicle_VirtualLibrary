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

    @Override
    public Author getAuthor(String name, String surname) throws SQLException{
        int idAuthor = 0;
        ResultSet set = null;
        List<Book> books = new ArrayList<>();
        try (Connection connection = ConnectionManager.createConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_AUTHOR)) {

            statement.setString(FIRST_ARGUMENT, name);
            statement.setString(SECOND_ARGUMENT, surname);
            System.out.println(statement);

            set = statement.executeQuery();
            idAuthor = set.next() ? set.getInt(FIRST_ARGUMENT) : idAuthor;

            for (Integer id: fromPair(idAuthor, FIND_BOOK_BY_AUTHOR))
                books.add(getBookByID(id));

            return new Author(idAuthor, name, surname, books);
        } finally {
            ConnectionManager.closeResultSet(set);
        }
    }

    @Override
    public Book getBook(String name) throws SQLException {
        int idBook = 0;
        ResultSet set = null;
        List<Author> authors = new ArrayList<>();
        try (Connection connection = ConnectionManager.createConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BOOK)) {

            statement.setString(FIRST_ARGUMENT, name);
            System.out.println(statement);

            set = statement.executeQuery();
            idBook = set.next() ? set.getInt(FIRST_ARGUMENT) : idBook;

            for (Integer id: fromPair(idBook, FIND_AUTHOR_BY_BOOK))
                authors.add(getAuthorById(id));
            return new Book(idBook, name, authors);
        } finally {
            ConnectionManager.closeResultSet(set);
        }

    }

    @Override
    public boolean addAuthor(String name, String surname, List<Book> books) {
        return false;
    }

    @Override
    public boolean addBook(String name, List<Author> authors) {
        return false;
    }

    private List<Integer> fromPair(int id, String sgl) throws SQLException {
        List<Integer> list = new ArrayList<>();
        ResultSet set = null;
        try (Connection connection = ConnectionManager.createConnection();
             PreparedStatement statement = connection.prepareStatement(sgl)) {

            statement.setInt(FIRST_ARGUMENT, id);
            System.out.println(statement);
            set = statement.executeQuery();
            while (set.next())
                list.add(set.getInt(FIRST_ARGUMENT));
            return list;
        } finally {
            ConnectionManager.closeResultSet(set);
        }
    }

    private Author getAuthorById(int id) throws SQLException {
        ResultSet set = null;
        try (Connection connection = ConnectionManager.createConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_AUTHOR_BY_ID)) {
            statement.setInt(FIRST_ARGUMENT, id);
            set = statement.executeQuery();
            return set.next() ? new Author(set.getInt(FIRST_ARGUMENT),
                    set.getString(SECOND_ARGUMENT), set.getString(THIRD_ARGUMENT)) : null;
        } finally {
            ConnectionManager.closeResultSet(set);
        }
    }

    private Book getBookByID(int id) throws SQLException {
        ResultSet set = null;
        try (Connection connection = ConnectionManager.createConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BOOK_BY_ID)) {

            statement.setInt(FIRST_ARGUMENT, id);
            set = statement.executeQuery();
            return set.next() ? new Book(set.getInt(FIRST_ARGUMENT), set.getString(SECOND_ARGUMENT)) : null;
        } finally {
            ConnectionManager.closeResultSet(set);
        }
    }

    private boolean insertAuthor(String name, String surname) {

        return true;
    }

    private boolean insertBook(String name) {

        return true;
    }
}
