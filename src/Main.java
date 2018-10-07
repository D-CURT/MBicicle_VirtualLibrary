import beans.Result;
import dao.DB_in;
import dao.DB_out;
import services.Librarian;
import support.sections.OperationSection;
import support.sections.SQLSection;

import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Collections.singletonList;

public class Main {

    public static void main(String[] args) {
        Librarian librarian;

        librarian = new Librarian("Роберт Джордан", Arrays.asList(
                ("Око мира"),
                ("Великая охота")), OperationSection.ADD_AUTHOR);
        System.out.println(librarian.serve());

        librarian = new Librarian("Дмитрий Рус", Arrays.asList(
                ("Инферно"),
                ("Битва"),
                ("Война"),
                ("Исход")), OperationSection.ADD_AUTHOR);
        System.out.println(librarian.serve());

        librarian = new Librarian("Срыв", new ArrayList<>(singletonList("Дмитрий Рус")), OperationSection.ADD_BOOK);
        System.out.println(librarian.serve());

        librarian = new Librarian("Роберт Джордан", OperationSection.GET_AUTHOR);
        System.out.println(librarian.serve());

        librarian = new Librarian("Практикантка", OperationSection.GET_BOOK);
        System.out.println(librarian.serve());


        /*System.out.println(new Result("Срыв", daoOut.apply("Срыв", SQLSection.BOOK), OperationSection.GET_BOOK));
        System.out.println(new Result("Роберт Джордан", daoOut.apply("Роберт Джордан", SQLSection.AUTHOR), OperationSection.GET_AUTHOR));*/
    }
}
