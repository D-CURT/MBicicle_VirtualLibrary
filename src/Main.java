import dao.DB_in;
import dao.DB_out;
import dao.interfaces.DAOApplier;
import services.Librarian;
import support.sections.OperationSection;

import java.util.Arrays;
import static java.util.Collections.singletonList;

public class Main {

    public static void main(String[] args) {
        Librarian librarian;
        DAOApplier applier = new DB_in();

        librarian = new Librarian(applier);
        System.out.println(librarian.add("Роберт Джордан", Arrays.asList(
                ("Око мира"),
                ("Великая охота")), OperationSection.ADD_AUTHOR));

        System.out.println(librarian.add("Дмитрий Рус", Arrays.asList(
                ("Инферно"),
                ("Битва"),
                ("Война"),
                ("Исход")), OperationSection.ADD_AUTHOR));

        System.out.println(librarian.add("Срыв", singletonList("Дмитрий Рус"), OperationSection.ADD_BOOK));

        applier = new DB_out();
        librarian = new Librarian(applier);
        System.out.println(librarian.get("Роберт Джордан", OperationSection.GET_AUTHOR));

        System.out.println(librarian.get("Практикантка", OperationSection.GET_BOOK));

        System.out.println(librarian.get("Восходящая тень", OperationSection.GET_BOOK));
    }
}
