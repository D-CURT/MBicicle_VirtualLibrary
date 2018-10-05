import dao.DBIn;
import dao.DBOut;
import dao.interfaces.DAOin;
import dao.interfaces.DAOout;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Collections.singletonList;

public class Main {

    public static void main(String[] args) {
        try {
            DAOin in = new DBIn();
            DAOout out = new DBOut();

            /*in.addAuthor("Роберт Джордан", Arrays.asList(("Око мира"),
                    ("Великая охота"),
                    ("Возражденный дракон"),
                    ("Восходящая тень"),
                    ("Огни небес"),
                    ("Властелин хаоса"),
                    ("Корона мечей"),
                    ("Путь кинжалов"),
                    ("Сердце зимы"),
                    ("Перекрестки сумерек"),
                    ("Нож сновидений"),
                    ("Грядущая буря"),
                    ("Башни полуночи"),
                    ("Память света")));*/
            System.out.println(out.getAuthor("Роберт Джордан"));
            System.out.println(out.getBook("Практикантка"));
            in.addBook("Клан", new ArrayList<>(Arrays.asList("Дмитрий Рус")));
            in.addAuthor("Сергей Шолохов", new ArrayList<>(singletonList("Тихий дон")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
