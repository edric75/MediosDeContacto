
package mx.gob.sat.sir.utileria.clienteSise;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para clsModulo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="clsModulo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="strIdModulo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strNombreModulo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Sistema" type="{http://tempuri.org/}clsSistema" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "clsModulo", propOrder = {
    "strIdModulo",
    "strNombreModulo",
    "sistema"
})
@XmlSeeAlso({
    ClsBSModulo.class
})
public class ClsModulo {

    protected String strIdModulo;
    protected String strNombreModulo;
    @XmlElement(name = "Sistema")
    protected ClsSistema sistema;

    /**
     * Obtiene el valor de la propiedad strIdModulo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrIdModulo() {
        return strIdModulo;
    }

    /**
     * Define el valor de la propiedad strIdModulo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrIdModulo(String value) {
        this.strIdModulo = value;
    }

    /**
     * Obtiene el valor de la propiedad strNombreModulo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrNombreModulo() {
        return strNombreModulo;
    }

    /**
     * Define el valor de la propiedad strNombreModulo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrNombreModulo(String value) {
        this.strNombreModulo = value;
    }

    /**
     * Obtiene el valor de la propiedad sistema.
     * 
     * @return
     *     possible object is
     *     {@link ClsSistema }
     *     
     */
    public ClsSistema getSistema() {
        return sistema;
    }

    /**
     * Define el valor de la propiedad sistema.
     * 
     * @param value
     *     allowed object is
     *     {@link ClsSistema }
     *     
     */
    public void setSistema(ClsSistema value) {
        this.sistema = value;
    }

}
