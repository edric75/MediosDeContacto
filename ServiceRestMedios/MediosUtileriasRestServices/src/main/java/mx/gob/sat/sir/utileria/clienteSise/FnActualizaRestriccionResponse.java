
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
 *         &lt;element name="Fn_ActualizaRestriccionResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
    "fnActualizaRestriccionResult"
})
@XmlRootElement(name = "Fn_ActualizaRestriccionResponse")
public class FnActualizaRestriccionResponse {

    @XmlElement(name = "Fn_ActualizaRestriccionResult")
    protected boolean fnActualizaRestriccionResult;

    /**
     * Obtiene el valor de la propiedad fnActualizaRestriccionResult.
     * 
     */
    public boolean isFnActualizaRestriccionResult() {
        return fnActualizaRestriccionResult;
    }

    /**
     * Define el valor de la propiedad fnActualizaRestriccionResult.
     * 
     */
    public void setFnActualizaRestriccionResult(boolean value) {
        this.fnActualizaRestriccionResult = value;
    }

}
