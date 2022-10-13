
package mx.gob.sat.sir.utileria.clienteSise;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para clsRestriccion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="clsRestriccion"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="intIdBloqueo" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="strRfcBloqueado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strTransaccion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strFeIni" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strFeFin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strNbFuncionario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dtmInicioVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="dtmFinVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="blnAcceso" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="blnEnviaCorreo" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="strDestinatarioCorreo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="blnBloqueaCuenta" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="blnBitacoraDB" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="blnBitacoraFile" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="Modulo" type="{http://tempuri.org/}clsModulo" minOccurs="0"/&gt;
 *         &lt;element name="Acceso" type="{http://tempuri.org/}clsAcceso" minOccurs="0"/&gt;
 *         &lt;element name="dtmUltimoMovimiento" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="strIPUltimoMovimiento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="intIdArea" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="strNombreArea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strTpConsulta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="intNoPagina" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="strTotalRegs" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "clsRestriccion", propOrder = {
    "intIdBloqueo",
    "strRfcBloqueado",
    "strTransaccion",
    "strFeIni",
    "strFeFin",
    "strNbFuncionario",
    "dtmInicioVigencia",
    "dtmFinVigencia",
    "blnAcceso",
    "blnEnviaCorreo",
    "strDestinatarioCorreo",
    "blnBloqueaCuenta",
    "blnBitacoraDB",
    "blnBitacoraFile",
    "modulo",
    "acceso",
    "dtmUltimoMovimiento",
    "strIPUltimoMovimiento",
    "intIdArea",
    "strNombreArea",
    "strTpConsulta",
    "intNoPagina",
    "strTotalRegs"
})
@XmlSeeAlso({
    ClsBSRestriccion.class
})
public class ClsRestriccion {

    protected int intIdBloqueo;
    protected String strRfcBloqueado;
    protected String strTransaccion;
    protected String strFeIni;
    protected String strFeFin;
    protected String strNbFuncionario;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dtmInicioVigencia;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dtmFinVigencia;
    protected boolean blnAcceso;
    protected boolean blnEnviaCorreo;
    protected String strDestinatarioCorreo;
    protected boolean blnBloqueaCuenta;
    protected boolean blnBitacoraDB;
    protected boolean blnBitacoraFile;
    @XmlElement(name = "Modulo")
    protected ClsModulo modulo;
    @XmlElement(name = "Acceso")
    protected ClsAcceso acceso;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dtmUltimoMovimiento;
    protected String strIPUltimoMovimiento;
    protected int intIdArea;
    protected String strNombreArea;
    protected String strTpConsulta;
    protected int intNoPagina;
    protected String strTotalRegs;

    /**
     * Obtiene el valor de la propiedad intIdBloqueo.
     * 
     */
    public int getIntIdBloqueo() {
        return intIdBloqueo;
    }

    /**
     * Define el valor de la propiedad intIdBloqueo.
     * 
     */
    public void setIntIdBloqueo(int value) {
        this.intIdBloqueo = value;
    }

    /**
     * Obtiene el valor de la propiedad strRfcBloqueado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrRfcBloqueado() {
        return strRfcBloqueado;
    }

    /**
     * Define el valor de la propiedad strRfcBloqueado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrRfcBloqueado(String value) {
        this.strRfcBloqueado = value;
    }

    /**
     * Obtiene el valor de la propiedad strTransaccion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrTransaccion() {
        return strTransaccion;
    }

    /**
     * Define el valor de la propiedad strTransaccion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrTransaccion(String value) {
        this.strTransaccion = value;
    }

    /**
     * Obtiene el valor de la propiedad strFeIni.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrFeIni() {
        return strFeIni;
    }

    /**
     * Define el valor de la propiedad strFeIni.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrFeIni(String value) {
        this.strFeIni = value;
    }

    /**
     * Obtiene el valor de la propiedad strFeFin.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrFeFin() {
        return strFeFin;
    }

    /**
     * Define el valor de la propiedad strFeFin.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrFeFin(String value) {
        this.strFeFin = value;
    }

    /**
     * Obtiene el valor de la propiedad strNbFuncionario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrNbFuncionario() {
        return strNbFuncionario;
    }

    /**
     * Define el valor de la propiedad strNbFuncionario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrNbFuncionario(String value) {
        this.strNbFuncionario = value;
    }

    /**
     * Obtiene el valor de la propiedad dtmInicioVigencia.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDtmInicioVigencia() {
        return dtmInicioVigencia;
    }

    /**
     * Define el valor de la propiedad dtmInicioVigencia.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDtmInicioVigencia(XMLGregorianCalendar value) {
        this.dtmInicioVigencia = value;
    }

    /**
     * Obtiene el valor de la propiedad dtmFinVigencia.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDtmFinVigencia() {
        return dtmFinVigencia;
    }

    /**
     * Define el valor de la propiedad dtmFinVigencia.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDtmFinVigencia(XMLGregorianCalendar value) {
        this.dtmFinVigencia = value;
    }

    /**
     * Obtiene el valor de la propiedad blnAcceso.
     * 
     */
    public boolean isBlnAcceso() {
        return blnAcceso;
    }

