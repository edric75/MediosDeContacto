package mx.gob.sat.sir.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.gob.sat.sir.persistencia.dao.EmailDao;
import mx.gob.sat.sir.services.EmailService;
import mx.gob.sat.sir.utileria.dto.AcuseMailDto;
import mx.gob.sat.sir.utileria.dto.EmailDto;
import mx.gob.sat.sir.utileria.dto.VerificacionMailDto;
import mx.gob.sat.sir.utileria.model.AcuseMailModel;
import mx.gob.sat.sir.utileria.model.EmailModel;
import mx.gob.sat.sir.utileria.model.VerificacionMailModel;
import mx.gob.sat.sir.utileria.Utilerias;

@Service
public class EmailServiceImpl implements EmailService {
	private final static Logger logger = Logger.getLogger(EmailServiceImpl.class);
	private static final String APLICATIVO = "BUZON";
	
	@Autowired
	EmailDao emailDao;
	
	Utilerias utils = new Utilerias();
	
	public EmailDto getInfoEmail(String tipoBusqueda, String parametroBusqueda) {
		EmailDto emailDto = new EmailDto(); 
		List<EmailModel> infoEmail = new ArrayList<EmailModel>();

		try {
			infoEmail = emailDao.getinfoEmail(tipoBusqueda, parametroBusqueda);		
			for(int i=0;i<infoEmail.size();i++){
					if(infoEmail.get(i).getAplicativo().equals(APLICATIVO)){
						String email = Utilerias.enmascaraEmail(infoEmail.get(i).getEmail());
						String emailPrincipal = Utilerias.enmascaraEmail(infoEmail.get(i).getEmailPrincipal());
						String emailDq = Utilerias.enmascaraEmail(infoEmail.get(i).getEmailDq());											
						infoEmail.get(i).setEmail(email);
						infoEmail.get(i).setEmailPrincipal(emailPrincipal);
						infoEmail.get(i).setEmailDq(emailDq);
						
					}
			}
			emailDto.setInformacionEmail(infoEmail);
		}catch (Exception e) {
			emailDto.setInformacionEmail(infoEmail);
			logger.info("::: Error ServiceImpl medios de contacto:", e);
		}
		return emailDto;
	
	}

	public VerificacionMailDto getVerificacionMail(String tipoBusqueda, String parametroBusqueda) {
		VerificacionMailDto emailDto = new VerificacionMailDto(); 
		List<VerificacionMailModel> infoEmail = new ArrayList<VerificacionMailModel>();
		try {
			infoEmail = emailDao.getInfoVerificacionMail(tipoBusqueda, parametroBusqueda);
			for(int i=0;i<infoEmail.size();i++){
				if(infoEmail.get(i).getAplicativo().equals(APLICATIVO)){
					String email = Utilerias.enmascaraEmail(infoEmail.get(i).getEmail());
					infoEmail.get(i).setEmail(email);				
				}
			}
			emailDto.setInformacionVerificacionMail(infoEmail);
		}catch (Exception e) {
			emailDto.setInformacionVerificacionMail(infoEmail);
			logger.info("::: Error ServiceImpl verificacion email:");
		}
		return emailDto;
	}

	public AcuseMailDto getAcuseMail(String tipoBusqueda, String parametroBusqueda) {
		AcuseMailDto emailDto = new AcuseMailDto(); 
		List<AcuseMailModel> infoEmail = new ArrayList<AcuseMailModel>();
		try {
			infoEmail = emailDao.getInfoAcuseMail(tipoBusqueda, parametroBusqueda);
			for(int i=0;i<infoEmail.size();i++){
				if(infoEmail.get(i).getAplicativo().equals(APLICATIVO)){
					String email = Utilerias.enmascaraEmail(infoEmail.get(i).getEmail());
					infoEmail.get(i).setEmail(email);				
				}
			}			
			emailDto.setInformacionAcuseMail(infoEmail);
		}catch (Exception e) {
			emailDto.setInformacionAcuseMail(infoEmail);
			logger.info("::: Error ServiceImpl acuse mail");
		}
		return emailDto;
	}

}
