package mx.gob.sat.sicre.utils.exceptions;

public class ListEmptyException extends RuntimeException {

    private static final long serialVersionUID = 8148737390324863474L;

    public ListEmptyException() {
    }

    public ListEmptyException(String message) {
        super(message);
    }

    public ListEmptyException(Throwable cause) {
        super(cause);
    }

    public ListEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

}
