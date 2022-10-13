package mx.gob.sat.sir.persistencia.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mx.gob.sat.sir.utileria.model.ContribuyenteModel;

public class InfoContribuyenteRowMapper implements RowMapper<ContribuyenteModel>{

	public ContribuyenteModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		ContribuyenteModel contribuyenteModel = new ContribuyenteModel();
		contribuyenteModel.setIdContribuyente(rs.getString("ID_CONTRIBUYENTE"));
		contribuyenteModel.setIdTipoPersona(rs.getString("ID_TIPO_PERSONA"));
		contribuyenteModel.setRfc(rs.getString("RFC"));
		contribuyenteModel.setCurp(rs.getString("CURP"));
		contribuyenteModel.setApellidoPaterno(rs.getString("APELLIDO_PATERNO"));
		contribuyenteModel.setApellidoMaterno(rs.getString("APELLIDO_MATERNO"));
		contribuyenteModel.setNombre(rs.getString("NOMBRE"));
		contribuyenteModel.setEstatus(rs.getString("ESTATUS"));
		contribuyenteModel.setFechaInicioOp(rs.getDate("FECHA_INICIO_OP"));
		contribuyenteModel.setCalle(rs.getString("CALLE"));
		contribuyenteModel.setNumeroExterior(rs.getString("NUMERO_EXTERIOR"));
		contribuyenteModel.setNumeroInterior(rs.getString("NUMERO_INTERIOR"));
		contribuyenteModel.setColonia(rs.getString("COLONIA"));
		contribuyenteModel.setAsentamiento(rs.getString("ASENTAMIENTO"));
		contribuyenteModel.setReferencia(rs.getString("REFERENCIA"));
		contribuyenteModel.setEntreLaCalle(rs.getString("ENTRE_LA_CALLE"));
		contribuyenteModel.setYLaCalle(rs.getString("Y_LA_CALLE"));
		contribuyenteModel.setCodigoPostal(rs.getString("CODIGO_POSTAL"));
		contribuyenteModel.setEntidadFederativa(rs.getString("ENTIDAD_FEDERATIVA"));
		contribuyenteModel.setMunicipio(rs.getString("MUNICIPIO"));
		contribuyenteModel.setFechaRegistro(rs.getDate("FECHA_REGISTRO"));
		contribuyenteModel.setFechaDWH(rs.getString("FECHA_DWH"));
		contribuyenteModel.setSituaDom(rs.getString("SITUAC_DOMIC"));
		contribuyenteModel.setLocContriDom(rs.getString("LOC_CONTRIB_DOMIC"));
		contribuyenteModel.setDetLocContrDom(rs.getString("DET_LOC_CONTRIB_DOMIC"));
		return contribuyenteModel;
	}

}
