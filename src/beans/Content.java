package beans;

import java.util.List;

public class Content {
    private int id;
    private String name;
    private List<String> tiedNames;

    public Content() {
    }

    public Content(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Content(int id, String name, List<String> tiedNames) {
        this.id = id;
        this.name = name;
        this.tiedNames = tiedNames;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getTiedNames() {
        return tiedNames;
    }
}
