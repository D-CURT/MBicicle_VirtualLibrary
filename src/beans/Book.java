package beans;

import java.util.List;

public class Book {
    private int id;
    private String name;
    private List<Author> authors;

    public Book() {
    }

    public Book(String name) {
        this.name = name;
    }

    public Book(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Book(String name, List<Author> authors) {
        this.name = name;
        this.authors = authors;
    }

    public Book(int id, String name, List<Author> authors) {
        this.id = id;
        this.name = name;
        this.authors = authors;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", authors=" + authors +
                '}';
    }
}
