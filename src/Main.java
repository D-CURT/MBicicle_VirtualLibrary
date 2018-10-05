import dao.DBIn;
import dao.DBOut;
import dao.interfaces.DAOin;
import dao.interfaces.DAOout;

import java.sql.SQLException;

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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
