package beans;

import interfaces.Content;

import java.util.List;
import java.util.stream.Collectors;

public class Book implements Content {
    private int id;
    private String name;
    private List<String> authors;

    public Book() {
    }

    public Book(String name) {
        this.name = name;
    }

    public Book(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Book(String name, List<String> authors) {
        this.name = name;
        this.authors = authors;
    }

    public Book(int id, String name, List<String> authors) {
        this.id = id;
        this.name = name;
        this.authors = authors;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<String> getList() {
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
