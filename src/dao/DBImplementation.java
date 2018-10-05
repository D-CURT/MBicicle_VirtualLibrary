package dao;

import beans.Author;
import beans.Book;
import beans.Content;
import support.ConnectionManager;
import support.sections.SQLSection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.singletonList;
import static java.util.Objects.requireNonNull;
import static support.constants.Constants.*;
import static support.sections.SQLSection.AUTHOR;
import static support.sections.SQLSection.BOOK;

public class DBImplementation {

    private static Content get(String name, SQLSection sqlSection) throws SQLException {
        ResultSet set = null;
        List<String> contents = new ArrayList<>();
        try (Connection connection = ConnectionManager.createConnection();
             PreparedStatement statement = connection.prepareStatement(sqlSection.getContentSQL())) {

            statement.setString(FIRST_ARGUMENT, name);

            set = statement.executeQuery();

            if (set.next()) {
                int id = set.getInt(FIRST_ARGUMENT);


                for (Integer index: fromPair(id, sqlSection.getContentNamesSQL()))
                    contents.add(getContentByID(index, sqlSection.getNameByIDSQL()));

                if (contents.size() == 0) contents = null;

                return sqlSection == AUTHOR ? new Author(id, name, contents)
                                         : new Book(id, name, contents);
            }
        } finally {
            ConnectionManager.closeResultSet(set);
        }
        return null;
    }

    public static Author getAuthor(String name) throws SQLException{
        return (Author) get(name, AUTHOR);
    }

    public static Book getBook(String name) throws SQLException {
        return (Book) get(name, BOOK);
    }

    private static boolean add(String name, List<String> list, SQLSection sqlSection) throws SQLException {
        insert(name, sqlSection);
        List<Integer> one = new ArrayList<>(singletonList(
                requireNonNull(get(name, sqlSection)).getId()));
        List<Integer> listID = new ArrayList<>();

        SQLSection SQLSection = sqlSection == AUTHOR ? BOOK : AUTHOR;
        for (String s: list) {
            insert(s, SQLSection);
            listID.add(requireNonNull(get(s, SQLSection)).getId());
        }

        toPair(one, listID, sqlSection);
        return true;
    }

    public static boolean addAuthor(String name, List<String> bookNames) throws SQLException {
        return add(name, bookNames, AUTHOR);
    }

    public static boolean addBook(String name, List<String> authorNames) throws SQLException {

        return add(name, authorNames, BOOK);
    }

    private static void toPair(List<Integer> authors, List<Integer> books, SQLSection sqlSection) throws SQLException {
        for (Integer id: sqlSection == AUTHOR ? books : authors) {
            insertPair(sqlSection == AUTHOR ? authors.get(0) : books.get(0), id);
        }
    }

    private static List<Integer> fromPair(int id, String sgl) throws SQLException {
        List<Integer> list = new ArrayList<>();
        ResultSet set = null;
        try (Connection connection = ConnectionManager.createConnection();
             PreparedStatement statement = connection.prepareStatement(sgl)) {

            statement.setInt(FIRST_ARGUMENT, id);
            set = statement.executeQuery();
            while (set.next())
                list.add(set.getInt(FIRST_ARGUMENT));
            return list;
        } finally {
            ConnectionManager.closeResultSet(set);
        }
    }

    private static boolean noPair(int a, int b) throws SQLException {
        try (Connection connection = ConnectionManager.createConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_PAIR)) {

            statement.setInt(FIRST_ARGUMENT, a);
            statement.setInt(SECOND_ARGUMENT, b);
            return !statement.executeQuery().next();
        }
    }

    private static String getContentByID(int id, String sql) throws SQLException {
        ResultSet set = null;
        try (Connection connection = ConnectionManager.createConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(FIRST_ARGUMENT, id);
            set = statement.executeQuery();
            return set.next() ? set.getString(FIRST_ARGUMENT) : EMPTY;
        } finally {
            ConnectionManager.closeResultSet(set);
        }
    }

    private static void insert(String name, SQLSection sqlSection) throws SQLException {
        if (get(name, sqlSection) == null) {
            try (Connection connection = ConnectionManager.createConnection();
                 PreparedStatement statement = connection.prepareStatement(sqlSection.getInsertionSQL())) {

                statement.setString(FIRST_ARGUMENT, name);
                statement.execute();
            }
        }
    }

    private static void insertPair(int a, int b) throws SQLException {
        if (noPair(a, b)) {
            try (Connection connection = ConnectionManager.createConnection();
                 PreparedStatement statement = connection.prepareStatement(INSERT_PAIR)) {

                statement.setInt(FIRST_ARGUMENT, a);
                statement.setInt(SECOND_ARGUMENT, b);
                statement.execute();
            }
        }
    }
}
