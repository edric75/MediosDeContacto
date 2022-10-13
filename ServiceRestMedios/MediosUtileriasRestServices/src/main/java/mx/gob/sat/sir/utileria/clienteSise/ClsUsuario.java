
package mx.gob.sat.sir.utileria.clienteSise;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para clsUsuario complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="clsUsuario"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="intIdFuncionario" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="strLogin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strContrasenia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strRfcConsultado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="intIdSistema" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="intIdModulo" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="strNombreUsuario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="blnEstado" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="Perfil" type="{http://tempuri.org/}clsPerfil" minOccurs="0"/&gt;
 *         &lt;element name="blnUsuarioVIP" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "clsUsuario", propOrder = {
    "intIdFuncionario",
    "strLogin",
    "strContrasenia",
    "strRfcConsultado",
    "intIdSistema",
    "intIdModulo",
    "strNombreUsuario",
    "blnEstado",
    "perfil",
    "blnUsuarioVIP"
})
@XmlSeeAlso({
    ClsBSUsuario.class
})
public class ClsUsuario {

    protected int intIdFuncionario;
    protected String strLogin;
    protected String strContrasenia;
    protected String strRfcConsultado;
    protected int intIdSistema;
    protected int intIdModulo;
    protected String strNombreUsuario;
    protected boolean blnEstado;
    @XmlElement(name = "Perfil")
    protected ClsPerfil perfil;
    protected boolean blnUsuarioVIP;

    /**
     * Obtiene el valor de la propiedad intIdFuncionario.
     * 
     */
    public int getIntIdFuncionario() {
        return intIdFuncionario;
    }

    /**
     * Define el valor de la propiedad intIdFuncionario.
     * 
     */
    public void setIntIdFuncionario(int value) {
        this.intIdFuncionario = value;
    }

    /**
     * Obtiene el valor de la propiedad strLogin.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrLogin() {
        return strLogin;
    }

    /**
     * Define el valor de la propiedad strLogin.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrLogin(String value) {
        this.strLogin = value;
    }

    /**
     * Obtiene el valor de la propiedad strContrasenia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrContrasenia() {
        return strContrasenia;
    }

    /**
     * Define el valor de la propiedad strContrasenia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrContrasenia(String value) {
        this.strContrasenia = value;
    }

    /**
     * Obtiene el valor de la propiedad strRfcConsultado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrRfcConsultado() {
        return strRfcConsultado;
    }

    /**
     * Define el valor de la propiedad strRfcConsultado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrRfcConsultado(String value) {
        this.strRfcConsultado = value;
    }

    /**
     * Obtiene el valor de la propiedad intIdSistema.
     * 
     */
    public int getIntIdSistema() {
        return intIdSistema;
    }

    /**
     * Define el valor de la propiedad intIdSistema.
     * 
     */
    public void setIntIdSistema(int value) {
        this.intIdSistema = value;
    }

    /**
     * Obtiene el valor de la propiedad intIdModulo.
     * 
     */
    public int getIntIdModulo() {
        return intIdModulo;
    }

    /**
     * Define el valor de la propiedad intIdModulo.
     * 
     */
    public void setIntIdModulo(int value) {
        this.intIdModulo = value;
    }

    /**
     * Obtiene el valor de la propiedad strNombreUsuario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrNombreUsuario() {
        return strNombreUsuario;
    }

    /**
     * Define el valor de la propiedad strNombreUsuario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrNombreUsuario(String value) {
        this.strNombreUsuario = value;
    }

    /**
     * Obtiene el valor de la propiedad blnEstado.
     * 
     */
    public boolean isBlnEstado() {
        return blnEstado;
    }

    /**
     * Define el valor de la propiedad blnEstado.
     * 
     */
    public void setBlnEstado(boolean value) {
        this.blnEstado = value;
    }

    /**
     * Obtiene el valor de la propiedad perfil.
     * 
     * @return
     *     possible object is
     *     {@link ClsPerfil }
     *     
     */
    public ClsPerfil getPerfil() {
        return perfil;
    }

    /**
     * Define el valor de la propiedad perfil.
     * 
     * @param value
     *     allowed object is
     *     {@link ClsPerfil }
     *     
     */
    public void setPerfil(ClsPerfil value) {
        this.perfil = value;
    }

    /**
     * Obtiene el valor de la propiedad blnUsuarioVIP.
     * 
     */
    public boolean isBlnUsuarioVIP() {
        return blnUsuarioVIP;
    }

    /**
     * Define el valor de la propiedad blnUsuarioVIP.
     * 
     */
    public void setBlnUsuarioVIP(boolean value) {
        this.blnUsuarioVIP = value;
    }

}
