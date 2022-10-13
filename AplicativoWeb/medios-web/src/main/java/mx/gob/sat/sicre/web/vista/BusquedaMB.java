package mx.gob.sat.sicre.web.vista;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean(name = "busquedaMB", eager = true)
@ApplicationScoped
public class BusquedaMB implements Serializable {

	private static final long serialVersionUID = 3953534394519223952L;

	private static final Logger LOG = Logger.getLogger(BusquedaMB.class);

	private static final String URLERROR = "/pages/medios/index.xhtml";
	private static final String CONSULTAINFO = "consultaInfoContribuyente";
	private String ip;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	private String rfc;
	private String curp;
	private String correo;
	private String errorServidor;
	private String busquedaEmail;


	public void setErrorServidor(String errorServidor) {
		this.errorServidor = errorServidor;
	}

	public String getErrorServidor() {
		return errorServidor;
	}

	private String idContribuyente;
	private String idTipoPersona;
	private String rfc2;
	private String curp2;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String nombre;
	private String estatus;
	private String fechaInicioOp;
	private String calle;
	private String numeroExterior;
	private String numeroInterior;
	private String colonia;
	private String asentamiento;
	private String referencia;
	private String entreLaCalle;
	private String codigoPostal;
	private String entidadFederativa;
	private String municipio;
	private String fechaRegistro;
	private String ylaCalle;
	private String fechaDWH;

	private String situaDom;
	private String locContriDom;
	private String detLocContrDom;

	private String nombreRazon;

	@PostConstruct
	public void verify(ComponentSystemEvent event) {

		LOG.debug("****Entro a verify ****");

	}

	public String pantallaLogin() {

		return URLERROR;
	}

	public String buscar() throws IOException, ParseException {

		if (rfc.equals("") && curp.equals("") && correo.equals("")) {
			LOG.debug("**** Los 3 campos vienen vacios ****");
			errorServidor = "todos";
			return URLERROR;
		}
		ServicioValidaciones respuestaValidaciones = new ServicioValidaciones();
		JSONParser parser = new JSONParser();
		ServicioConsulta respuestaConsulta = new ServicioConsulta();
		HttpServletRequest origRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		HttpSession session = origRequest.getSession(false);

		try {

		String rfcSesion = session.getAttribute("rfcSesion").toString();
			if (respuestaValidaciones.validaRfc(rfc) && respuestaValidaciones.validaCurp(curp)
					&& respuestaValidaciones.validaEmail(correo)) {
				String jsonInputString = respuestaValidaciones.generateJsonPost(rfc, curp, correo, rfcSesion);

				JSONArray pets = respuestaConsulta.consulta(jsonInputString, CONSULTAINFO, CONSULTAINFO);
				if (!pets.isEmpty()) {
					

					String finalO = pets.get(0).toString();
					JSONObject jsonResulst = (JSONObject) parser.parse(finalO);
					validateIDC(jsonResulst);
					idContribuyente = respuestaValidaciones.valGuiones((String) jsonResulst.get("idContribuyente"),
							false);
					idTipoPersona = respuestaValidaciones.valGuiones((String) jsonResulst.get("idTipoPersona"), false);
					rfc2 = respuestaValidaciones.valGuiones((String) jsonResulst.get("rfc"), false);
					curp2 = respuestaValidaciones.valGuiones((String) jsonResulst.get("curp"), false);
					if (rfc.trim().length() == 12) {
						nombre = respuestaValidaciones.valGuiones((String) jsonResulst.get("nombre"), false);
						apellidoPaterno = "";
						apellidoMaterno = "";
						nombreRazon = "Razón social";
					} else {
						nombre = respuestaValidaciones.valGuiones((String) jsonResulst.get("nombre"), false);
						apellidoPaterno = respuestaValidaciones.valGuiones((String) jsonResulst.get("apellidoPaterno"),
								false);
						apellidoMaterno = respuestaValidaciones.valGuiones((String) jsonResulst.get("apellidoMaterno"),
								false);
						nombreRazon = "Nombre";
					}
					estatus = respuestaValidaciones.valGuiones((String) jsonResulst.get("estatus"), false);
					calle = respuestaValidaciones.valGuiones((String) jsonResulst.get("calle"), false);
					numeroExterior = respuestaValidaciones.valGuiones((String) jsonResulst.get("numeroExterior"),
							false);
					numeroInterior = respuestaValidaciones.valGuiones((String) jsonResulst.get("numeroInterior"),
							false);
					colonia = respuestaValidaciones.valGuiones((String) jsonResulst.get("colonia"), false);
					asentamiento = respuestaValidaciones.valGuiones((String) jsonResulst.get("asentamiento"), false);
					referencia = respuestaValidaciones.valGuiones((String) jsonResulst.get("referencia"), false);
					entreLaCalle = respuestaValidaciones.valGuiones((String) jsonResulst.get("entreLaCalle"), false);
					codigoPostal = respuestaValidaciones.valGuiones((String) jsonResulst.get("codigoPostal"), false);
					entidadFederativa = respuestaValidaciones.valGuiones((String) jsonResulst.get("entidadFederativa"),
							false);
					municipio = respuestaValidaciones.valGuiones((String) jsonResulst.get("municipio"), false);
					ylaCalle = respuestaValidaciones.valGuiones((String) jsonResulst.get("ylaCalle"), false);
					situaDom = respuestaValidaciones.valGuiones((String) jsonResulst.get("situaDom"), false);
					locContriDom = respuestaValidaciones.valGuiones((String) jsonResulst.get("locContriDom"), false);
					detLocContrDom = respuestaValidaciones.valGuiones((String) jsonResulst.get("detLocContrDom"),
							false);

					fechaInicioOp = respuestaValidaciones.valGuiones((String) jsonResulst.get("fechaInicioOp"), true);
					fechaRegistro = respuestaValidaciones.valGuiones((String) jsonResulst.get("fechaRegistro"), true);
					fechaDWH = respuestaValidaciones.valGuiones((String) jsonResulst.get("fechaDWH"), true);
					return "/pages/medios/datos.xhtml";

				} else {
					LOG.debug("**** RFC,CURP o Correo no encontrado ****");
					validateParams(rfc, curp, correo);
					return URLERROR;
				}

			} else {
				LOG.debug("**** Bad request ****");
				HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance()
						.getExternalContext().getResponse();
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				FacesContext.getCurrentInstance().getExternalContext().redirect("errorReporte.xhtml");
			}
		} catch (Exception ex) {
			LOG.debug("****Error consulta****", ex);
			FacesContext.getCurrentInstance().getExternalContext().redirect("errorReporte.xhtml");
		}
		return "/pages/medios/datos.xhtml";
	}

