package mx.gob.sat.sicre.web.vista;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Properties;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ServicioConsulta {

	private String URLARMADO = "";
	private static final Logger LOG = Logger.getLogger(ServicioConsulta.class);

	public ServicioConsulta() {
		ServicioValidaciones servValidaciones = new ServicioValidaciones();
		Properties prop;
		try {
			prop = servValidaciones.getPropertiesInfo();
			URLARMADO = "https://" + prop.getProperty("ipServicioMedios") + "/MediosServicesRest/operaciones/rest/";
		} catch (IOException e) {
			LOG.info("Ocurrio un error al leer el archivo de propiedades", e);
		}

	}

	protected JSONArray consulta(String jsonInputString, String metodo, String consul)
			throws IOException, NoSuchAlgorithmException, KeyStoreException, CertificateException,
			UnrecoverableKeyException, KeyManagementException {
		OutputStream os = null;
		String output = "";

		KeyStore clientStore = KeyStore.getInstance("PKCS12");
		InputStream ksIs = new FileInputStream(new File("/var/opt/Soa/Imp_internos/Dev_compen/Dev_com_manuales/Mic90376/certificadosMedios/certificadoMedios.pfx"));

		try {
			clientStore.load(ksIs, "mediosContacto".toCharArray());
		} finally {
			ksIs.close();
		}

		KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
		kmf.init(clientStore, "mediosContacto".toCharArray());

		KeyManager[] kms = kmf.getKeyManagers();

		KeyStore trustStore = KeyStore.getInstance("JKS");
		InputStream tsls = new FileInputStream(new File("/var/opt/Soa/Imp_internos/Dev_compen/Dev_com_manuales/Mic90376/certificadosMedios/keystore"));

		try {
			trustStore.load(tsls, "changeit".toCharArray());
		} finally {
			tsls.close();
		}

		TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
		tmf.init(trustStore);
		TrustManager[] tms = tmf.getTrustManagers();

		final SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
		sslContext.init(kms, tms, new SecureRandom());
		SSLContext.setDefault(sslContext);

		HostnameVerifier hostnameVerifier = NoopHostnameVerifier.INSTANCE;

		HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
		HttpsURLConnection.setDefaultHostnameVerifier(hostnameVerifier);

		try {
			URL url = new URL(URLARMADO + consul);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json; utf-8");
			conn.setRequestProperty("Accept", "application/json");
			conn.setSSLSocketFactory(sslContext.getSocketFactory());
			try {
				os = conn.getOutputStream();
				byte[] input = jsonInputString.getBytes("utf-8");
				os.write(input, 0, input.length);
			} finally {
				if (os != null) {
					os.close();
				}
			}

			BufferedReader br = new BufferedReader(
					new InputStreamReader((conn.getInputStream()), StandardCharsets.UTF_8));

			try {
				output = br.readLine();
			} finally {
				br.close();
				conn.disconnect();
			}

			JSONParser parser = new JSONParser();
			JSONObject jsonResult = (JSONObject) parser.parse(output);
			return (JSONArray) jsonResult.get(metodo);

		} catch (Exception ex) {
			LOG.info("Ocurrio un error al consultar el servicio rest", ex);
		}
		return null;
	}

}
