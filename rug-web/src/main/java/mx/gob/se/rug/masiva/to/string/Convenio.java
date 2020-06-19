//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-548 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.16 at 10:22:20 AM CDT 
//


package mx.gob.se.rug.masiva.to.string;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="acto-convenio" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="fecha-celebracion" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="fecha-terminacion" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="terminos-condiciones" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "convenio")
public class Convenio {

    @XmlAttribute(name = "acto-convenio", required = true)
    protected String actoConvenio;
    @XmlAttribute(name = "fecha-celebracion", required = true)
    protected String fechaCelebracion;
    @XmlAttribute(name = "fecha-terminacion")
    protected String fechaTerminacion;
    @XmlAttribute(name = "terminos-condiciones")
    protected String terminosCondiciones;

    /**
     * Gets the value of the actoConvenio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActoConvenio() {
        return actoConvenio;
    }

    /**
     * Sets the value of the actoConvenio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActoConvenio(String value) {
        this.actoConvenio = value;
    }

    /**
     * Gets the value of the fechaCelebracion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaCelebracion() {
        return fechaCelebracion;
    }

    /**
     * Sets the value of the fechaCelebracion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaCelebracion(String value) {
        this.fechaCelebracion = value;
    }

    /**
     * Gets the value of the fechaTerminacion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaTerminacion() {
        return fechaTerminacion;
    }

    /**
     * Sets the value of the fechaTerminacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaTerminacion(String value) {
        this.fechaTerminacion = value;
    }

    /**
     * Gets the value of the terminosCondiciones property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTerminosCondiciones() {
        return terminosCondiciones;
    }

    /**
     * Sets the value of the terminosCondiciones property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTerminosCondiciones(String value) {
        this.terminosCondiciones = value;
    }

}
