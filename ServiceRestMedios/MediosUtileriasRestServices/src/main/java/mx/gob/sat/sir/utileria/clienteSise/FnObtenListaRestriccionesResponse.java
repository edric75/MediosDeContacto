
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
 *         &lt;element name="Fn_ObtenListaRestriccionesResult" type="{http://tempuri.org/}ArrayOfClsBSRestriccion" minOccurs="0"/&gt;
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
    "fnObtenListaRestriccionesResult"
})
@XmlRootElement(name = "Fn_ObtenListaRestriccionesResponse")
public class FnObtenListaRestriccionesResponse {

    @XmlElement(name = "Fn_ObtenListaRestriccionesResult")
    protected ArrayOfClsBSRestriccion fnObtenListaRestriccionesResult;

    /**
     * Obtiene el valor de la propiedad fnObtenListaRestriccionesResult.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfClsBSRestriccion }
     *     
     */
    public ArrayOfClsBSRestriccion getFnObtenListaRestriccionesResult() {
        return fnObtenListaRestriccionesResult;
    }

    /**
     * Define el valor de la propiedad fnObtenListaRestriccionesResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfClsBSRestriccion }
     *     
     */
    public void setFnObtenListaRestriccionesResult(ArrayOfClsBSRestriccion value) {
        this.fnObtenListaRestriccionesResult = value;
    }

}
