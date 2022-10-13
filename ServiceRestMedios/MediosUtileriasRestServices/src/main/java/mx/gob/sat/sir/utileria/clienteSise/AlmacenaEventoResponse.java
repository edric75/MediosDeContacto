
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
 *         &lt;element name="AlmacenaEventoResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
    "almacenaEventoResult"
})
@XmlRootElement(name = "AlmacenaEventoResponse")
public class AlmacenaEventoResponse {

    @XmlElement(name = "AlmacenaEventoResult")
    protected boolean almacenaEventoResult;

    /**
     * Obtiene el valor de la propiedad almacenaEventoResult.
     * 
     */
    public boolean isAlmacenaEventoResult() {
        return almacenaEventoResult;
    }

    /**
     * Define el valor de la propiedad almacenaEventoResult.
     * 
     */
    public void setAlmacenaEventoResult(boolean value) {
        this.almacenaEventoResult = value;
    }

}
