package beans;

import java.util.List;
import java.util.stream.Collectors;

public class Author {
    private int id;
    private String name;
    private List<Book> books;

    public Author() {
    }

    public Author(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Author(int id, String name,List<Book> books) {
        this.id = id;
        this.name = name;
        this.books = books;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getBooks() {
        return books.stream()
                    .map(Book::getName)
                    .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", books=" + books +
                '}';
    }
}
