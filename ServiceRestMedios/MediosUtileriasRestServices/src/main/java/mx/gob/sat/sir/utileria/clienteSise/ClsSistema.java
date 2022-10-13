
package mx.gob.sat.sir.utileria.clienteSise;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para clsSistema complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="clsSistema"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="strIdSistema" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strNombreSistema" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="blnServicioActivo" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "clsSistema", propOrder = {
    "strIdSistema",
    "strNombreSistema",
    "blnServicioActivo"
})
public class ClsSistema {

    protected String strIdSistema;
    protected String strNombreSistema;
    protected boolean blnServicioActivo;

    /**
     * Obtiene el valor de la propiedad strIdSistema.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrIdSistema() {
        return strIdSistema;
    }

    /**
     * Define el valor de la propiedad strIdSistema.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrIdSistema(String value) {
        this.strIdSistema = value;
    }

    /**
     * Obtiene el valor de la propiedad strNombreSistema.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrNombreSistema() {
        return strNombreSistema;
    }

    /**
     * Define el valor de la propiedad strNombreSistema.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrNombreSistema(String value) {
        this.strNombreSistema = value;
    }

    /**
     * Obtiene el valor de la propiedad blnServicioActivo.
     * 
     */
    public boolean isBlnServicioActivo() {
        return blnServicioActivo;
    }

    /**
     * Define el valor de la propiedad blnServicioActivo.
     * 
     */
    public void setBlnServicioActivo(boolean value) {
        this.blnServicioActivo = value;
    }

}
