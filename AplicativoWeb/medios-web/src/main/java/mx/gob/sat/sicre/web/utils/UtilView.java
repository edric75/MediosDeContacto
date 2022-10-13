package mx.gob.sat.sicre.web.utils;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class UtilView {

	private static final String MENSAJE_ERROR = "Lo sentimos intentelo mas tarde";
	private static final String ERROR_REDIRECT = "Error en redirect ";
	private static final String GROWL_ID = "message";
	private static final String URL_LOGIN = "dev-login.xhtml";
	private static final Logger LOG = Logger.getLogger(UtilView.class);

	protected UtilView() {
	}

	public static void mostrarMensaje(FacesMessage.Severity severidad, String mensaje) {
		mostrarMensaje(severidad, mensaje, "");
	}

	public static void mostrarMensaje(FacesMessage.Severity severidad, String mensaje, String detalle) {
		FacesContext.getCurrentInstance().addMessage(GROWL_ID, new FacesMessage(severidad, mensaje, detalle));
	}

	public static void mostrarMensajeErrorGeneral() {
		mostrarMensaje(FacesMessage.SEVERITY_ERROR, MENSAJE_ERROR);
	}

	public static void redirectToView(String view) {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
		try {
			response.sendRedirect(view);
		} catch (IOException e1) {
			LOG.error(ERROR_REDIRECT, e1);
		}
	}

	public static void redirectToView(String view, String message) {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		try {
			LOG.debug("Entrando al redirecionamiento");
			session.setAttribute("error", message);
			response.sendRedirect(view);
		} catch (IOException e1) {
			LOG.error(ERROR_REDIRECT, e1);
		}
	}

	public static void redirectToLogin() {
		redirectToView(URL_LOGIN);
	}

}
