package mx.gob.sat.sicre.utils.exceptions;

public class QlikRfcException extends RuntimeException {

    private static final long serialVersionUID = 8148737390324863474L;

    public QlikRfcException() {
    }

    public QlikRfcException(String message) {
        super(message);
    }

    public QlikRfcException(Throwable cause) {
        super(cause);
    }

    public QlikRfcException(String message, Throwable cause) {
        super(message, cause);
    }

}
