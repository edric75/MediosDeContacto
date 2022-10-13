
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
 *         &lt;element name="Fn_AgregaRestriccionResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
    "fnAgregaRestriccionResult"
})
@XmlRootElement(name = "Fn_AgregaRestriccionResponse")
public class FnAgregaRestriccionResponse {

    @XmlElement(name = "Fn_AgregaRestriccionResult")
    protected boolean fnAgregaRestriccionResult;

    /**
     * Obtiene el valor de la propiedad fnAgregaRestriccionResult.
     * 
     */
    public boolean isFnAgregaRestriccionResult() {
        return fnAgregaRestriccionResult;
    }

    /**
     * Define el valor de la propiedad fnAgregaRestriccionResult.
     * 
     */
    public void setFnAgregaRestriccionResult(boolean value) {
        this.fnAgregaRestriccionResult = value;
    }

}
