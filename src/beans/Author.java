package beans;

import java.util.List;

public class Author implements Content {
    private int id;
    private String name;
    private List<String> books;

    public Author() {
    }

    public Author(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Author(int id, String name,List<String> books) {
        this.id = id;
        this.name = name;
        this.books = books;
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
        return books;
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
