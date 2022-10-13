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

public class TelefonoServlet extends HttpServlet {

	private static final String TYPE_RESPONSE = "application/json";
	private static final Logger LOG = Logger.getLogger(TelefonoServlet.class);

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		LOG.debug("***Entro en Telefono servlet ****");
		ServicioConsulta respuestaConsulta = new ServicioConsulta();
		ServicioValidaciones respuestaValidaciones = new ServicioValidaciones();
		String urlFinal = "consultaInfoTelefono";		
		String metodo = "consultaTelefono";
		String rfcReq = "";
		String curpReq = "";
		String emailReq = "";
		
		try {

			HttpSession session = request.getSession(false);
			String rfcSesion = session.getAttribute("rfcSesion").toString();		
			
			rfcReq = request.getParameter("rfc");
			emailReq = request.getParameter("email");
			curpReq = request.getParameter("curp");
			response.setHeader("Content-Security-Policy", "self, unsafe-inline, unsafe-eval");
			response.setHeader("X-Content-Type-Options", "nosniff");
			response.setHeader("X-XSS-Protection", "1; mode=block");
			response.setHeader("Cache-control", "no-cache, no-store,max-age=0, must-revalidate");
			response.setHeader("X-Frame-Options", "SAMEORIGIN");
			response.setHeader("Strict-Transport-Security", "max-age=31536000, includeSubDomains");
			
			if (respuestaValidaciones.validaRfc(rfcReq) && respuestaValidaciones.validaCurp(curpReq)
					&& respuestaValidaciones.validaEmail(emailReq)) {
				LOG.debug("*** Variables validadas  ****");
				String jsonInputString = respuestaValidaciones.generateJsonPost(rfcReq, curpReq, emailReq, rfcSesion);
				JSONArray data = respuestaConsulta.consulta(jsonInputString, metodo, urlFinal);
				JSONObject json2 = new JSONObject();				

				LOG.debug("***Final de consulta WS VerificacionEmail ****");
				
				if (!data.isEmpty()) {
					  json2.put("dataTelefono", data);
					  response.setCharacterEncoding("UTF-8");
						response.getWriter().write(json2.toString());
						response.setContentType(TYPE_RESPONSE);
						
					LOG.debug("*** Termina llenado de respuesta telefono****");
				} else {
					LOG.debug("*** Sin informacion Telefono ****");
					response.setContentType(TYPE_RESPONSE);
					response.getWriter().write(json2.toString());
				}

			} else {
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				LOG.debug("*** Error Request  Telefono  ****");
				response.getWriter().write("Telefono,error");

			}

		} catch (Exception t) {
			LOG.debug("*** Error  al obtener Telefono  ****", t);
		}

	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}
}