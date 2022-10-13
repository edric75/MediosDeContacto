package mx.gob.sat.sicre.utils.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

public final class RegexValidator {

    private static final Logger LOG = Logger.getLogger(RegexValidator.class);

    private RegexValidator() {
    }

    private static String buscarCadenaRegex(String regex, String cadena) {
        LOG.debug("validando Cadena");

        String s = "";

        if (cadena != null) {

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(cadena);

            while (matcher.find()) {
                s = matcher.group();
            }
        }

        return s;
    }

    public static String buscarMac(String cadena) {
        return buscarCadenaRegex("([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})",
                cadena);
    }

    public static String buscarIp(String ip) {
        return buscarIpRegex("\\b(?:\\d{1,3}\\.){3}\\d{1,3}\\b", ip);

    }

    private static String buscarIpRegex(String ipAddressRegex, String ip) {

        String salida = "";

        if (ip != null) {
            
            Pattern pattern = Pattern.compile(ipAddressRegex);
            Matcher matcher = pattern.matcher(ip);


            do {

                if (matcher.find()) {

                    salida = matcher.group();

                } else {
                    salida = "0.0.0.0";
                }

            } while (salida.equals("127.0.0.1"));

        }

        return salida;

    }

}
