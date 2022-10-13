package mx.gob.sat.sicre.utils.validators;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import mx.gob.sat.sicre.utils.constantes.Numeros;
import mx.gob.sat.sicre.utils.exceptions.ListEmptyException;
import mx.gob.sat.sicre.utils.exceptions.ObjectNullException;
import mx.gob.sat.sicre.utils.exceptions.StringNullException;

/**
 * 
 * @author IOFRACTAL1
 * 
 */
public class Operaciones {

    Operaciones() {

    }

    /**
     * Logger para esta clase
     */
    private static final Logger LOG = Logger.getLogger(Operaciones.class);

    public void version(String version) {
        LOG.debug(version);
    }

    public static boolean isListNotEmpty(List<?> lista) {
        if (lista != null) {
            return lista.size() > 0;
        } else {
            return false;
        }
    }

    public static boolean isListNotEmptyThrowException(List<?> lista) {
        if (lista != null) {
            return lista.size() > 0;
        } else {
            throw new ListEmptyException();
        }
    }

    public static boolean isObjectNotNull(Object object) {
        return object != null;
    }

    public static void isObjectNullThrowException(Object object) {
        if (!isObjectNotNull(object)) {
            throw new ObjectNullException();
        }
    }

    public static boolean isStringNotNullTrowException(String cadena) {
        if (cadena != null) {
            return (!cadena.equals(""));
        } else {
            throw new StringNullException();
        }
    }

    public static boolean isStringNotNull(String cadena) {
        if (cadena != null) {
            return (!cadena.equals(""));
        }
        return false;
    }

    public static boolean isRfc(String cadena) {
        return cadena.length() == Numeros.TRECE;
    }

    public static boolean isRFCValidoFisica(String rfc) {
        if (rfc != null && rfc.trim().length() == Numeros.TRECE) {
            return Pattern.matches(
                    "^[A-Z_\u00D1\u0026]{3,4}[0-9]{2}([0][1-9]|[1][0-2])([0-2][0-9]|[3][0-1])[A-Z_0-9]{3}$", rfc);
        }
        return false;
    }

    public static String escapeAmpersand(String rfc) {
        return rfc.replace("&", "&amp;");
    }

    public static String getIpSession() {
        String ipNueva = Numeros.IP;
        LOG.info("LA ip nueva es " + ipNueva);
        return ipNueva;
    }

    public static String dateToString(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy");
        String reportDate = simpleDateFormat.format(date);
        LOG.info("La fecha en String es::: " + reportDate);
        return reportDate;
    }

    public static boolean isFolioSubdeclarado(String texto) {
        return texto.length() == Numeros.ONCE;
    }

    public static Date addDay(Date date, int day) {

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);
        calendar.add(Calendar.DATE, day);

        return calendar.getTime();
    }

    public static String getReportDate(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                "'Revisión practicada el día' dd 'de' MMMMM 'de' yyyy', a las 'HH':'mm 'horas'",
                new Locale("es", "MX"));
        LOG.debug(" Pinche Fecha es " + simpleDateFormat.format(date));
        return simpleDateFormat.format(date);
    }

    public static String getFormatoDate(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", new Locale("es", "MX"));
        return simpleDateFormat.format(date);
    }

    public static Object[] agregarParametroString(Object[] params, String parametro) {

        Object[] respuesta = new Object[params.length + 1];

        for (int i = 0; i < params.length; i++) {

            respuesta[i] = params[i];

        }

        respuesta[(params.length)] = parametro;

        return respuesta;

    }

    public static Object[] agregarParametroInt(Object[] params, int parametro) {

        Object[] respuesta = new Object[params.length + 1];

        for (int i = 0; i < params.length; i++) {

            respuesta[i] = params[i];

        }

        respuesta[(params.length)] = parametro;

        return respuesta;

    }
}
