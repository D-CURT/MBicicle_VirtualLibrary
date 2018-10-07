package beans;

import java.util.List;

public class Content {
    private int id;
    private String name;
    private List<String> books;

    public Content() {
    }

    public Content(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Content(int id, String name, List<String> books) {
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

    public List<String> getList() {
        return books;
    }
}
