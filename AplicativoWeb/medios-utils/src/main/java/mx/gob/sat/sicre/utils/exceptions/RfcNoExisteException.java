package mx.gob.sat.sicre.utils.exceptions;

public class RfcNoExisteException extends Exception {

    private static final long serialVersionUID = 8148737390324863474L;

    public RfcNoExisteException() {
    }

    public RfcNoExisteException(String message) {
        super(message);
    }

    public RfcNoExisteException(Throwable cause) {
        super(cause);
    }

    public RfcNoExisteException(String message, Throwable cause) {
        super(message, cause);
    }

}
