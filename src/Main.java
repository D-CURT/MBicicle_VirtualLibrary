import dao.DBImplementation;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        try {
            DBImplementation impl = new DBImplementation();
            System.out.println(impl.getAuthor("Сергей", "Лукьяненко"));
            System.out.println(impl.getBook("Конкуренты"));
            System.out.println(impl.addAuthor("Михаил", "Королюк", null ));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