    /**
     * Define el valor de la propiedad blnAcceso.
     * 
     */
    public void setBlnAcceso(boolean value) {
        this.blnAcceso = value;
    }

    /**
     * Obtiene el valor de la propiedad blnEnviaCorreo.
     * 
     */
    public boolean isBlnEnviaCorreo() {
        return blnEnviaCorreo;
    }

    /**
     * Define el valor de la propiedad blnEnviaCorreo.
     * 
     */
    public void setBlnEnviaCorreo(boolean value) {
        this.blnEnviaCorreo = value;
    }

    /**
     * Obtiene el valor de la propiedad strDestinatarioCorreo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrDestinatarioCorreo() {
        return strDestinatarioCorreo;
    }

    /**
     * Define el valor de la propiedad strDestinatarioCorreo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrDestinatarioCorreo(String value) {
        this.strDestinatarioCorreo = value;
    }

    /**
     * Obtiene el valor de la propiedad blnBloqueaCuenta.
     * 
     */
    public boolean isBlnBloqueaCuenta() {
        return blnBloqueaCuenta;
    }

    /**
     * Define el valor de la propiedad blnBloqueaCuenta.
     * 
     */
    public void setBlnBloqueaCuenta(boolean value) {
        this.blnBloqueaCuenta = value;
    }

    /**
     * Obtiene el valor de la propiedad blnBitacoraDB.
     * 
     */
    public boolean isBlnBitacoraDB() {
        return blnBitacoraDB;
    }

    /**
     * Define el valor de la propiedad blnBitacoraDB.
     * 
     */
    public void setBlnBitacoraDB(boolean value) {
        this.blnBitacoraDB = value;
    }

    /**
     * Obtiene el valor de la propiedad blnBitacoraFile.
     * 
     */
    public boolean isBlnBitacoraFile() {
        return blnBitacoraFile;
    }

    /**
     * Define el valor de la propiedad blnBitacoraFile.
     * 
     */
    public void setBlnBitacoraFile(boolean value) {
        this.blnBitacoraFile = value;
    }

    /**
     * Obtiene el valor de la propiedad modulo.
     * 
     * @return
     *     possible object is
     *     {@link ClsModulo }
     *     
     */
    public ClsModulo getModulo() {
        return modulo;
    }

    /**
     * Define el valor de la propiedad modulo.
     * 
     * @param value
     *     allowed object is
     *     {@link ClsModulo }
     *     
     */
    public void setModulo(ClsModulo value) {
        this.modulo = value;
    }

    /**
     * Obtiene el valor de la propiedad acceso.
     * 
     * @return
     *     possible object is
     *     {@link ClsAcceso }
     *     
     */
    public ClsAcceso getAcceso() {
        return acceso;
    }

    /**
     * Define el valor de la propiedad acceso.
     * 
     * @param value
     *     allowed object is
     *     {@link ClsAcceso }
     *     
     */
    public void setAcceso(ClsAcceso value) {
        this.acceso = value;
    }

    /**
     * Obtiene el valor de la propiedad dtmUltimoMovimiento.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDtmUltimoMovimiento() {
        return dtmUltimoMovimiento;
    }

    /**
     * Define el valor de la propiedad dtmUltimoMovimiento.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDtmUltimoMovimiento(XMLGregorianCalendar value) {
        this.dtmUltimoMovimiento = value;
    }

    /**
     * Obtiene el valor de la propiedad strIPUltimoMovimiento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrIPUltimoMovimiento() {
        return strIPUltimoMovimiento;
    }

    /**
     * Define el valor de la propiedad strIPUltimoMovimiento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrIPUltimoMovimiento(String value) {
        this.strIPUltimoMovimiento = value;
    }

    /**
     * Obtiene el valor de la propiedad intIdArea.
     * 
     */
    public int getIntIdArea() {
        return intIdArea;
    }

    /**
     * Define el valor de la propiedad intIdArea.
     * 
     */
    public void setIntIdArea(int value) {
        this.intIdArea = value;
    }

    /**
     * Obtiene el valor de la propiedad strNombreArea.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrNombreArea() {
        return strNombreArea;
    }

    /**
     * Define el valor de la propiedad strNombreArea.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrNombreArea(String value) {
        this.strNombreArea = value;
    }

    /**
     * Obtiene el valor de la propiedad strTpConsulta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrTpConsulta() {
        return strTpConsulta;
    }

    /**
     * Define el valor de la propiedad strTpConsulta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrTpConsulta(String value) {
        this.strTpConsulta = value;
    }

    /**
     * Obtiene el valor de la propiedad intNoPagina.
     * 
     */
    public int getIntNoPagina() {
        return intNoPagina;
    }

    /**
     * Define el valor de la propiedad intNoPagina.
     * 
     */
    public void setIntNoPagina(int value) {
        this.intNoPagina = value;
    }

    /**
     * Obtiene el valor de la propiedad strTotalRegs.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrTotalRegs() {
        return strTotalRegs;
    }

    /**
     * Define el valor de la propiedad strTotalRegs.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrTotalRegs(String value) {
        this.strTotalRegs = value;
    }

}
