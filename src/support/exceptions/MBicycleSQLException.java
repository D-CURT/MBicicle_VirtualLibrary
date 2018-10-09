package support.exceptions;

public class MBicycleSQLException extends MBicycleException {
    public MBicycleSQLException(String message) {
        super("Working with DB failed: " + message);
    }
}
