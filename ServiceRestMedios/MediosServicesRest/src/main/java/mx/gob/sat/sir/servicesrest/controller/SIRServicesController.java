package mx.gob.sat.sir.servicesrest.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import mx.gob.sat.sir.services.BitacoraService;
import mx.gob.sat.sir.services.EmailService;
import mx.gob.sat.sir.services.MediosContactoService;
import mx.gob.sat.sir.services.TelefonoService;
import mx.gob.sat.sir.servicesrest.model.json.request.MediosRequest;
import mx.gob.sat.sir.servicesrest.model.json.response.error.ConsultaError;
import mx.gob.sat.sir.utileria.Utilerias;
import mx.gob.sat.sir.utileria.clienteSise.WSSise;
import mx.gob.sat.sir.utileria.clienteSise.WSSiseSoap;
import mx.gob.sat.sir.utileria.dto.AcuseMailDto;
import mx.gob.sat.sir.utileria.dto.AcuseTelefonoDto;
import mx.gob.sat.sir.utileria.dto.AutenticacionDto;
import mx.gob.sat.sir.utileria.dto.ContribuyenteDto;
import mx.gob.sat.sir.utileria.dto.EmailDto;
import mx.gob.sat.sir.utileria.dto.RegimenDto;
import mx.gob.sat.sir.utileria.dto.TelefonoDto;
import mx.gob.sat.sir.utileria.dto.VerificacionMailDto;
import mx.gob.sat.sir.utileria.dto.VerificacionTelefonoDto;
import mx.gob.sat.sir.utileria.model.AplicativosModel;

@RestController
@JsonIgnoreProperties(ignoreUnknown = true)
public class SIRServicesController {

	private static final  Logger logger = Logger.getLogger(SIRServicesController.class);
	private static final String MSG = "Acceso Denegado";
	private static final String CONSULTAINFOCONTRIBUYENTE = "consultaInfoContribuyente";
	private static final String CONSULTAINFOMAIL = "consultaInfoEmail";
	private static final String CONSULTAINFOVERIFICACIONEMAIL = "consultaInfoVerificacionEmail";
	private static final String CONSULTAACUSEMAIL = "consultaAcuseMail";
	private static final String CONSULTATELEFONO = "consultaTelefono";
	private static final String CONSULTATELEFONOVERIFICACION = "consultaTelefonoVerificacion";
	private static final String CONSULTATELEFONOACUSE = "consultaTelefonoAcuse";
	private static final String CONSULTAREGIMEN = "consultaRegimen";
	private static final String CONSULTAAUTENTICACION = "consultaAutenticacion";
	
	
	@Autowired
	MediosContactoService mediosContactoService;

	@Autowired
	EmailService emailService;

	@Autowired
	TelefonoService telefonoService;

	@Autowired
	BitacoraService bitacoraService;

	Utilerias utils = new Utilerias();

