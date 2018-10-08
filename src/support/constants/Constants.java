package support.constants;

public class Constants {
    public static final String DRIVER_NAME = "org.gjt.mm.mysql.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost/mbicicle_db";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "";

    public static final String EMPTY = "";
    public static final String LINE = "\n";

    //===========   SQL   ============
    //_SELECT   ----------------------
    public static final String FIND_AUTHOR = "SELECT * FROM author WHERE name=?";
    public static final String FIND_BOOK = "SELECT * FROM book WHERE name=?";
    public static final String FIND_BOOKS_BY_AUTHOR = "SELECT name FROM book WHERE id IN (SELECT idBook FROM books_authors WHERE idAuthor=?)";
    public static final String FIND_AUTHORS_BY_BOOK = "SELECT name FROM author WHERE id IN (SELECT idAuthor FROM books_authors WHERE idBook=?)";
    public static final String FIND_PAIR = "SELECT * FROM books_authors WHERE idAuthor=? AND idBook=?";
    //--------------------------------

    //_INSERT   ----------------------
    public static final String INSERT_AUTHOR = "INSERT INTO author (name) VALUES (?)";
    public static final String INSERT_BOOK = "INSERT INTO book (name) VALUES (?)";
    public static final String INSERT_PAIR = "INSERT INTO books_authors (idAuthor, idBook) VALUES (?,?)";
    //--------------------------------

    //_INDEX   -----------------------
    public static final int FIRST_ARGUMENT = 1;
    public static final int SECOND_ARGUMENT = 2;
    //--------------------------------
}
