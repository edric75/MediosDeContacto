
package mx.gob.sat.sir.utileria.clienteSise;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Bitacora" type="{http://tempuri.org/}clsBSBitacora" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "bitacora"
})
@XmlRootElement(name = "Fn_ObtenListaBitacora")
public class FnObtenListaBitacora {

    @XmlElement(name = "Bitacora")
    protected ClsBSBitacora bitacora;

    /**
     * Obtiene el valor de la propiedad bitacora.
     * 
     * @return
     *     possible object is
     *     {@link ClsBSBitacora }
     *     
     */
    public ClsBSBitacora getBitacora() {
        return bitacora;
    }

    /**
     * Define el valor de la propiedad bitacora.
     * 
     * @param value
     *     allowed object is
     *     {@link ClsBSBitacora }
     *     
     */
    public void setBitacora(ClsBSBitacora value) {
        this.bitacora = value;
    }

}
