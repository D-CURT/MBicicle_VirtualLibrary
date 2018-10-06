import dao.DB_in;
import dao.DB_out;
import support.sections.SQLSection;

import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Collections.singletonList;

public class Main {

    public static void main(String[] args) {
        DB_in daoIn = new DB_in();
        System.out.println(daoIn.apply("Дмитрий Рус", Arrays.asList(
                ("Инферно"),
                ("Битва"),
                ("Война"),
                ("Исход")), SQLSection.AUTHOR));
        System.out.println(daoIn.apply("Клан", new ArrayList<>(singletonList("Дмитрий Рус")), SQLSection.BOOK));
        System.out.println(daoIn.apply("Сергей Шолохов", new ArrayList<>(singletonList("Тихий дон")), SQLSection.AUTHOR));
        System.out.println(daoIn.apply("Михаил Королюк", new ArrayList<>(singletonList("Адаптация")), SQLSection.AUTHOR));
        DB_out daoOut = new DB_out();
        System.out.println(daoOut.apply("Роберт Джордан", SQLSection.AUTHOR));
        System.out.println(daoOut.apply("Практикантка", SQLSection.BOOK));
    }
}
