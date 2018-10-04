import beans.Author;
import beans.Book;
import dao.DBImplementation;
import dao.DBIn;
import dao.DBOut;
import dao.dao_factories.InFactory;
import dao.dao_factories.OutFactory;
import interfaces.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        try {
            DAO in = new InFactory().createIN();
            DAO out = new OutFactory().createOUT();
            System.out.println(out.getAuthor("Сергей", "Лукьяненко"));
            System.out.println(out.getBook("Конкуренты"));
            System.out.println(in.addAuthor("Михаил", "Королюк", new ArrayList<>(Collections.singletonList(new Book("Cпасти СССР")))));
            System.out.println(in.addBook("Колесо времени", new ArrayList<>(Collections.singletonList(new Author("Роберт", "Джордан")))));
            in.addAuthor("Артем","Каменистый", new ArrayList<>(Collections.singletonList(new Book("Практикантка"))));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
