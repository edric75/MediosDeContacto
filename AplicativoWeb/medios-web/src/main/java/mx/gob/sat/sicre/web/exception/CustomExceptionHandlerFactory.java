package mx.gob.sat.sicre.web.exception;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

public class CustomExceptionHandlerFactory extends ExceptionHandlerFactory {
    private ExceptionHandlerFactory parent;
    
    public CustomExceptionHandlerFactory(ExceptionHandlerFactory parent) {
      this.parent = parent;
    }
    
    @Override
    public ExceptionHandler getExceptionHandler() {
      return parent.getExceptionHandler();
    }
}
