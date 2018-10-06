package dao;

import beans.Result;
import support.sections.OperationSection;

import java.sql.SQLException;
import java.util.List;

import static support.sections.SQLSection.AUTHOR;
import static support.sections.SQLSection.BOOK;

public class DB_in extends AbstractDAO {
    @Override
    public Result apply(String name, List<String> list, OperationSection section) {
        return null;
    }

    private boolean addAuthor(String name, List<String> bookNames) throws SQLException {
        return add(name, bookNames, AUTHOR);
    }

    private boolean addBook(String name, List<String> authorNames) throws SQLException {
        return add(name, authorNames, BOOK);
    }
}
