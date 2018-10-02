import dao.DBImplementation;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        try {
            System.out.println(new DBImplementation().getAuthor("Сергей", "Лукьяненко"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
