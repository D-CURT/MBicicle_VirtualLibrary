import beans.Author;
import beans.Book;
import dao.DBImplementation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        try {
            DBImplementation impl = new DBImplementation();
            System.out.println(impl.getAuthor("Сергей", "Лукьяненко"));
            System.out.println(impl.getBook("Конкуренты"));
            System.out.println(impl.addAuthor("Михаил", "Королюк", new ArrayList<>(Collections.singletonList(new Book("Cпасти СССР")))));
            System.out.println(impl.addBook("Колесо времени", new ArrayList<>(Collections.singletonList(new Author("Роберт", "Джордан")))));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
