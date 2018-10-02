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
        List<Book> books = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(FIND_AUTHOR)) {

            statement.setString(FIRST_ARGUMENT, name);
            statement.setString(SECOND_ARGUMENT, surname);
            System.out.println(statement);

            ResultSet set = statement.executeQuery();
            idAuthor = set.next() ? set.getInt(FIRST_ARGUMENT) : idAuthor;

            for (Integer id: getBooksId_byAuthor(idAuthor)) {
                books.add(new Book(id, getBookNameByID(id)));
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

    private List<Integer> getBooksId_byAuthor(int idAuthor) {
        List<Integer> list = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(FIND_BOOK_BY_AUTHOR)) {

            statement.setInt(FIRST_ARGUMENT, idAuthor);
            System.out.println(statement);
            ResultSet set = statement.executeQuery();
            while (set.next())
                list.add(set.getInt(FIRST_ARGUMENT));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    private String getBookNameByID(int id) {
        try (PreparedStatement statement = connection.prepareStatement(FIND_BOOK_NAME_BY_ID)) {

            statement.setInt(FIRST_ARGUMENT, id);
            System.out.println(statement);
            ResultSet result = statement.executeQuery();
            return result.next() ? result.getString(FIRST_ARGUMENT) : EMPTY;
        } catch (SQLException e) {
            e.printStackTrace();
            return EMPTY;
        }
    }

    private boolean insertAuthor(String name, String surname) {

        return true;
    }

    private boolean insertBook(String name) {

        return true;
    }
}
