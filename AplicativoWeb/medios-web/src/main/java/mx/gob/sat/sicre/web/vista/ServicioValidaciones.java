package mx.gob.sat.sicre.web.vista;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import org.apache.log4j.Logger;

public class ServicioValidaciones {
	 
	private static final Logger LOG = Logger.getLogger(ServicioValidaciones.class);

    public String generateJsonPost(String rfc, String curp, String correo, String rfcSesion) {
       

        int tipoBusqueda = 0;
        String parametroBusqueda = "";

        if (!rfc.equals("")) {
            tipoBusqueda = 1;
            parametroBusqueda = rfc;
        } else if (!curp.equals("")) {
            tipoBusqueda = 2;
            parametroBusqueda = curp;
        } else if (!correo.equals("")) {
            tipoBusqueda = 3;
            parametroBusqueda = correo;
        }
        
        String mac = "00:00:00:00:00:00";
        return  "{\"idAplicativo\": \"" + "2007IMC" + "\", " + "\"tipoBusqueda\":\"" + tipoBusqueda + "\", "
                + "\"parametroBusqueda\":\"" + parametroBusqueda + "\" ," + "\"rfcLogin\":\"" + rfcSesion + "\", "
                + "\"ipCliente\":\"" + "0.0.0.0" + "\","  + "\"macAdress\":\"" + mac + "\" }";

    }
  
    public String valGuiones(String param, boolean tipoDato) {
        if (param == null || "".equals((String) param) || " ".equals(param)) {
            param = "-";
        } else if (tipoDato) {
            String[] fechaDWH = param.split(" ");
            String[] fechaDWHS = fechaDWH[0].split("-");
            param = fechaDWHS[2] + "-" + fechaDWHS[1] + "-" + fechaDWHS[0];
        }
        return param;
    }

    public String valFechaHoras(String param, boolean tipoDato) {
        if (param == null || "".equals((String) param) || " ".equals(param)) {
            param = "-";
        } else if (tipoDato) {
            String[] fechaDWH = param.split(" ");
            String[] hora = fechaDWH[1].split(":");
            String[] horaS = hora[1].split("");
            String[] fechaDWHS = fechaDWH[0].split("-");
            param = fechaDWHS[2] + "-" + fechaDWHS[1] + "-" + fechaDWHS[0] + " " + hora[0] + ":" + hora[1] + ":" + horaS[0] + "" + horaS[1];
        }
        return param;
    }
    
    public String valAlerta(String rfc, String curp,String email) {
        String validacion = "";
        if(rfc.length() > 0){
            validacion="rfc";
        }else if(curp.length() > 0){
            validacion = "curp";
        }else if(email.length() > 0){
            validacion = "email";
        }
        return validacion;
    }
    
    	public boolean validaRfc(String rfc){
    			
	    String rfc_pattern_m = "^(([A-ZÑ&]{3})([0-9]{2})([0][13578]|[1][02])(([0][1-9]|[12][\\d])|[3][01])([A-Z0-9]{3}))|"
				+ "(([A-ZÑ&]{3})([0-9]{2})([0][13456789]|[1][012])(([0][1-9]|[12][\\d])|[3][0])([A-Z0-9]{3}))|"
				+ "(([A-ZÑ&]{3})([02468][048]|[13579][26])[0][2]([0][1-9]|[12][\\d])([A-Z0-9]{3}))|"
				+ "(([A-ZÑ&]{3})([0-9]{2})[0][2]([0][1-9]|[1][0-9]|[2][0-8])([A-Z0-9]{3}))$";
	    
	    String rfc_pattern_f = "^(([A-ZÑ&]{4})([0-9]{2})([0][13578]|[1][02])(([0][1-9]|[12][\\d])|[3][01])([A-Z0-9]{3}))|"
				+ "(([A-ZÑ&]{4})([0-9]{2})([0][13456789]|[1][012])(([0][1-9]|[12][\\d])|[3][0])([A-Z0-9]{3}))|"
				+ "(([A-ZÑ&]{4})([02468][048]|[13579][26])[0][2]([0][1-9]|[12][\\d])([A-Z0-9]{3}))|"
				+ "(([A-ZÑ&]{4})([0-9]{2})[0][2]([0][1-9]|[1][0-9]|[2][0-8])([A-Z0-9]{3}))$";
	    
    	String rfcParam = "";
    	if(rfc != null){
    		rfcParam = rfc;
    	}
	    
	    Pattern p = Pattern.compile(rfc_pattern_m);
	    Pattern p2 = Pattern.compile(rfc_pattern_f);
	    Matcher m = p.matcher(rfcParam.trim());  
	    Matcher m2 = p2.matcher(rfcParam.trim());
	    
	    if(m.matches() || m2.matches() || rfcParam.equals("")){
	    	return true;
	    }else{
	    	return false;
	    }
	    	    
	}
	
	public boolean validaCurp(String curp){
	    String curp_pattern = "^[A-Z][A,E,I,O,U,X][A-Z]{2}[0-9]{2}[0-1][0-9][0-3][0-9][M,H][A-Z]{2}[B,C,D,F,G,H,J,K,L,M,N,Ñ,P,Q,R,S,T,V,W,X,Y,Z]{3}[0-9,A-Z][0-9]$";
	    String curpParam = "";
	    
	    if(curp != null){
	    	curpParam = curp;
    	}
	    
	    Pattern p = Pattern.compile(curp_pattern);
	    Matcher m = p.matcher(curpParam);  
	    
	    if(m.matches() || curpParam.equals("")){
	    	return true;
	    }else{
	    	return false;
	    }

	}
	
	public boolean validaEmail(String email){
		    String email_pattern = "^[A-Za-z0-9+_.-]+@(.+)$";
		    String emailParam = "";
		    
		    if(email != null){
		    	emailParam = email;
		    }
		    Pattern p = Pattern.compile(email_pattern);
		    Matcher m = p.matcher(emailParam);  
		    
		    if(m.matches() || emailParam.equals("")){
		    	return true;
		    }else{
		    	return false;
		    }
	}
	
	public Properties getPropertiesInfo() throws IOException{
		Properties prop = new Properties();
		InputStream input = null;
		
		try{
    		  input = ServicioConsulta.class.getClassLoader().getResourceAsStream("config.properties");
                if (input == null) {
                	LOG.info("No se encuentra el archivo de propiedades");
                }else{
                    prop.load(input);                   	
                }

    		} catch (IOException ex) {
    			LOG.info("********** No se pudo leer el archivo de propiedades **************");
            }finally{
            	if(input != null){
                	input.close();
            	}
            }
		return prop;
	}
	
	public boolean validaSeccion(String seccion){
		String letter_pattern = "[a-zA-Z]+";
		String paramSeccion = "";
		
		if(seccion!=null){
			paramSeccion = seccion;
		}
	    Pattern p = Pattern.compile(letter_pattern);
	    Matcher m = p.matcher(paramSeccion);  
	    
	    if(m.matches() || paramSeccion.equals("")){
	    	return true;
	    }else{
	    	return false;
	    }	
	}
	
}
