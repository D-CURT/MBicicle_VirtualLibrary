import dao.DB_in;
import dao.DB_out;
import dao.interfaces.DAOApplier;
import services.Librarian;
import support.sections.OperationSection;

import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Collections.singletonList;

public class Main {

    public static void main(String[] args) {
        Librarian librarian;
        DAOApplier applier = new DB_in();

        librarian = new Librarian(applier);
        System.out.println(librarian.serve("Роберт Джордан", Arrays.asList(
                ("Око мира"),
                ("Великая охота")), OperationSection.ADD_AUTHOR));

        librarian = new Librarian(applier);
        System.out.println(librarian.serve("Дмитрий Рус", Arrays.asList(
                ("Инферно"),
                ("Битва"),
                ("Война"),
                ("Исход")), OperationSection.ADD_AUTHOR));

        librarian = new Librarian(applier);
        System.out.println(librarian.serve("Срыв", new ArrayList<>(singletonList("Дмитрий Рус")), OperationSection.ADD_BOOK));

        applier = new DB_out();
        librarian = new Librarian(applier);
        System.out.println(librarian.serve("Роберт Джордан", OperationSection.GET_AUTHOR));

        librarian = new Librarian(applier);
        System.out.println(librarian.serve("Практикантка", OperationSection.GET_BOOK));


        /*System.out.println(new Result("Срыв", daoOut.apply("Срыв", SQLSection.BOOK), OperationSection.GET_BOOK));
        System.out.println(new Result("Роберт Джордан", daoOut.apply("Роберт Джордан", SQLSection.AUTHOR), OperationSection.GET_AUTHOR));*/
    }
}
