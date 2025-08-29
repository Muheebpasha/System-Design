package exception;

public class UnknownColorException extends Exception {
    public UnknownColorException(String colour) {
        super("Unknown Color to set :- " + colour);
    }
}
