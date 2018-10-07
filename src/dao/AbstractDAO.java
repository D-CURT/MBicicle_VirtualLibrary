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
import static support.constants.Constants.INSERT_PAIR;
import static support.constants.Constants.SECOND_ARGUMENT;
import static support.sections.SQLSection.AUTHOR;
import static support.sections.SQLSection.BOOK;

abstract class AbstractDAO {

    final Content get(String name, SQLSection sqlSection) throws SQLException {
        ResultSet set = null;
        try (Connection connection = ConnectionManager.createConnection();
             PreparedStatement statement = connection.prepareStatement(sqlSection.getContentSQL())) {

            statement.setString(FIRST_ARGUMENT, name);
            set = statement.executeQuery();

            if (set.next()) {
                int id = set.getInt(FIRST_ARGUMENT);

                List<String> contentNames = getContentNamesByID(id, sqlSection.getContentNamesSQL());

                return sqlSection == AUTHOR ? new Author(id, name, contentNames)
                        : new Book(id, name, contentNames);
            }
        } finally {
            ConnectionManager.closeResultSet(set);
        }
        return null;
    }

    final boolean add(String name, List<String> list, SQLSection sqlSection) throws SQLException {
        int insertion = 0;
        insertion = insert(name, sqlSection) ? ++insertion : insertion;
        List<Integer> one = new ArrayList<>(singletonList(
                requireNonNull(get(name, sqlSection)).getId()));
        List<Integer> listID = new ArrayList<>();

        SQLSection SQLSection = sqlSection == AUTHOR ? BOOK : AUTHOR;
        for (String s: list) {
            insertion = insert(s, SQLSection) ? ++insertion : insertion;
            listID.add(requireNonNull(get(s, SQLSection)).getId());
        }
        toPair(one, listID, sqlSection);
        return insertion != 0;
    }

    private void toPair(List<Integer> authors, List<Integer> books, SQLSection sqlSection) throws SQLException {
        for (Integer id: sqlSection == AUTHOR ? books : authors) {
            insertPair(sqlSection == AUTHOR ? authors.get(0) : books.get(0), id);
        }
    }

    private boolean noPair(int a, int b) throws SQLException {
        try (Connection connection = ConnectionManager.createConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_PAIR)) {

            statement.setInt(FIRST_ARGUMENT, a);
            statement.setInt(SECOND_ARGUMENT, b);
            return !statement.executeQuery().next();
        }
    }

    private List<String> getContentNamesByID(int id, String sql) throws SQLException {
        ResultSet set = null;
        List<String> content = new ArrayList<>();
        try (Connection connection = ConnectionManager.createConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(FIRST_ARGUMENT, id);
            set = statement.executeQuery();
            while (set.next()) {
                content.add(set.getString(FIRST_ARGUMENT));
            }
            return content;
        } finally {
            ConnectionManager.closeResultSet(set);
        }
    }

    private boolean insert(String name, SQLSection sqlSection) throws SQLException {
        if (get(name, sqlSection) == null) {
            try (Connection connection = ConnectionManager.createConnection();
                 PreparedStatement statement = connection.prepareStatement(sqlSection.getInsertionSQL())) {

                statement.setString(FIRST_ARGUMENT, name);
                statement.execute();
                return true;
            }
        } return false;
    }

    private void insertPair(int a, int b) throws SQLException {
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