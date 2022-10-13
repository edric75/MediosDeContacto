package mx.gob.sat.sicre.utils.validators;

import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import mx.gob.sat.sicre.utils.exceptions.ListEmptyException;
import mx.gob.sat.sicre.utils.exceptions.RfInvalidoException;

public final class Validator {

    private Validator() {

    }

    public static void isRFCValido(String rfc) throws RfInvalidoException {
        if (!Pattern.matches("^[A-Z_\u00D1\u0026]{3,4}[0-9]{2}([0][1-9]|[1][0-2])([0-2][0-9]|[3][0-1])[A-Z_0-9]{3}$",
                rfc)) {
            throw new RfInvalidoException("RFC Freezer");
        }
    }

    public static boolean isObjectNull(Object object) {
        return object == null;
    }


    public static Date getDateValidation(Date date) {

        if (date != null) {
            return (Date) date.clone();
        }

        return null;
    }

    public static Date setDateValidation(Date date) {
        Date date2 = null;

        if (date != null) {
            date2 = new Date(date.getTime());
        }
        return date2;
    }

}
