package dao;

import beans.Author;
import beans.Book;
import interfaces.DAO;

import java.util.List;

public class DBImplementation implements DAO {

    @Override
    public Author getAuthor(String name, String surname) {
        return null;
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

    private boolean insertAuthor(String name, String surname) {

        return true;
    }

    private boolean insertBook(String name) {

        return true;
    }
}
