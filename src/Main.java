import beans.Author;
import beans.Book;
import dao.DBIn;
import dao.DBOut;
import interfaces.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        try {
            DAO in = new DBIn();
            DAO out = new DBOut();
            System.out.println(out.getAuthor("Сергей", "Лукьяненко"));
            System.out.println(out.getBook("Конкуренты"));
            in.addAuthor("Михаил", "Королюк", new ArrayList<>(Collections.singletonList(new Book("Cпасти СССР"))));
            in.addBook("Колесо времени", new ArrayList<>(Collections.singletonList(new Author("Роберт", "Джордан"))));
            in.addAuthor("Артем","Каменистый", new ArrayList<>(Collections.singletonList(new Book("Практикантка"))));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
