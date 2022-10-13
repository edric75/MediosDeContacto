
package mx.gob.sat.sir.utileria.clienteSise;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="objRestriccion" type="{http://tempuri.org/}clsRestriccion" minOccurs="0"/&gt;
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
    "objRestriccion"
})
@XmlRootElement(name = "Fn_ObtenHistoricoRestricciones")
public class FnObtenHistoricoRestricciones {

    protected ClsRestriccion objRestriccion;

    /**
     * Obtiene el valor de la propiedad objRestriccion.
     * 
     * @return
     *     possible object is
     *     {@link ClsRestriccion }
     *     
     */
    public ClsRestriccion getObjRestriccion() {
        return objRestriccion;
    }

    /**
     * Define el valor de la propiedad objRestriccion.
     * 
     * @param value
     *     allowed object is
     *     {@link ClsRestriccion }
     *     
     */
    public void setObjRestriccion(ClsRestriccion value) {
        this.objRestriccion = value;
    }

}
