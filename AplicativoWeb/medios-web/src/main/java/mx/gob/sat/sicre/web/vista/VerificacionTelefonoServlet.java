package mx.gob.sat.sicre.web.vista;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class VerificacionTelefonoServlet extends HttpServlet {

	private static final String TYPE_RESPONSE = "application/json";
	private static final Logger LOG = Logger.getLogger(TelefonoServlet.class);

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		LOG.debug("***Entro en Verificacion Telefono servlet ****");
		ServicioConsulta respuestaConsulta = new ServicioConsulta();
		ServicioValidaciones respuestaValidaciones = new ServicioValidaciones();
		String metodo = "consultaTelefonoVerificacion";
		String urlFinal = "consultaInfoVerificacionTelefono";
		String rfcReq = "";
		String curpReq = "";
		String emailReq = "";

		try {
			HttpSession session = request.getSession(false);
			rfcReq = request.getParameter("rfc");
			curpReq = request.getParameter("curp");
			emailReq = request.getParameter("email");
			String rfcSesion = session.getAttribute("rfcSesion").toString();
			
			if (respuestaValidaciones.validaRfc(rfcReq) && respuestaValidaciones.validaCurp(curpReq)
					&& respuestaValidaciones.validaEmail(emailReq)) {
				String jsonInputString = respuestaValidaciones.generateJsonPost(rfcReq, curpReq, emailReq, rfcSesion);
				JSONArray data = respuestaConsulta.consulta(jsonInputString, metodo, urlFinal);
				JSONObject json2 = new JSONObject();				
				response.setHeader("Content-Security-Policy", "self, unsafe-inline, unsafe-eval");
				response.setHeader("X-Content-Type-Options", "nosniff");
				response.setHeader("X-XSS-Protection", "1; mode=block");
				response.setHeader("Strict-Transport-Security", "max-age=31536000, includeSubDomains");
				response.setHeader("Cache-control", "no-cache, no-store,max-age=0, must-revalidate");
				response.setHeader("X-Frame-Options", "SAMEORIGIN");
				LOG.debug("***Final de consulta WS VerificacionTelefono ****");

				if (!data.isEmpty()) {
					response.setContentType(TYPE_RESPONSE);
					  json2.put("dataVerificacionTelefono", data);
						response.getWriter().write(json2.toString());
				} else {
					LOG.debug("*** Sin informacion VerificacionTelefono ****");
					response.setContentType(TYPE_RESPONSE);
					response.getWriter().write(json2.toString());
				}

			} else {
				LOG.debug("*** Error Request  Verificacion telefono   ****");
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				response.getWriter().write("verificacionTelefono,error");

			}
		} catch (Exception t) {
			LOG.debug("*** Error  al obtener Verificacion telefono  ****", t);
		}

	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}
}