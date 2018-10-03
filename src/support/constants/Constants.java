package support.constants;

public class Constants {
    public static final String DRIVER_NAME = "org.gjt.mm.mysql.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost/mbicicle_db";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "";

    public static final String EMPTY = "";

    //===========   SQL   ============
    //_SELECT   ----------------------
    public static final String FIND_AUTHOR = "SELECT * FROM author WHERE name=? AND surname=?";
    public static final String FIND_BOOK = "SELECT * FROM book WHERE name=?";
    public static final String FIND_BOOK_BY_AUTHOR = "SELECT idBook FROM books_authors WHERE idAuthor=?";
    public static final String FIND_AUTHOR_BY_BOOK = "SELECT idAuthor FROM books_authors WHERE idBook=?";
    public static final String FIND_BOOK_BY_ID = "SELECT * FROM book WHERE id=?";
    public static final String FIND_AUTHOR_BY_ID = "SELECT * FROM author WHERE id=?";
    public static final String FIND_PAIR = "SELECT id FROM books_authors WHERE idAuthor=? AND idBook=?";
    //--------------------------------

    //_INSERT   ----------------------
    public static final String INSERT_AUTHOR = "INSERT INTO author (name, surname) VALUES (?,?)";
    public static final String INSERT_BOOK = "INSERT INTO book (name) VALUES (?)";
    public static final String INSERT_PAIR = "INSERT INTO books_authors (idAuthor, idBook) VALUES (?,?)";
    //--------------------------------

    //_INDEX   -----------------------
    public static final int FIRST_ARGUMENT = 1;
    public static final int SECOND_ARGUMENT = 2;
    public static final int THIRD_ARGUMENT = 3;
    //--------------------------------

}
