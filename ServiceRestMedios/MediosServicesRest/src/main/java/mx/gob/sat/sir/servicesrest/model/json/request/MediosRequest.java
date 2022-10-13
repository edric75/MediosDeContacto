package mx.gob.sat.sir.servicesrest.model.json.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class MediosRequest {
	@NotNull
	private String idAplicativo;
	@NotNull
	private String tipoBusqueda;
	@NotNull
	private String parametroBusqueda;
	@NotNull
	private String rfcLogin;
	@NotNull
	private String ipCliente;
	private String macAdress;
}
