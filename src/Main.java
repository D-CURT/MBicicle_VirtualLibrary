import dao.DBImplementation;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        try {
            System.out.println(new DBImplementation().getAuthor("Сергей", "Лукьяненко"));
            System.out.println(new DBImplementation().getBook("Конкуренты"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
