import dao.DBImplementation;

public class Main {

    public static void main(String[] args) {
        System.out.println(new DBImplementation().getAuthor("Сергей", "Лукьяненко"));
    }
}
