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

public class AutenticacionServlet extends HttpServlet {

	private final static String TYPE_RESPONSE = "application/json";
	private final static String CONSULTAAUTENTICACION = "consultaAutenticacion";
	private static final Logger LOG = Logger.getLogger(AutenticacionServlet.class);

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		ServicioValidaciones respuestaValidaciones = new ServicioValidaciones();
		ServicioConsulta respuestaConsulta = new ServicioConsulta();
		String rfcReq = "";
		String emailReq = "";
		String curpReq = "";
		LOG.debug("***Entro en Autenticacion servlet ****");

		try {
			HttpSession session = request.getSession(false);
			String rfcSesion = session.getAttribute("rfcSesion").toString();
			rfcReq = request.getParameter("rfc");
			curpReq = request.getParameter("curp");
			emailReq = request.getParameter("email");

			if (respuestaValidaciones.validaRfc(rfcReq) && respuestaValidaciones.validaCurp(curpReq)
					&& respuestaValidaciones.validaEmail(emailReq)) {
				String jsonInputString = respuestaValidaciones.generateJsonPost(rfcReq, curpReq, emailReq, rfcSesion);
				LOG.debug("*** Variables Validadas  ****");
				JSONArray data = respuestaConsulta.consulta(jsonInputString, CONSULTAAUTENTICACION, CONSULTAAUTENTICACION);
				JSONObject json2 = new JSONObject();				
				response.setHeader("Content-Security-Policy", "SAMEORIGIN");
				response.setHeader("X-Content-Type-Options", "nosniff");
				response.setHeader("X-XSS-Protection", "1; mode=block");
				response.setHeader("Cache-control", "no-cache, no-store,max-age=0, must-revalidate");
				response.setHeader("X-Frame-Options", "SAMEORIGIN");
				response.setHeader("Strict-Transport-Security", "max-age=31536000, includeSubDomains");

				if (!data.isEmpty()) {
					LOG.debug("***");
					response.setCharacterEncoding("UTF-8");
					json2.put("dataAutenticacion", data);
					response.setContentType(TYPE_RESPONSE);
					response.getWriter().write(json2.toString());					 

				} else {
					response.setContentType(TYPE_RESPONSE);
					response.getWriter().write(json2.toString());
					LOG.debug("*** Sin informacion Autenticacion  ****");
				}

			} else {
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				response.getWriter().write("autenticacion,error");
				LOG.debug("*** Error Request Autenticacion  ****");
			}

		} catch (Exception ex) {
			LOG.debug("*** Ocurrio Error  al obtener Autenticacion  ****", ex);
		}

	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}
}
