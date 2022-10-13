
package mx.gob.sat.sir.utileria.clienteSise;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para clsAcceso complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="clsAcceso"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Usuario" type="{http://tempuri.org/}clsUsuario" minOccurs="0"/&gt;
 *         &lt;element name="dtmAcceso" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="strIp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strMac" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "clsAcceso", propOrder = {
    "usuario",
    "dtmAcceso",
    "strIp",
    "strMac"
})
@XmlSeeAlso({
    ClsBSAcceso.class
})
public class ClsAcceso {

    @XmlElement(name = "Usuario")
    protected ClsUsuario usuario;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dtmAcceso;
    protected String strIp;
    protected String strMac;

    /**
     * Obtiene el valor de la propiedad usuario.
     * 
     * @return
     *     possible object is
     *     {@link ClsUsuario }
     *     
     */
    public ClsUsuario getUsuario() {
        return usuario;
    }

    /**
     * Define el valor de la propiedad usuario.
     * 
     * @param value
     *     allowed object is
     *     {@link ClsUsuario }
     *     
     */
    public void setUsuario(ClsUsuario value) {
        this.usuario = value;
    }

    /**
     * Obtiene el valor de la propiedad dtmAcceso.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDtmAcceso() {
        return dtmAcceso;
    }

    /**
     * Define el valor de la propiedad dtmAcceso.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDtmAcceso(XMLGregorianCalendar value) {
        this.dtmAcceso = value;
    }

    /**
     * Obtiene el valor de la propiedad strIp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrIp() {
        return strIp;
    }

    /**
     * Define el valor de la propiedad strIp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrIp(String value) {
        this.strIp = value;
    }

    /**
     * Obtiene el valor de la propiedad strMac.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrMac() {
        return strMac;
    }

    /**
     * Define el valor de la propiedad strMac.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrMac(String value) {
        this.strMac = value;
    }

}
