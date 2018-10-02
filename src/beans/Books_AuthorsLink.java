package beans;

public class Books_AuthorsLink {
    private int id;
    private int idAuthor;
    private int idBook;

    public Books_AuthorsLink(int id, int idAuthor, int idBook) {
        this.id = id;
        this.idAuthor = idAuthor;
        this.idBook = idBook;
    }

    public int getId() {
        return id;
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public int getIdBook() {
        return idBook;
    }
}