	public String validateParams(String rfc, String curp, String correo) {

		if (!rfc.equals("")) {
			errorServidor = "rfc";
		} else if (!curp.equals("")) {
			errorServidor = "curp";

		} else if (!correo.equals("")) {
			errorServidor = "email";
		}

		return errorServidor;

	}

	public void validateIDC(JSONObject jsonResulst) throws IOException {
		if (jsonResulst.size() == 1) {
			if (!rfc.equals("")) {
				errorServidor = "IDCRFC";
			} else if (!curp.equals("")) {
				errorServidor = "IDCCURP";
			} else if (!correo.equals("")) {
				errorServidor = "IDCCOREO";
			}

			FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");

		}
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getIdContribuyente() {
		return idContribuyente;
	}

	public void setIdContribuyente(String idContribuyente) {
		this.idContribuyente = idContribuyente;
	}

	public String getIdTipoPersona() {
		return idTipoPersona;
	}

	public void setIdTipoPersona(String idTipoPersona) {
		this.idTipoPersona = idTipoPersona;
	}

	public String getRfc2() {
		return rfc2;
	}

	public void setRfc2(String rfc2) {
		this.rfc2 = rfc2;
	}

	public String getCurp2() {
		return curp2;
	}

	public void setCurp2(String curp2) {
		this.curp2 = curp2;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getFechaInicioOp() {
		return fechaInicioOp;
	}

	public void setFechaInicioOp(String fechaInicioOp) {
		this.fechaInicioOp = fechaInicioOp;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumeroExterior() {
		return numeroExterior;
	}

	public void setNumeroExterior(String numeroExterior) {
		this.numeroExterior = numeroExterior;
	}

	public String getNumeroInterior() {
		return numeroInterior;
	}

	public void setNumeroInterior(String numeroInterior) {
		this.numeroInterior = numeroInterior;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getAsentamiento() {
		return asentamiento;
	}

	public void setAsentamiento(String asentamiento) {
		this.asentamiento = asentamiento;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getEntreLaCalle() {
		return entreLaCalle;
	}

	public void setEntreLaCalle(String entreLaCalle) {
		this.entreLaCalle = entreLaCalle;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getEntidadFederativa() {
		return entidadFederativa;
	}

	public void setEntidadFederativa(String entidadFederativa) {
		this.entidadFederativa = entidadFederativa;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getYlaCalle() {
		return ylaCalle;
	}

	public void setYlaCalle(String ylaCalle) {
		this.ylaCalle = ylaCalle;
	}

	public String getFechaDWH() {
		return fechaDWH;
	}

	public void setFechaDWH(String fechaDWH) {
		this.fechaDWH = fechaDWH;
	}

	public String getSituaDom() {
		return situaDom;
	}

	public void setSituaDom(String situaDom) {
		this.situaDom = situaDom;
	}

	public String getLocContriDom() {
		return locContriDom;
	}

	public void setLocContriDom(String locContriDom) {
		this.locContriDom = locContriDom;
	}

	public String getDetLocContrDom() {
		return detLocContrDom;
	}

	public void setDetLocContrDom(String detLocContrDom) {
		this.detLocContrDom = detLocContrDom;
	}

	public String getNombreRazon() {
		return nombreRazon;
	}

	public String getBusquedaEmail() {
		return busquedaEmail;
	}

	public void setBusquedaEmail(String busquedaEmail) {
		this.busquedaEmail = busquedaEmail;
	}

}
