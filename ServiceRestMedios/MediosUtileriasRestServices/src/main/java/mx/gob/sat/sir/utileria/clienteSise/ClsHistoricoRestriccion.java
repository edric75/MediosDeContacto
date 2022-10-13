
package mx.gob.sat.sir.utileria.clienteSise;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para clsHistoricoRestriccion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="clsHistoricoRestriccion"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="intIdLogRestriccion" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="strTransaccion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Restriccion" type="{http://tempuri.org/}clsRestriccion" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "clsHistoricoRestriccion", propOrder = {
    "intIdLogRestriccion",
    "strTransaccion",
    "restriccion"
})
public class ClsHistoricoRestriccion {

    protected int intIdLogRestriccion;
    protected String strTransaccion;
    @XmlElement(name = "Restriccion")
    protected ClsRestriccion restriccion;

    /**
     * Obtiene el valor de la propiedad intIdLogRestriccion.
     * 
     */
    public int getIntIdLogRestriccion() {
        return intIdLogRestriccion;
    }

    /**
     * Define el valor de la propiedad intIdLogRestriccion.
     * 
     */
    public void setIntIdLogRestriccion(int value) {
        this.intIdLogRestriccion = value;
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
     * Obtiene el valor de la propiedad restriccion.
     * 
     * @return
     *     possible object is
     *     {@link ClsRestriccion }
     *     
     */
    public ClsRestriccion getRestriccion() {
        return restriccion;
    }

    /**
     * Define el valor de la propiedad restriccion.
     * 
     * @param value
     *     allowed object is
     *     {@link ClsRestriccion }
     *     
     */
    public void setRestriccion(ClsRestriccion value) {
        this.restriccion = value;
    }

}
