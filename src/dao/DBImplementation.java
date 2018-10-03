package dao;

import beans.Author;
import beans.Book;
import exceptions.DBSelectingException;
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
        ResultSet set = null;
        List<Book> books = new ArrayList<>();
        try (Connection connection = ConnectionManager.createConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_AUTHOR)) {

            statement.setString(FIRST_ARGUMENT, name);
            statement.setString(SECOND_ARGUMENT, surname);

            set = statement.executeQuery();

            if (set.next()) {
                int idAuthor = set.getInt(FIRST_ARGUMENT);


                for (Integer id: fromPair(idAuthor, FIND_BOOK_BY_AUTHOR))
                    books.add(getBookByID(id));

                return new Author(idAuthor, name, surname, books.size() > 0 ? books : null);
            }
            return null;
        } finally {
            ConnectionManager.closeResultSet(set);
        }
    }

    @Override
    public Book getBook(String name) throws SQLException {
        ResultSet set = null;
        List<Author> authors = new ArrayList<>();
        try (Connection connection = ConnectionManager.createConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BOOK)) {

            statement.setString(FIRST_ARGUMENT, name);
            System.out.println(statement);

            set = statement.executeQuery();
            if (set.next()) {
                int idBook = set.getInt(FIRST_ARGUMENT);

                for (Integer id: fromPair(idBook, FIND_AUTHOR_BY_BOOK))
                    authors.add(getAuthorById(id));
                return new Book(idBook, name, authors.size() > 0 ? authors : null);
            }
            return null;
        } finally {
            ConnectionManager.closeResultSet(set);
        }
    }

    @Override
    public boolean addAuthor(String name, String surname, List<Book> books) throws SQLException {
        insertAuthor(name, surname);
        Author a = getAuthor(name, surname);
        Book b;

        for (int i = 0; i < books.size(); i++) {
            b = books.get(i);
            insertBook(b.getName());
            books.set(i, getBook(b.getName()));
        }
        List<Author> authors = new ArrayList<>();
        authors.add(a);
        toPair(authors, books);
        return true;
    }

    @Override
    public boolean addBook(String name, List<Author> authors) throws SQLException {
        Book b;
        if ((b = getBook(name)) == null) {
            insertBook(name);
            b = getBook(name);
        }

        return false;
    }

    private void toPair(List<Author> authors, List<Book> books) throws SQLException {

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

    private void insertAuthor(String name, String surname) throws SQLException {
        if (getAuthor(name, surname) == null) {
            ResultSet set = null;
            try (Connection connection = ConnectionManager.createConnection();
                 PreparedStatement statement = connection.prepareStatement(INSERT_AUTHOR)) {

                statement.setString(FIRST_ARGUMENT, name);
                statement.setString(SECOND_ARGUMENT, surname);
                statement.execute();
            } finally {
                ConnectionManager.closeResultSet(set);
            }
        }
    }

    private void insertBook(String name) throws SQLException {
        if (getBook(name) == null) {
            ResultSet set = null;
            try (Connection connection = ConnectionManager.createConnection();
                 PreparedStatement statement = connection.prepareStatement(INSERT_BOOK)) {

                statement.setString(FIRST_ARGUMENT, name);
                statement.execute();
            } finally {
                ConnectionManager.closeResultSet(set);
            }
        }
    }
}
