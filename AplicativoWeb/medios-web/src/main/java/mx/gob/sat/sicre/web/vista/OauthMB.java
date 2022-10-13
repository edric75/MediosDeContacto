package mx.gob.sat.sicre.web.vista;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;

@ManagedBean(name = "oauthMB", eager = true)
@ApplicationScoped
public class OauthMB implements Serializable {

	private static final long serialVersionUID = 1L;
	private final String userSession = "userSession";
	private static final Logger LOG = Logger.getLogger(OauthMB.class);
	private String endpointToken = "";
	private String authorization_endpoint = "";
	private String clientId = "";
	private String redirect_uri = "";
	private String clientSecret = "";
	private String rfcSesion = "";
	private final String paginaErrorAcceso = "errorAcceso.xhtml";

	public OauthMB() throws IOException {
		ServicioValidaciones servValidaciones = new ServicioValidaciones();
		Properties prop = servValidaciones.getPropertiesInfo();
		redirect_uri = prop.getProperty("redirect_uri");
		endpointToken = prop.getProperty("access_tokenEndpoint");
		authorization_endpoint = prop.getProperty("authorization_endpoint");
		clientId = prop.getProperty("client_id");
		clientSecret = prop.getProperty("client_secret");
	}

	public void validarSesion() throws IOException, NoSuchAlgorithmException, ParseException, JSONException {

		HttpServletRequest origRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		HttpSession session = origRequest.getSession();
		String code = origRequest.getParameter("code");


		if (session.getAttribute(userSession) != null) {
			LOG.info("Hay sesion");
			if (session.getAttribute("roles") == null) {
				LOG.info("*** Fiel sin Roles para acceder ***");
				FacesContext.getCurrentInstance().getExternalContext().redirect(paginaErrorAcceso);
			}
		} else if (session.getAttribute(userSession) == null && code == null) {
			LOG.info("*** No existe la session se genera URL AUTHZ 1.1***");

			String url = authorization_endpoint + "?response_type=code" + "&client_id=" + clientId + "&state=lB2y6gJupc"
					+ "&scope=mediosPerfil" + "&redirect_uri=" + redirect_uri;
			FacesContext.getCurrentInstance().getExternalContext().redirect(url);
		} else if (session.getAttribute(userSession) == null && code != null) {
			session.setAttribute(userSession, "0");
			String statusCode = code;
			String tokenInfo = getAccessToken2(statusCode);
			if (tokenInfo != null) {
				JSONParser parser = new JSONParser();
				org.json.simple.JSONObject json = (org.json.simple.JSONObject) parser.parse(tokenInfo);
				boolean rolAccess = validateRoles(json.get("access_token").toString());
				if (!rolAccess) {
					LOG.info(tokenInfo);
					LOG.info("*** Fiel sin Roles para acceder ***");
					FacesContext.getCurrentInstance().getExternalContext().redirect(paginaErrorAcceso);
				} else {
					LOG.info("*** Inicio de sesion exitoso ***");
					session.setAttribute(userSession, "1");
					session.setAttribute("roles", "1");
					session.setAttribute("rfcSesion", rfcSesion);
				}
			} else {
				LOG.info("*** Ocurrio un error al obtener el access token ***");
				FacesContext.getCurrentInstance().getExternalContext().redirect(paginaErrorAcceso);
			}
		}

	}

	
	public String getAccessToken2(String authCode) {
		String token = "";
		disableSslVerification();

		HttpURLConnection connection = null;

		String urlParameters = "resourceServer=medioscontacto";
		urlParameters += "&";
		urlParameters += "grant_type=authorization_code";
		urlParameters += "&";
		urlParameters += "client_id=" + clientId;
		urlParameters += "&";
		urlParameters += "code=" + authCode;
		urlParameters += "&";
		urlParameters += "redirect_uri=" + redirect_uri;
		urlParameters += "&";
		urlParameters += "client_secret=" + clientSecret;

		try {

			URL url = new URL(endpointToken);

			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

			connection.setRequestProperty("Content-Length", "" + Integer.toString(urlParameters.getBytes().length));
			connection.setRequestProperty("Content-Language", "en-US");
			connection.setUseCaches(false);
			connection.setDoInput(true);
			connection.setDoOutput(true);

			// Send request
			DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
			try{
				wr.writeBytes(urlParameters);
				wr.flush();
			}finally{
				wr.close();
			}

			// Get Response
			InputStream is = connection.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			String line;
			StringBuilder response = new StringBuilder();
			try {
				while ((line = rd.readLine()) != null) {
					response.append(line);
					response.append('\r');
				}
			} finally {
				rd.close();
			}
			LOG.info("*** Se obtuvo access token ***");
			token = response.toString();
		} catch (Exception e) {
			LOG.info("************* Error al obtener el token****************", e);
		}
		return token;

	}

	private static void disableSslVerification() {
		try {

			TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					java.security.cert.X509Certificate[] certFactory = new java.security.cert.X509Certificate[0];
					return certFactory;
				}

				@Override
				public void checkClientTrusted(java.security.cert.X509Certificate[] arg0, String arg1)
						throws CertificateException {
					try {
						arg0[0].checkValidity();
					} catch (Exception e) {
						throw new CertificateException("Certificate not valid or trusted.");
					}
				}

				@Override
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
			
			HostnameVerifier allHostsValid = (String hostname, SSLSession session) -> { return hostname != null ? true : false; };
						
			
			// Install the all-trusting host verifier
			HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
		} catch (NoSuchAlgorithmException e) {
			LOG.info("************* ERROR NoSuchAlgorithmException****************", e);
		} catch (KeyManagementException e) {
			LOG.info("************* ERROR KeyManagementException****************", e);
		}
	}

	public boolean validateRoles(String accessToken) throws JSONException {
		boolean result = false;
		try {
			String[] chunks = accessToken.split("\\.");
			String payload = new String(Base64.decodeBase64(chunks[1]));
			JSONArray jsonArr = new JSONArray("[" + payload + "]");
			JSONObject jsonObj = jsonArr.getJSONObject(0);
			JSONArray arrayReceipients = jsonObj.getJSONArray("Roles");
			setRfcSesion(jsonObj.getString("RFC_Largo"));

			List<String> list = new ArrayList<String>();
			for (int i = 0; i < arrayReceipients.length(); i++) {
				String[] dataRole = arrayReceipients.getString(i).replace("cn=", "").split(",");
				list.add(dataRole[0]);
			}

			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).equals("SAT_MEDCONT_CG_AC") || list.get(i).equals("SAT_MEDCONT_CG_EMP")
						|| list.get(i).equals("SAT_MEDCONT_CP_EMP") || list.get(i).equals("SAT_MEDCONT_BIT_AC")) {
					result = true;
				}

			}

		} catch (Exception ex) { 
			LOG.info("************* Error al leer el token****************", ex);
		}
		return result;
	}

	public String getRfcSesion() {
		return rfcSesion;
	}

	public void setRfcSesion(String rfcSesion) {
		this.rfcSesion = rfcSesion;
	}
}
