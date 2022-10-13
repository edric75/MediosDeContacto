
package mx.gob.sat.sir.utileria.clienteSise;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayOfClsBSModulo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfClsBSModulo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="clsBSModulo" type="{http://tempuri.org/}clsBSModulo" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfClsBSModulo", propOrder = {
    "clsBSModulo"
})
public class ArrayOfClsBSModulo {

    @XmlElement(nillable = true)
    protected List<ClsBSModulo> clsBSModulo;

    /**
     * Gets the value of the clsBSModulo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the clsBSModulo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClsBSModulo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClsBSModulo }
     * 
     * 
     */
    public List<ClsBSModulo> getClsBSModulo() {
        if (clsBSModulo == null) {
            clsBSModulo = new ArrayList<ClsBSModulo>();
        }
        return this.clsBSModulo;
    }

}
