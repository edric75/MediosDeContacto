package mx.gob.sat.sicre.utils.commons;

import java.util.Date;

import org.apache.log4j.Logger;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class UtilsDate {

    private static final Logger LOG = Logger.getLogger(UtilsDate.class);

    private UtilsDate() {
    }

    public static Date stringToDate(String fecha) {

        DateFormat format = new SimpleDateFormat("dd-mm-yyyy");
        Date date = null;

        try {
            date = format.parse(fecha);
        } catch (ParseException e) {
            LOG.error(e);
        }

        return date;
    }

}
