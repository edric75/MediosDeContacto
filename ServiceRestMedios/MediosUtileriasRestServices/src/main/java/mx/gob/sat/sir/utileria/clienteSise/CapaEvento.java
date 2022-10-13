
package mx.gob.sat.sir.utileria.clienteSise;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para CapaEvento.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="CapaEvento"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Datos"/&gt;
 *     &lt;enumeration value="Negocio"/&gt;
 *     &lt;enumeration value="ServicioWeb"/&gt;
 *     &lt;enumeration value="Presentacion"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "CapaEvento")
@XmlEnum
public enum CapaEvento {

    @XmlEnumValue("Datos")
    DATOS("Datos"),
    @XmlEnumValue("Negocio")
    NEGOCIO("Negocio"),
    @XmlEnumValue("ServicioWeb")
    SERVICIO_WEB("ServicioWeb"),
    @XmlEnumValue("Presentacion")
    PRESENTACION("Presentacion");
    private final String value;

    CapaEvento(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CapaEvento fromValue(String v) {
        for (CapaEvento c: CapaEvento.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
