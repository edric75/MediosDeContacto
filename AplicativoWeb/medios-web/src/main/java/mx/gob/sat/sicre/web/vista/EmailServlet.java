package mx.gob.sat.sicre.web.vista;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class EmailServlet extends HttpServlet {

	private static final String TYPE_RESPONSE = "application/json";
	private static final String EMAIL = "email";
	private static final String CONSULTAINFOEMAIL = "consultaInfoEmail";
	private static final Logger LOG = Logger.getLogger(EmailServlet.class);


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		LOG.debug("***Entro en EmailAcuse servlet ****");
		ServicioConsulta respuestaConsulta = new ServicioConsulta();
		ServicioValidaciones respuestaValidaciones = new ServicioValidaciones();
		String rfcReq = "";
		String curpReq = "";
		String emailReq = "";
		String metodo = CONSULTAINFOEMAIL;
		String urlFinal = CONSULTAINFOEMAIL;

		try {

			rfcReq = request.getParameter("rfc");
			curpReq = request.getParameter("curp");
			emailReq = request.getParameter(EMAIL);
			HttpSession session = request.getSession(false);
			String rfcSesion = session.getAttribute("rfcSesion").toString();

			if (respuestaValidaciones.validaRfc(rfcReq) && respuestaValidaciones.validaCurp(curpReq)
					&& respuestaValidaciones.validaEmail(emailReq)) {
				LOG.debug("*** Variables validadas  ****");
				String jsonInputString = respuestaValidaciones.generateJsonPost(rfcReq, curpReq, emailReq, rfcSesion);
				JSONArray data = respuestaConsulta.consulta(jsonInputString, metodo, urlFinal);
				JSONObject json2 = new JSONObject();
				response.setHeader("Content-Security-Policy", "self, unsafe-inline, unsafe-eval");
				response.setHeader("X-Content-Type-Options", "nosniff");
				response.setHeader("X-XSS-Protection", "1; mode=block");
				response.setHeader("Cache-control", "no-cache, no-store,max-age=0, must-revalidate");
				response.setHeader("X-Frame-Options", "SAMEORIGIN");
				response.setHeader("Strict-Transport-Security", "max-age=31536000, includeSubDomains");
				if (!data.isEmpty()) {
					json2.put("dataEmail", data);				
					response.setCharacterEncoding("UTF-8");
					response.getWriter().write(json2.toString());
					response.setContentType(TYPE_RESPONSE);
					LOG.debug("*** Termina llenado de respuesta ****");
				} else {
					response.setContentType(TYPE_RESPONSE);
					response.getWriter().write(json2.toString());
					LOG.debug("*** Sin informacion Email  ****");

				}
			} else {
				response.getWriter().write("EmailError,error");
				LOG.debug("*** Error Request  Email ****");
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			}

		} catch (Exception e) {
			LOG.debug("*** Error  al obtener Email  ****", e);
		}

	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}
}
