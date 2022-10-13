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

public class AcuseTelefonoServlet extends HttpServlet {

	private static final String TYPE_RESPONSE = "application/json";
	private static final Logger LOG = Logger.getLogger(AcuseTelefonoServlet.class);

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response){

		LOG.debug("***Entro en acuse telefono servlet ****");
		ServicioConsulta respuestaConsulta;
		respuestaConsulta = new ServicioConsulta();
	
		ServicioValidaciones respuestaValidaciones = new ServicioValidaciones();
		String rfcReq = "";
		String curpReq = "";
		String emailReq = "";
		String urlFinal = "consultaAcuseTelefono";
		String metodo = "consultaTelefonoAcuse";
		try {
			HttpSession session = request.getSession(false);
			String rfcSesion = session.getAttribute("rfcSesion").toString();
			rfcReq = request.getParameter("rfc");
			emailReq = request.getParameter("email");
			curpReq = request.getParameter("curp");

			if (respuestaValidaciones.validaRfc(rfcReq) && respuestaValidaciones.validaCurp(curpReq)
					&& respuestaValidaciones.validaEmail(emailReq)) {
				LOG.debug("*** Variables validadas  ****");
				String jsonInputString = respuestaValidaciones.generateJsonPost(rfcReq, curpReq, emailReq, rfcSesion);
				JSONObject json2 = new JSONObject();				
				JSONArray data = respuestaConsulta.consulta(jsonInputString, metodo, urlFinal);
			    response.setHeader("Content-Security-Policy", "self, unsafe-inline, unsafe-eval");
				response.setHeader("X-XSS-Protection", "1; mode=block");
				response.setHeader("X-Content-Type-Options", "nosniff");
				response.setHeader("Strict-Transport-Security", "max-age=31536000, includeSubDomains");						
				response.setHeader("Cache-control", "no-cache, no-store,max-age=0, must-revalidate");		
				response.setHeader("X-Frame-Options", "SAMEORIGIN");
				LOG.debug("*******");
				if (!data.isEmpty()) {
					 json2.put("dataAcuseTelefono", data);
      				response.setContentType(TYPE_RESPONSE);
					response.getWriter().write(json2.toString());
				} else {
					response.setContentType(TYPE_RESPONSE);
					response.getWriter().write(json2.toString());
					LOG.debug("*** No hay informacion Acuse Telefono  ****");
				}

			} else {
				LOG.debug("*** Error Request  Acuse Telefono  ****");
				response.getWriter().write("acuceTelefono,error");
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

			}

		} catch (Exception ex) {
			LOG.debug("*** Error  al obtener Acuse Telefono  ****", ex);
		}

	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}
}