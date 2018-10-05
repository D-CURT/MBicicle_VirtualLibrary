package dao;

import beans.Author;
import beans.Book;
import beans.Content;
import support.ConnectionManager;
import support.sections.ContentSection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static java.util.Collections.singletonList;
import static java.util.Objects.requireNonNull;
import static support.constants.Constants.*;
import static support.sections.ContentSection.AUTHOR;
import static support.sections.ContentSection.BOOK;

class DBImplementation {

    private static Content get(String name, ContentSection section) throws SQLException {
        ResultSet set = null;
        List<String> contents = new ArrayList<>();
        try (Connection connection = ConnectionManager.createConnection();
             PreparedStatement statement = connection.prepareStatement(section.getContentSQL())) {

            statement.setString(FIRST_ARGUMENT, name);

            set = statement.executeQuery();

            if (set.next()) {
                int id = set.getInt(FIRST_ARGUMENT);


                for (Integer index: fromPair(id, section.getContentNamesSQL()))
                    contents.add(getContentByID(index, section.getNameByIDSQL()));

                return section == AUTHOR ? new Author(id, name, contents.size() > 0 ? contents : null)
                                         : new Book(id, name, contents.size() > 0 ? contents : null);
            }
        } finally {
            ConnectionManager.closeResultSet(set);
        }
        return null;
    }

    static Author getAuthor(String name) throws SQLException{
        return (Author) get(name, AUTHOR);
    }

    static Book getBook(String name) throws SQLException {
        return (Book) get(name, BOOK);
    }

    private static boolean add(String name, List<String> list, ContentSection section) throws SQLException {
        insert(name, section);
        List<Integer> one = new ArrayList<>(singletonList(
                requireNonNull(get(name, section)).getId()));
        List<Integer> listID = new ArrayList<>();

        ContentSection contentSection = section == AUTHOR ? BOOK : AUTHOR;
        for (String s: list) {
            insert(s, contentSection);
            listID.add(requireNonNull(get(s, contentSection)).getId());
        }

        toPair(one, listID, section);
        return true;
    }

    static boolean addAuthor(String name, List<String> bookNames) throws SQLException {
        return add(name, bookNames, AUTHOR);
    }

    static boolean addBook(String name, List<String> authorNames) throws SQLException {

        return add(name, authorNames, BOOK);
    }

    private static void toPair(List<Integer> authors, List<Integer> books, ContentSection section) throws SQLException {
        for (Integer id: section == AUTHOR ? books : authors) {
            insertPair(section == AUTHOR ? authors.get(0) : books.get(0), id);
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

    private static void insert(String name, ContentSection section) throws SQLException {
        if (get(name, section) == null) {
            try (Connection connection = ConnectionManager.createConnection();
                 PreparedStatement statement = connection.prepareStatement(section.getInsertionSQL())) {

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
