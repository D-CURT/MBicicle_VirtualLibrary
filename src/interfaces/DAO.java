package interfaces;

import beans.Author;
import beans.Book;

import java.util.List;

public interface DAO {
    Author getAuthor(String name, String surname);
    Book getBook(String name);
    boolean addAuthor(String name, String surname, List<Book> books);
    boolean addBook(String name, List<Author> authors);
    boolean addAuthors_BooksLink(int idAuthor, int idBook);
}
