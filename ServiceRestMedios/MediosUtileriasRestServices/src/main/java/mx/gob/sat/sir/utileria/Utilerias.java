package mx.gob.sat.sir.utileria;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.security.cert.X509Certificate;

import org.apache.log4j.Logger;

import mx.gob.sat.sir.utileria.clienteSise.WSSise;
import mx.gob.sat.sir.utileria.clienteSise.WSSiseSoap;
import mx.gob.sat.sir.utileria.model.ContribuyenteModel;

public class Utilerias {
	private final static Logger logger = Logger.getLogger(Utilerias.class);

	public String getDateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		return sdf.format(date);

	}

	public static BigDecimal formatDecimal(Double valorInicial) {
		String valorDouble = Double.toString(valorInicial);
		String[] valorPartido = valorDouble.split("\\.");
		if (valorPartido[1].equals("0")) {
			return new BigDecimal(valorPartido[0] + ".00");
		} else {
			return new BigDecimal(valorPartido[0] + "." + valorPartido[1]);
		}
	}

	public int validacionSise(String rfc, String rfcLogin) throws IOException {
		int respuestaSise = 1;
		Utilerias utils = new Utilerias();
		Properties prop = utils.getPropertiesInfo();

		WSSise siseProxy = new WSSise();
		WSSiseSoap sise = siseProxy.getWSSiseSoap();

		try {
			disableSslVerification();
			logger.info("********PETICION SISE*******");
			respuestaSise = sise.fnVerInformacion("<![CDATA[<CONSULTA>" + "<INFORMACION>" + "<D_RFC>" + rfc + "</D_RFC>"
					+ "<C_SISTEMA>" + prop.getProperty("sistema") + "</C_SISTEMA>" + "<C_MODULO>"
					+ prop.getProperty("modulo") + "</C_MODULO>" + "</INFORMACION>" + "<CREDENCIAL>" + "<D_LOGIN>"
					+ rfcLogin + "</D_LOGIN>" + "<D_DIRECCIONIP>0.0.0.0</D_DIRECCIONIP>" + "<D_MAC></D_MAC>"
					+ "</CREDENCIAL>" + "</CONSULTA>]]>");

		} catch (Exception ex) {
			logger.debug("::: Ocurrio un error al consumir SISE", ex);
		}
		logger.info("********* RESPUESTA SISE***********");
		logger.info(respuestaSise);

		return respuestaSise;
	}

	public Properties getPropertiesInfo() throws IOException {
		Properties prop = new Properties();
		InputStream input = null;

		try {
			input = Utilerias.class.getClassLoader().getResourceAsStream("config.properties");

			if (input == null) {
				logger.info("No se encuentra el archivo de propiedades");
			} else {
				prop.load(input);
			}

			prop.load(input);

		} catch (IOException ex) {
			logger.info("********** No se pudo leer el archivo de propiedades **************");
		} finally {
			if (input != null) {
				input.close();
			}
		}
		return prop;
	}

	private static void disableSslVerification() {
		try {

			TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					java.security.cert.X509Certificate[] certFactory = new java.security.cert.X509Certificate[0];
					return certFactory;
				}

				public void checkClientTrusted(java.security.cert.X509Certificate[] arg0, String arg1)
						throws CertificateException {
					try {
						arg0[0].checkValidity();
					} catch (Exception e) {
						throw new CertificateException("Certificate not valid or trusted.");
					}
				}

				public void checkServerTrusted(java.security.cert.X509Certificate[] arg0, String arg1)
						throws CertificateException {
					try {
						arg0[0].checkValidity();
					} catch (Exception e) {
						throw new CertificateException("Certificate not valid or trusted.");
					}

				}
			} };

			// Install the all-trusting trust manager
			SSLContext sc = SSLContext.getInstance("TLSv1.2");
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

			// Create all-trusting host name verifier
			HostnameVerifier allHostsValid = (String hostname, SSLSession session) -> {
				return hostname != null ? true : false;
			};

			// Install the all-trusting host verifier
			HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
		} catch (NoSuchAlgorithmException e) {
			logger.info("************* ERROR NoSuchAlgorithmException****************", e);
		} catch (KeyManagementException e) {
			logger.info("************* ERROR KeyManagementException****************", e);
		}
	}
	
	public static String enmascaraEmail(String emailAddress){
		String emailMask ="";
        try
        {
            if (!(emailAddress).equals(""))
            {
                String[] _splitEmail = emailAddress.split("@");
                String user = _splitEmail[0];
                String domain = _splitEmail[1];

                if (user.length() >= 3 )
                {
                	char letraUno = user.charAt(0);
                	char letraDos = user.charAt(1);
                	char letraTres = user.charAt(2);
                    String s = new StringBuilder().append(letraUno).append(letraDos).append(letraTres).toString();
                    emailMask = s + "*****" + "@" + domain;
                }
                else
                {
                	char letraUno = user.charAt(0);
                	char letraDos = user.charAt(1);
                    String s = new StringBuilder().append(letraUno).append(letraDos).toString();
                    emailMask = s + "*****" + "@" + domain;
                }
            }
        }catch (Exception ex) { 
        	logger.info("ERROR",ex);
        }
        return emailMask;
	}
}
