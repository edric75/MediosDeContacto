package mx.gob.sat.sicre.web.vista;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.apache.log4j.Logger;

public class RegimenServlet extends HttpServlet {

	private static final String TYPE_RESPONSE = "application/json";
	private static final Logger LOG = Logger.getLogger(ServicioValidaciones.class);

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {

		LOG.debug("***Entro en Regimen servlet ****");
		ServicioConsulta respuestaConsulta = new ServicioConsulta();
		ServicioValidaciones respuestaValidaciones = new ServicioValidaciones();
		String rfcReq = "";
		String curpReq = "";
		String emailReq = "";

		try {
			HttpSession session = request.getSession(false);
			String rfcSesion = session.getAttribute("rfcSesion").toString();
			rfcReq = request.getParameter("rfc");
			curpReq = request.getParameter("curp");
			emailReq = request.getParameter("email");

			if (respuestaValidaciones.validaRfc(rfcReq) && respuestaValidaciones.validaCurp(curpReq)
					&& respuestaValidaciones.validaEmail(emailReq)) {
				LOG.debug("*** Variables validadas  ****");
				String jsonInputString = respuestaValidaciones.generateJsonPost(rfcReq, curpReq, emailReq, rfcSesion);
				JSONArray pets = respuestaConsulta.consulta(jsonInputString, "consultaRegimen", "consultaRegimen");
				JSONObject json2 = new JSONObject();
			    json2.put("dataRegimen", pets);

				LOG.debug("***Final de consulta WS Regimen ****");
				response.setHeader("Content-Security-Policy", "self, unsafe-inline, unsafe-eval");
				response.setHeader("X-Content-Type-Options", "nosniff");
				response.setHeader("X-XSS-Protection", "1; mode=block");
				response.setHeader("Cache-control", "no-cache, no-store,max-age=0, must-revalidate");
				response.setHeader("X-Frame-Options", "SAMEORIGIN");
				response.setHeader("Strict-Transport-Security", "max-age=31536000, includeSubDomains");
				if (!pets.isEmpty()) {
					LOG.debug("*** Termina llenado de respuesta ****");
					response.setCharacterEncoding("UTF-8");
					response.setContentType(TYPE_RESPONSE);
					response.getWriter().write(json2.toString());
				} else {
					response.getWriter().write(json2.toString());
					LOG.debug("*** Sin informacion Regimen ****");
					response.setContentType(TYPE_RESPONSE);
				}

			} else {
				LOG.debug("*** Error Request  Regimen  ****");
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				response.getWriter().write("RegimenError,error");
			}

		} catch (Exception ex2) {
			LOG.debug("****************************************");
			LOG.debug("*** Error  al obtener Regimen  ****", ex2);
		}
	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}
}