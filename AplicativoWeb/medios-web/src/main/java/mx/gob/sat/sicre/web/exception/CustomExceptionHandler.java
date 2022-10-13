package mx.gob.sat.sicre.web.exception;

import java.io.IOException;
import java.util.Iterator;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class CustomExceptionHandler extends ExceptionHandlerWrapper {

    private static final Logger LOG = Logger
            .getLogger(CustomExceptionHandler.class);

    private static final String URL = "../system/errorReporte.xhtml";

    private ExceptionHandler wrapped;

    public CustomExceptionHandler(ExceptionHandler wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public ExceptionHandler getWrapped() {
        return wrapped;
    }

    @Override
    public void handle() {

        Iterator<ExceptionQueuedEvent> iterator = getUnhandledExceptionQueuedEvents()
                .iterator();

        while (iterator.hasNext()) {

            ExceptionQueuedEvent event = iterator.next();
            ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event
                    .getSource();
            Throwable throwable = context.getException();

            LOG.error("Entrando a exception handler ", throwable);

            try {

                redirectToView(URL, "Lo sentimos. En este momento no podemos atender su petición. Por favor, intentelo más tarde.");

            } catch (Exception e) {
                LOG.error("Manejador de excpeciones", e);

            } finally {
                iterator.remove();
            }
            getWrapped().handle();
        }
    }
    
    public static void redirectToView(String view, String message) {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) context
                .getExternalContext().getResponse();
        HttpSession session = (HttpSession) context.getExternalContext()
                .getSession(true);
        try {
            LOG.debug("Entrando al redirecionamiento");
            session.setAttribute("error", message);
            response.sendRedirect(view);
        } catch (IOException e1) {
            LOG.error("Error en redirect ", e1);
        }
    }
    
}
