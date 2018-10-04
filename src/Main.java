import beans.Book;
import dao.DBIn;
import dao.DBOut;
import interfaces.DAOin;
import interfaces.DAOout;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        try {
            DAOin in = new DBIn();
            DAOout out = new DBOut();
            in.addAuthor("Роберт", "Джордан", new ArrayList<>(
                    Arrays.asList(new Book("Око мира"),
                                  new Book("Великая охота"),
                                  new Book("Возражденный дракон"),
                                  new Book("Восходящая тень"),
                                  new Book("Огни небес"),
                                  new Book("Властелин хаоса"),
                                  new Book("Корона мечей"),
                                  new Book("Путь кинжалов"),
                                  new Book("Сердце зимы"),
                                  new Book("Перекрестки сумерек"),
                                  new Book("Нож сновидений"),
                                  new Book("Грядущая буря"),
                                  new Book("Башни полуночи"),
                                  new Book("Память света"))
            ));
            System.out.println(out.getAuthor("Роберт", "Джордан"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
