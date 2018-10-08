package dao;

import beans.Content;
import dao.interfaces.DAOApplier;
import support.ConnectionManager;
import support.sections.SQLSection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.requireNonNull;
import static support.constants.Constants.*;
import static support.constants.Constants.INSERT_PAIR;
import static support.constants.Constants.SECOND_ARGUMENT;
import static support.sections.SQLSection.AUTHOR;
import static support.sections.SQLSection.BOOK;

abstract class AbstractDAO implements DAOApplier {

    @Override
    public boolean adding(String name, List<String> tiedNames, SQLSection sqlSection) {
        return false;
    }

    @Override
    public Content apply(String name, SQLSection sqlSection) {
        return null;
    }

    final Content get(String name, SQLSection sqlSection) throws SQLException {
        ResultSet set = null;
        try (Connection connection = ConnectionManager.createConnection();
             PreparedStatement statement = connection.prepareStatement(sqlSection.getContentSQL())) {

            statement.setString(FIRST_ARGUMENT, name);
            set = statement.executeQuery();

            if (set.next()) {
                int id = set.getInt(FIRST_ARGUMENT);

                List<String> contentNames = getTiedNamesByID(id, sqlSection.getContentNamesSQL());

                return new Content(id, name, contentNames);
            }
        } finally {
            ConnectionManager.closeResultSet(set);
        }
        return null;
    }

    final boolean add(String name, List<String> list, SQLSection sqlSection) throws SQLException {
        int counter = 0;
        counter = insert(name, sqlSection) ? ++counter : counter;
        int single = getContentID(name, sqlSection);
        List<Integer> tiedList = new ArrayList<>();

        SQLSection localSec = sqlSection == AUTHOR ? BOOK : AUTHOR;
        for (String s: list) {
            counter = insert(s, localSec) ? ++counter : counter;
            tiedList.add(getContentID(s, localSec));
        }
        toPair(single, tiedList, sqlSection);
        return counter != 0;
    }

    private int getContentID(String name, SQLSection section) throws SQLException {
        return requireNonNull(get(name, section)).getId();
    }

    private void toPair(int single, List<Integer> list, SQLSection sqlSection) throws SQLException {
        for (Integer id: list) {
            if (sqlSection == AUTHOR) insertPair(single, id);
            else insertPair(id, single);
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

    private List<String> getTiedNamesByID(int id, String sql) throws SQLException {
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