import beans.Result;
import dao.DB_in;
import dao.DB_out;
import support.sections.OperationSection;
import support.sections.SQLSection;

import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Collections.singletonList;

public class Main {

    public static void main(String[] args) {
        DB_in daoIn = new DB_in();
        System.out.println(daoIn.apply("Роберт Джордан", Arrays.asList(
                ("Око мира"),
                ("Великая охота")), SQLSection.AUTHOR));
        System.out.println(daoIn.apply("Дмитрий Рус", Arrays.asList(
                ("Инферно"),
                ("Битва"),
                ("Война"),
                ("Исход")), SQLSection.AUTHOR));
        System.out.println(daoIn.apply("Клан", new ArrayList<>(singletonList("Дмитрий Рус")), SQLSection.BOOK));
        System.out.println(daoIn.apply("Сергей Шолохов", new ArrayList<>(singletonList("Тихий дон")), SQLSection.AUTHOR));
        System.out.println(daoIn.apply("Михаил Королюк", new ArrayList<>(singletonList("Адаптация")), SQLSection.AUTHOR));
        System.out.println(daoIn.apply("Срыв", new ArrayList<>(singletonList("Дмитрий Рус")), SQLSection.BOOK));
        System.out.println(new Result("Срыв", new ArrayList<>(singletonList("Дмитрий Рус")), true, OperationSection.ADD_BOOK));
        DB_out daoOut = new DB_out();
        System.out.println(daoOut.apply("Роберт Джордан", SQLSection.AUTHOR));
        System.out.println(daoOut.apply("Практикантка", SQLSection.BOOK));
        System.out.println(new Result("Срыв", daoOut.apply("Срыв", SQLSection.BOOK), OperationSection.GET_BOOK));
        System.out.println(new Result("Роберт Джордан", daoOut.apply("Роберт Джордан", SQLSection.AUTHOR), OperationSection.GET_AUTHOR));
    }
}
