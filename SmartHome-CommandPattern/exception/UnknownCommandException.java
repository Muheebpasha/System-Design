package exception;


public class UnknownCommandException extends Exception {

    public UnknownCommandException(String commandString) {
        super("This Command is not exists :- " + commandString);
    }

}
