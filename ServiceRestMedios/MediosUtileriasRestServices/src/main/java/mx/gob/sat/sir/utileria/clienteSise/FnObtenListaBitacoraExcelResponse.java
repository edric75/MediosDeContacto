
package mx.gob.sat.sir.utileria.clienteSise;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
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
 *         &lt;element name="Fn_ObtenListaBitacoraExcelResult" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;any maxOccurs="2" minOccurs="2"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
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
    "fnObtenListaBitacoraExcelResult"
})
@XmlRootElement(name = "Fn_ObtenListaBitacoraExcelResponse")
public class FnObtenListaBitacoraExcelResponse {

    @XmlElement(name = "Fn_ObtenListaBitacoraExcelResult")
    protected FnObtenListaBitacoraExcelResponse.FnObtenListaBitacoraExcelResult fnObtenListaBitacoraExcelResult;

    /**
     * Obtiene el valor de la propiedad fnObtenListaBitacoraExcelResult.
     * 
     * @return
     *     possible object is
     *     {@link FnObtenListaBitacoraExcelResponse.FnObtenListaBitacoraExcelResult }
     *     
     */
    public FnObtenListaBitacoraExcelResponse.FnObtenListaBitacoraExcelResult getFnObtenListaBitacoraExcelResult() {
        return fnObtenListaBitacoraExcelResult;
    }

    /**
     * Define el valor de la propiedad fnObtenListaBitacoraExcelResult.
     * 
     * @param value
     *     allowed object is
     *     {@link FnObtenListaBitacoraExcelResponse.FnObtenListaBitacoraExcelResult }
     *     
     */
    public void setFnObtenListaBitacoraExcelResult(FnObtenListaBitacoraExcelResponse.FnObtenListaBitacoraExcelResult value) {
        this.fnObtenListaBitacoraExcelResult = value;
    }


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
     *         &lt;any maxOccurs="2" minOccurs="2"/&gt;
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
        "any"
    })
    public static class FnObtenListaBitacoraExcelResult {

        @XmlAnyElement(lax = true)
        protected List<Object> any;

        /**
         * Gets the value of the any property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the any property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAny().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Object }
         * 
         * 
         */
        public List<Object> getAny() {
            if (any == null) {
                any = new ArrayList<Object>();
            }
            return this.any;
        }

    }

}
