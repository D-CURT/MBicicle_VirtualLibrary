import dao.DBIn;
import dao.DBOut;
import dao.interfaces.DAO_in;
import dao.interfaces.DAO_out;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Collections.singletonList;

public class Main {

    public static void main(String[] args) {
        try {
            DAO_in in = new DBIn();
            DAO_out out = new DBOut();

            in.addAuthor("Дмитрий Рус", Arrays.asList(
                    ("Инферно"),
                    ("Битва"),
                    ("Война"),
                    ("Исход")));
            System.out.println(out.getAuthor("Роберт Джордан"));
            System.out.println(out.getBook("Практикантка"));
            in.addBook("Клан", new ArrayList<>(singletonList("Дмитрий Рус")));
            in.addAuthor("Сергей Шолохов", new ArrayList<>(singletonList("Тихий дон")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
