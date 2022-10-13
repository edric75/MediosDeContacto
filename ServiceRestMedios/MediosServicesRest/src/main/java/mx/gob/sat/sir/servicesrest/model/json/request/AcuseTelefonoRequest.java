package mx.gob.sat.sir.servicesrest.model.json.request;
import lombok.Data;

@Data
public class AcuseTelefonoRequest {
	private String rfc;
	private String curp;
	private String email;
	private String idAplicativo;	
}