	@PostMapping(value = "/operaciones/rest/consultaInfoContribuyente", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> getConsultaInfoContribuyente(@Valid @RequestBody MediosRequest mediosRequest,
			HttpServletRequest request) {
		logger.info("::: REALIZANDO OPERACION PARA CONSULTA CONTRIBUYENTE :::");
		logger.info("::: IP CLIENTE :::");
		Map<String, Object> mapaRespuesta = new HashMap<>();
		ContribuyenteDto contribuyenteDto = new ContribuyenteDto();
		
		try {
			AplicativosModel aplicativo = bitacoraService.getAplicativos(mediosRequest.getIdAplicativo());
			String ipConsulta = this.getIp(request);
			String rfc = mediosRequest.getParametroBusqueda();
			if (!mediosRequest.getIdAplicativo().equals("") && mediosRequest.getIdAplicativo() != null) {
				bitacoraService.addBitacora(rfc, "INFO_CONTRIBUYENTE", ipConsulta, aplicativo.getNombreAplicativo());
			}
			if (mediosRequest.getIdAplicativo() != null
					&& mediosRequest.getIdAplicativo().equals(aplicativo.getIdAplicativo())) {
				contribuyenteDto = mediosContactoService.getInfoContribuyente(mediosRequest.getTipoBusqueda(),
						mediosRequest.getParametroBusqueda());
				if (contribuyenteDto.getInformacionContribuyente().size() > 0) {
					if (utils.validacionSise(contribuyenteDto.getInformacionContribuyente().get(0).getRfc(),mediosRequest.getRfcLogin()) == 1) {
						mapaRespuesta.put(CONSULTAINFOCONTRIBUYENTE, contribuyenteDto.getInformacionContribuyente());
					} else {
						mapaRespuesta.put(CONSULTAINFOCONTRIBUYENTE, siseMsg());
					}
				}else{
					mapaRespuesta.put(CONSULTAINFOCONTRIBUYENTE, contribuyenteDto.getInformacionContribuyente());					
				}
			} else {
				mapaRespuesta.put(CONSULTAINFOCONTRIBUYENTE, MSG);
			}

		} catch (Exception e) {
			logger.debug ("::: Ocurrio un error al momento de realizar la operacion Consulta Info Contribuyente :::"+ e);
		}

		return mapaRespuesta;
	}

	@PostMapping(value = "/operaciones/rest/consultaInfoEmail", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> getConsultaInfoEmail(@Valid @RequestBody MediosRequest mediosRequest,
			HttpServletRequest request) {
		logger.info("::: REALIZANDO OPERACION PARA CONSULTA INFO EMAIL :::");
		Map<String, Object> mapaRespuesta = new HashMap<>();
		EmailDto emailDto = new EmailDto();
		try {
			AplicativosModel aplicativo = bitacoraService.getAplicativos(mediosRequest.getIdAplicativo());
			String ipConsulta = this.getIp(request);
			String rfc = mediosRequest.getParametroBusqueda();
			if (!mediosRequest.getIdAplicativo().equals("") && mediosRequest.getIdAplicativo() != null) {
				bitacoraService.addBitacora(rfc, "INFO_CONTRIBUYENTE", ipConsulta, aplicativo.getNombreAplicativo());
			}
			if (mediosRequest.getIdAplicativo() != null
					&& mediosRequest.getIdAplicativo().equals(aplicativo.getIdAplicativo())) {
				emailDto = emailService.getInfoEmail(mediosRequest.getTipoBusqueda(),
						mediosRequest.getParametroBusqueda());
				if (emailDto.getInformacionEmail().size() > 0) {
					if (utils.validacionSise(emailDto.getInformacionEmail().get(0).getRfc(), mediosRequest.getRfcLogin()) == 1) {
						mapaRespuesta.put(CONSULTAINFOMAIL, emailDto.getInformacionEmail());
					} else {
						mapaRespuesta.put(CONSULTAINFOMAIL, siseMsg());
					}
				}else{
					mapaRespuesta.put(CONSULTAINFOMAIL, emailDto.getInformacionEmail());					
				}
			} else {
				mapaRespuesta.put(CONSULTAINFOMAIL, MSG);
			}
		} catch (Exception e) {
			logger.debug ("::: Ocurrio un error al momento de realizar la operacion Consulta Info Mail :::",e);
		}

		return mapaRespuesta;
	}

	@PostMapping(value = "/operaciones/rest/consultaVerificacionEmail", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> getConsultaVerificacionEmail(@Valid @RequestBody MediosRequest mediosRequest,
			HttpServletRequest request) {
		logger.info("::: REALIZANDO OPERACION PARA CONSULTA INFO VERIFICACION EMAIL :::");
		Map<String, Object> mapaRespuesta = new HashMap<>();
		VerificacionMailDto verificacionMailDto = new VerificacionMailDto();
		try {
			AplicativosModel aplicativo = bitacoraService.getAplicativos(mediosRequest.getIdAplicativo());
			if (!mediosRequest.getIdAplicativo().equals("") && mediosRequest.getIdAplicativo() != null) {
				String ipConsulta = this.getIp(request);
				String rfc = mediosRequest.getParametroBusqueda();
				bitacoraService.addBitacora(rfc, "VERIFICACION_EMAIL", ipConsulta, aplicativo.getNombreAplicativo());
			}
			if (mediosRequest.getIdAplicativo() != null
					&& mediosRequest.getIdAplicativo().equals(aplicativo.getIdAplicativo())) {
				verificacionMailDto = emailService.getVerificacionMail(mediosRequest.getTipoBusqueda(),
						mediosRequest.getParametroBusqueda());
				if (verificacionMailDto.getInformacionVerificacionMail().size() > 0) {
					if (utils.validacionSise(verificacionMailDto.getInformacionVerificacionMail().get(0).getRfc(), mediosRequest.getRfcLogin()) == 1) {
						mapaRespuesta.put(CONSULTAINFOVERIFICACIONEMAIL, verificacionMailDto.getInformacionVerificacionMail());
					} else {
						mapaRespuesta.put(CONSULTAINFOVERIFICACIONEMAIL, siseMsg());
					}
				}else{
					mapaRespuesta.put(CONSULTAINFOVERIFICACIONEMAIL, verificacionMailDto.getInformacionVerificacionMail());					
				}
			} else {
				mapaRespuesta.put(CONSULTAINFOVERIFICACIONEMAIL, MSG);
			}				
				
		} catch (Exception e) {
			logger.debug (
					"::: Ocurrio un error al momento de realizar la operacion Consulta consultaInfoVerificacionEmail :::",e);
		}

		return mapaRespuesta;
	}

	@PostMapping(value = "/operaciones/rest/consultaAcuseEmail", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> getConsultaAcuseEmail(@Valid @RequestBody MediosRequest mediosRequest,
			HttpServletRequest request) {
		logger.info("::: REALIZANDO OPERACION PARA CONSULTA INFO ACUSE EMAIL :::");
		Map<String, Object> mapaRespuesta = new HashMap<>();
		AcuseMailDto acuseMailDto = new AcuseMailDto();
		try {
			AplicativosModel aplicativo = bitacoraService.getAplicativos(mediosRequest.getIdAplicativo());
			if (!mediosRequest.getIdAplicativo().equals("") && mediosRequest.getIdAplicativo() != null) {
				String ipConsulta = this.getIp(request);
				String rfc = mediosRequest.getParametroBusqueda();
				bitacoraService.addBitacora(rfc, "ACUSE_EMAIL", ipConsulta, aplicativo.getNombreAplicativo());
			}
			if (mediosRequest.getIdAplicativo() != null
					&& mediosRequest.getIdAplicativo().equals(aplicativo.getIdAplicativo())) {
				acuseMailDto = emailService.getAcuseMail(mediosRequest.getTipoBusqueda(),
						mediosRequest.getParametroBusqueda());
				if (acuseMailDto.getInformacionAcuseMail().size() > 0) {
					if (utils.validacionSise(acuseMailDto.getInformacionAcuseMail().get(0).getRfc(), mediosRequest.getRfcLogin()) == 1) {
						mapaRespuesta.put(CONSULTAACUSEMAIL, acuseMailDto.getInformacionAcuseMail());
					} else {
						mapaRespuesta.put(CONSULTAACUSEMAIL, siseMsg());
					}
				}else{
					mapaRespuesta.put(CONSULTAACUSEMAIL, acuseMailDto.getInformacionAcuseMail());					
				}
			} else {
				mapaRespuesta.put(CONSULTAACUSEMAIL, MSG);
			}					
		} catch (Exception e) {
			logger.debug ("::: Ocurrio un error al momento de realizar la operacion Consulta consultaAcuseEmail :::",e);
		}

		return mapaRespuesta;
	}

	@PostMapping(value = "/operaciones/rest/consultaInfoTelefono", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> getConsultaTelefono(@Valid @RequestBody MediosRequest mediosRequest,
			HttpServletRequest request) {
		logger.info("::: REALIZANDO OPERACION PARA CONSULTA INFO TELEFONO :::");
		Map<String, Object> mapaRespuesta = new HashMap<>();
		TelefonoDto telefonoDto = new TelefonoDto();
		try {
			AplicativosModel aplicativo = bitacoraService.getAplicativos(mediosRequest.getIdAplicativo());
			if (!mediosRequest.getIdAplicativo().equals("") && mediosRequest.getIdAplicativo() != null) {
				String ipConsulta = this.getIp(request);
				String rfc = mediosRequest.getParametroBusqueda();
				bitacoraService.addBitacora(rfc, "TELEFONO", ipConsulta, aplicativo.getNombreAplicativo());
			}
			if (mediosRequest.getIdAplicativo() != null
					&& mediosRequest.getIdAplicativo().equals(aplicativo.getIdAplicativo())) {
				telefonoDto = telefonoService.getInformacionTelefono(mediosRequest.getTipoBusqueda(),
						mediosRequest.getParametroBusqueda());
				if (telefonoDto.getInformacionTelefono().size() > 0) {
					if (utils.validacionSise(telefonoDto.getInformacionTelefono().get(0).getRfc(), mediosRequest.getRfcLogin()) == 1) {
						mapaRespuesta.put(CONSULTATELEFONO, telefonoDto.getInformacionTelefono());
					} else {
						mapaRespuesta.put(CONSULTATELEFONO, siseMsg());
					}
				}else{
					mapaRespuesta.put(CONSULTATELEFONO, telefonoDto.getInformacionTelefono());					
				}
			} else {
				mapaRespuesta.put(CONSULTATELEFONO, MSG);
			}					
		} catch (Exception e) {
			logger.debug ("::: Ocurrio un error al momento de realizar la operacion Consulta Verificacion Telefono :::",e);
		}

		return mapaRespuesta;
	}

	@PostMapping(value = "/operaciones/rest/consultaInfoVerificacionTelefono", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> getConsultaVerificacionTelefono(@Valid @RequestBody MediosRequest mediosRequest,
			HttpServletRequest request) {
		logger.info("::: REALIZANDO OPERACION PARA CONSULTA INFO VERIFICACION TELEFONO :::");
		Map<String, Object> mapaRespuesta = new HashMap<>();
		VerificacionTelefonoDto telefonoDto = new VerificacionTelefonoDto();
		try {
			AplicativosModel aplicativo = bitacoraService.getAplicativos(mediosRequest.getIdAplicativo());
			if (!mediosRequest.getIdAplicativo().equals("") && mediosRequest.getIdAplicativo() != null) {
				String ipConsulta = this.getIp(request);
				String rfc = mediosRequest.getParametroBusqueda();
				bitacoraService.addBitacora(rfc, "VERIFICACION_TELEFONO", ipConsulta, aplicativo.getNombreAplicativo());
			}
			if (mediosRequest.getIdAplicativo() != null
					&& mediosRequest.getIdAplicativo().equals(aplicativo.getIdAplicativo())) {
				telefonoDto = telefonoService.getVerificacionTelefono(mediosRequest.getTipoBusqueda(),
						mediosRequest.getParametroBusqueda());
				if (telefonoDto.getVerificacionTeleono().size() > 0) {
					if (utils.validacionSise(telefonoDto.getVerificacionTeleono().get(0).getRfc(), mediosRequest.getRfcLogin()) == 1) {
						mapaRespuesta.put(CONSULTATELEFONOVERIFICACION, telefonoDto.getVerificacionTeleono());
					} else {
						mapaRespuesta.put(CONSULTATELEFONOVERIFICACION, siseMsg());
					}
				}else{
					mapaRespuesta.put(CONSULTATELEFONOVERIFICACION, telefonoDto.getVerificacionTeleono());					
				}
			} else {
				mapaRespuesta.put(CONSULTATELEFONOVERIFICACION, MSG);
			}					

		} catch (Exception e) {
			logger.debug ("::: Ocurrio un error al momento de realizar la operacion Consulta Telefono :::",e);
		}

		return mapaRespuesta;
	}

	@PostMapping(value = "/operaciones/rest/consultaAcuseTelefono", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> getConsultaAcuseTelefono(@Valid @RequestBody MediosRequest mediosRequest,
			HttpServletRequest request) {
		logger.info("::: REALIZANDO OPERACION PARA CONSULTA INFO ACUSE TELEFONO :::");
		Map<String, Object> mapaRespuesta = new HashMap<>();
		AcuseTelefonoDto telefonoDto = new AcuseTelefonoDto();
		try {
			AplicativosModel aplicativo = bitacoraService.getAplicativos(mediosRequest.getIdAplicativo());
			if (!mediosRequest.getIdAplicativo().equals("") && mediosRequest.getIdAplicativo() != null) {
				String ipConsulta = this.getIp(request);
				String rfc = mediosRequest.getParametroBusqueda();
				bitacoraService.addBitacora(rfc, "ACUSE_TELEFONO", ipConsulta, aplicativo.getNombreAplicativo());
			}
			if (mediosRequest.getIdAplicativo() != null
					&& mediosRequest.getIdAplicativo().equals(aplicativo.getIdAplicativo())) {
				telefonoDto = telefonoService.getAcuseTelefono(mediosRequest.getTipoBusqueda(),
						mediosRequest.getParametroBusqueda());
				if (telefonoDto.getInformacionAcuseTelefono().size() > 0) {
					if (utils.validacionSise(telefonoDto.getInformacionAcuseTelefono().get(0).getRfc(), mediosRequest.getRfcLogin()) == 1) {
						mapaRespuesta.put(CONSULTATELEFONOACUSE, telefonoDto.getInformacionAcuseTelefono());
					} else {
						mapaRespuesta.put(CONSULTATELEFONOACUSE, siseMsg());
					}
				}else{
					mapaRespuesta.put(CONSULTATELEFONOACUSE, telefonoDto.getInformacionAcuseTelefono());					
				}
			} else {
				mapaRespuesta.put(CONSULTATELEFONOACUSE, MSG);
			}					
		} catch (Exception e) {
			logger.debug ("::: Ocurrio un error al momento de realizar la operacion Consulta Acuse Telefono :::",e);
		}

		return mapaRespuesta;
	}

	@PostMapping(value = "/operaciones/rest/consultaRegimen", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> getConsultaRegimen(@Valid @RequestBody MediosRequest mediosRequest,
			HttpServletRequest request) {
		logger.info("::: REALIZANDO OPERACION PARA CONSULTA INFO REGIMEN :::");
		Map<String, Object> mapaRespuesta = new HashMap<>();
		RegimenDto regimenDto = new RegimenDto();

		try {
			AplicativosModel aplicativo = bitacoraService.getAplicativos(mediosRequest.getIdAplicativo());
			if (!mediosRequest.getIdAplicativo().equals("") && mediosRequest.getIdAplicativo() != null) {
				String ipConsulta = this.getIp(request);
				String rfc = mediosRequest.getParametroBusqueda();
				bitacoraService.addBitacora(rfc, "INFO_REGIMEN", ipConsulta, aplicativo.getNombreAplicativo());
			}
			if (mediosRequest.getIdAplicativo() != null
					&& mediosRequest.getIdAplicativo().equals(aplicativo.getIdAplicativo())) {
				regimenDto = mediosContactoService.getInfoRegimen(mediosRequest.getTipoBusqueda(),
						mediosRequest.getParametroBusqueda());
				if (regimenDto.getInformacionRegimen().size() > 0) {
					if (utils.validacionSise(regimenDto.getInformacionRegimen().get(0).getRfc(), mediosRequest.getRfcLogin()) == 1) {
						mapaRespuesta.put(CONSULTAREGIMEN, regimenDto.getInformacionRegimen());
					} else {
						mapaRespuesta.put(CONSULTAREGIMEN, siseMsg());
					}
				}else{
					mapaRespuesta.put(CONSULTAREGIMEN, regimenDto.getInformacionRegimen());					
				}
			} else {
				mapaRespuesta.put(CONSULTAREGIMEN, MSG);
			}					

		} catch (Exception e) {
			logger.debug ("::: Ocurrio un error al momento de realizar la operacion Consulta Regimen :::",e);
		}

		return mapaRespuesta;
	}

	@PostMapping(value = "/operaciones/rest/consultaAutenticacion", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> getConsultaAutenticacion(@Valid @RequestBody MediosRequest mediosRequest,
			HttpServletRequest request) {
		logger.info("::: REALIZANDO OPERACION PARA CONSULTA INFO AUTENTICACION :::");
		Map<String, Object> mapaRespuesta = new HashMap<>();
		AutenticacionDto autenticacionDto = new AutenticacionDto();
		try {
			AplicativosModel aplicativo = bitacoraService.getAplicativos(mediosRequest.getIdAplicativo());
			if (!mediosRequest.getIdAplicativo().equals("") && mediosRequest.getIdAplicativo() != null) {
				String ipConsulta = this.getIp(request);
				String rfc = mediosRequest.getParametroBusqueda();
				bitacoraService.addBitacora(rfc, "AUTENTICACION", ipConsulta, aplicativo.getNombreAplicativo());
			}
			if (mediosRequest.getIdAplicativo().equals(aplicativo.getIdAplicativo())) {
				autenticacionDto = mediosContactoService.getInfoAutenticacion(mediosRequest.getTipoBusqueda(),
						mediosRequest.getParametroBusqueda());
				if (autenticacionDto.getInformacionAutenticacion().size() > 0) {
					if (utils.validacionSise(autenticacionDto.getInformacionAutenticacion().get(0).getRfc(), mediosRequest.getRfcLogin()) == 1) {
						mapaRespuesta.put(CONSULTAAUTENTICACION, autenticacionDto.getInformacionAutenticacion());
					} else {
						mapaRespuesta.put(CONSULTAAUTENTICACION, siseMsg());
					}
				}else{
					mapaRespuesta.put(CONSULTAAUTENTICACION, autenticacionDto.getInformacionAutenticacion());					
				}
			} else {
				mapaRespuesta.put(CONSULTAAUTENTICACION, MSG);
			}					

		} catch (Exception e) {
			logger.debug ("::: Ocurrio un error al momento de realizar la operacion Consulta Autenticacion :::",e);
		}

		return mapaRespuesta;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ConsultaError getMensajeErrorGet() {
		ConsultaError consultaError = new ConsultaError();
		consultaError.setError("Las peticiones GET no son soportadas");
		return consultaError;
	}

	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ConsultaError getMensajeErrorPut() {
		ConsultaError consultaError = new ConsultaError();
		consultaError.setError("Las peticiones PUT no son soportadas");
		return consultaError;
	}

	@DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ConsultaError getMensajeErrorDelete() {
		ConsultaError consultaError = new ConsultaError();
		consultaError.setError("Las peticiones DELETE no son soportadas");
		return consultaError;
	}

	@PatchMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ConsultaError getMensajeErrorPatch() {
		ConsultaError consultaError = new ConsultaError();
		consultaError.setError("Las peticiones PATCH no son soportadas");
		return consultaError;
	}

	public String getIp(HttpServletRequest request) {
		String userIpAddress = request.getHeader("X-FORWARDED-FOR");
		if (userIpAddress == null) {
			userIpAddress = request.getRemoteAddr();
		}
		return userIpAddress;
	}

	public ArrayNode siseMsg() {
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode parentArray = mapper.createArrayNode();
		ObjectNode info = mapper.createObjectNode();
		info.put("SISE", "El RFC solicitado no esta disponible para su consulta");
		parentArray.add(info);
		return parentArray;
	}

}
