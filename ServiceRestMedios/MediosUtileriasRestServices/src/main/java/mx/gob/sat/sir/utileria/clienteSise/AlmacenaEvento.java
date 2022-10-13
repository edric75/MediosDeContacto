
package mx.gob.sat.sir.utileria.clienteSise;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="strNombreAplicacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strNombreModulo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="GravedadEvento" type="{http://tempuri.org/}TipoEvento"/&gt;
 *         &lt;element name="Capa" type="{http://tempuri.org/}CapaEvento"/&gt;
 *         &lt;element name="Usuario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Funcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Numero" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Fuente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "strNombreAplicacion",
    "strNombreModulo",
    "gravedadEvento",
    "capa",
    "usuario",
    "funcion",
    "numero",
    "fuente",
    "descripcion"
})
@XmlRootElement(name = "AlmacenaEvento")
public class AlmacenaEvento {

    protected String strNombreAplicacion;
    protected String strNombreModulo;
    @XmlElement(name = "GravedadEvento", required = true)
    @XmlSchemaType(name = "string")
    protected TipoEvento gravedadEvento;
    @XmlElement(name = "Capa", required = true)
    @XmlSchemaType(name = "string")
    protected CapaEvento capa;
    @XmlElement(name = "Usuario")
    protected String usuario;
    @XmlElement(name = "Funcion")
    protected String funcion;
    @XmlElement(name = "Numero")
    protected String numero;
    @XmlElement(name = "Fuente")
    protected String fuente;
    @XmlElement(name = "Descripcion")
    protected String descripcion;

    /**
     * Obtiene el valor de la propiedad strNombreAplicacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrNombreAplicacion() {
        return strNombreAplicacion;
    }

    /**
     * Define el valor de la propiedad strNombreAplicacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrNombreAplicacion(String value) {
        this.strNombreAplicacion = value;
    }

    /**
     * Obtiene el valor de la propiedad strNombreModulo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrNombreModulo() {
        return strNombreModulo;
    }

    /**
     * Define el valor de la propiedad strNombreModulo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrNombreModulo(String value) {
        this.strNombreModulo = value;
    }

    /**
     * Obtiene el valor de la propiedad gravedadEvento.
     * 
     * @return
     *     possible object is
     *     {@link TipoEvento }
     *     
     */
    public TipoEvento getGravedadEvento() {
        return gravedadEvento;
    }

    /**
     * Define el valor de la propiedad gravedadEvento.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoEvento }
     *     
     */
    public void setGravedadEvento(TipoEvento value) {
        this.gravedadEvento = value;
    }

    /**
     * Obtiene el valor de la propiedad capa.
     * 
     * @return
     *     possible object is
     *     {@link CapaEvento }
     *     
     */
    public CapaEvento getCapa() {
        return capa;
    }

    /**
     * Define el valor de la propiedad capa.
     * 
     * @param value
     *     allowed object is
     *     {@link CapaEvento }
     *     
     */
    public void setCapa(CapaEvento value) {
        this.capa = value;
    }

    /**
     * Obtiene el valor de la propiedad usuario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Define el valor de la propiedad usuario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsuario(String value) {
        this.usuario = value;
    }

    /**
     * Obtiene el valor de la propiedad funcion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFuncion() {
        return funcion;
    }

    /**
     * Define el valor de la propiedad funcion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFuncion(String value) {
        this.funcion = value;
    }

    /**
     * Obtiene el valor de la propiedad numero.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Define el valor de la propiedad numero.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumero(String value) {
        this.numero = value;
    }

    /**
     * Obtiene el valor de la propiedad fuente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFuente() {
        return fuente;
    }

    /**
     * Define el valor de la propiedad fuente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFuente(String value) {
        this.fuente = value;
    }

    /**
     * Obtiene el valor de la propiedad descripcion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Define el valor de la propiedad descripcion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
    }

}
