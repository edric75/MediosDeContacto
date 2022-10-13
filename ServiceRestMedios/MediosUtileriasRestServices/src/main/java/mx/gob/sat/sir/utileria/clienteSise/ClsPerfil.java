
package mx.gob.sat.sir.utileria.clienteSise;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para clsPerfil complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="clsPerfil"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="intIdPerfil" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strNombrePerfil" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "clsPerfil", propOrder = {
    "intIdPerfil",
    "strNombrePerfil"
})
public class ClsPerfil {

    protected String intIdPerfil;
    protected String strNombrePerfil;

    /**
     * Obtiene el valor de la propiedad intIdPerfil.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIntIdPerfil() {
        return intIdPerfil;
    }

    /**
     * Define el valor de la propiedad intIdPerfil.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIntIdPerfil(String value) {
        this.intIdPerfil = value;
    }

    /**
     * Obtiene el valor de la propiedad strNombrePerfil.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrNombrePerfil() {
        return strNombrePerfil;
    }

    /**
     * Define el valor de la propiedad strNombrePerfil.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrNombrePerfil(String value) {
        this.strNombrePerfil = value;
    }

}
