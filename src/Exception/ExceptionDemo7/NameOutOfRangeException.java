package Exception.ExceptionDemo7;

public class NameOutOfRangeException extends RuntimeException{
    public NameOutOfRangeException() {
    }

    public NameOutOfRangeException(String message) {
        super(message);
    }
}
