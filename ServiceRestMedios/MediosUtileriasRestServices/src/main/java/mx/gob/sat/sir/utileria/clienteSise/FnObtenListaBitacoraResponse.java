
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
 *         &lt;element name="Fn_ObtenListaBitacoraResult" type="{http://tempuri.org/}ArrayOfClsBSBitacora" minOccurs="0"/&gt;
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
    "fnObtenListaBitacoraResult"
})
@XmlRootElement(name = "Fn_ObtenListaBitacoraResponse")
public class FnObtenListaBitacoraResponse {

    @XmlElement(name = "Fn_ObtenListaBitacoraResult")
    protected ArrayOfClsBSBitacora fnObtenListaBitacoraResult;

    /**
     * Obtiene el valor de la propiedad fnObtenListaBitacoraResult.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfClsBSBitacora }
     *     
     */
    public ArrayOfClsBSBitacora getFnObtenListaBitacoraResult() {
        return fnObtenListaBitacoraResult;
    }

    /**
     * Define el valor de la propiedad fnObtenListaBitacoraResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfClsBSBitacora }
     *     
     */
    public void setFnObtenListaBitacoraResult(ArrayOfClsBSBitacora value) {
        this.fnObtenListaBitacoraResult = value;
    }

}
