
package mx.gob.sat.sir.utileria.clienteSise;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para clsBitacora complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="clsBitacora"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="intIdBitacora" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="dtmAceso" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
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
@XmlType(name = "clsBitacora", propOrder = {
    "intIdBitacora",
    "dtmAceso",
    "restriccion"
})
@XmlSeeAlso({
    ClsBSBitacora.class
})
public class ClsBitacora {

    protected int intIdBitacora;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dtmAceso;
    @XmlElement(name = "Restriccion")
    protected ClsRestriccion restriccion;

    /**
     * Obtiene el valor de la propiedad intIdBitacora.
     * 
     */
    public int getIntIdBitacora() {
        return intIdBitacora;
    }

    /**
     * Define el valor de la propiedad intIdBitacora.
     * 
     */
    public void setIntIdBitacora(int value) {
        this.intIdBitacora = value;
    }

    /**
     * Obtiene el valor de la propiedad dtmAceso.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDtmAceso() {
        return dtmAceso;
    }

    /**
     * Define el valor de la propiedad dtmAceso.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDtmAceso(XMLGregorianCalendar value) {
        this.dtmAceso = value;
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
