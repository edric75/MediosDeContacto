package mx.gob.sat.sicre.web.exception;

public class AccessDeniedException extends Exception {

    private static final long serialVersionUID = -7418820201107417024L;

    public AccessDeniedException(String message) {
        super(message);
    }

    public AccessDeniedException(Throwable cause) {
        super(cause);
    }

    public AccessDeniedException(String message, Throwable cause) {
        super(message, cause);
    }
}
