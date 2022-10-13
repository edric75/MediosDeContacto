
package mx.gob.sat.sir.utileria.clienteSise;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para clsArea complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="clsArea"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="strIdArea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strNombreArea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strTipoArea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "clsArea", propOrder = {
    "strIdArea",
    "strNombreArea",
    "strTipoArea"
})
@XmlSeeAlso({
    ClsBSArea.class
})
public class ClsArea {

    protected String strIdArea;
    protected String strNombreArea;
    protected String strTipoArea;

    /**
     * Obtiene el valor de la propiedad strIdArea.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrIdArea() {
        return strIdArea;
    }

    /**
     * Define el valor de la propiedad strIdArea.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrIdArea(String value) {
        this.strIdArea = value;
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
     * Obtiene el valor de la propiedad strTipoArea.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrTipoArea() {
        return strTipoArea;
    }

    /**
     * Define el valor de la propiedad strTipoArea.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrTipoArea(String value) {
        this.strTipoArea = value;
    }

}
