import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import static dao.DBImplementation.*;
import static java.util.Collections.singletonList;

public class Main {

    public static void main(String[] args) {
        try {


            addAuthor("Дмитрий Рус", Arrays.asList(
                    ("Инферно"),
                    ("Битва"),
                    ("Война"),
                    ("Исход")));
            System.out.println(getAuthor("Роберт Джордан"));
            System.out.println(getBook("Практикантка"));
            addBook("Клан", new ArrayList<>(singletonList("Дмитрий Рус")));
            addAuthor("Сергей Шолохов", new ArrayList<>(singletonList("Тихий дон")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
