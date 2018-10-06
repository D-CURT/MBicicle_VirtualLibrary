package support.exceptions;

public class MBicicleSQLException extends MBicicleException {
    public MBicicleSQLException(String message) {
        super("Working with DB failed: " + message);
    }
}
