package exceptions;

public class DBSelectingException extends MBicicleException {
    public DBSelectingException() {
        super("Selecting failed!");
    }
}
