package mx.gob.sat.sir.servicesrest.model.json;

public class Request {

	private String idAplicativo;
	private int tipoBusqueda;
	private String parametroBusqueda;
	
	public String getIdAplicativo() {
		return idAplicativo;
	}
	public void setIdAplicativo(String idAplicativo) {
		this.idAplicativo = idAplicativo;
	}
	public int getTipoBusqueda() {
		return tipoBusqueda;
	}
	public void setTipoBusqueda(int tipoBusqueda) {
		this.tipoBusqueda = tipoBusqueda;
	}
	public String getParametroBusqueda() {
		return parametroBusqueda;
	}
	public void setParametroBusqueda(String parametroBusqueda) {
		this.parametroBusqueda = parametroBusqueda;
	}
	
	
}
