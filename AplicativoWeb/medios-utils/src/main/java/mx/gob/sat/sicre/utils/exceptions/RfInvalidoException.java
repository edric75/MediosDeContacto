package mx.gob.sat.sicre.utils.exceptions;

public class RfInvalidoException extends Exception {

    private static final long serialVersionUID = 8148737390324863474L;

    public RfInvalidoException() {
    }

    public RfInvalidoException(String message) {
        super(message);
    }

    public RfInvalidoException(Throwable cause) {
        super(cause);
    }

    public RfInvalidoException(String message, Throwable cause) {
        super(message, cause);
    }

}
