package mx.gob.sat.sicre.web.exception;

public class BussinesException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public BussinesException(String message) {
        super(message);
    }

    public BussinesException(Throwable cause) {
        super(cause);
    }

    public BussinesException(String message, Throwable cause) {
        super(message, cause);
    }
}
