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
 *       &lt;attribute name="id-nacionalidad" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="tipo-persona" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="denominacion-razon-social" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="apellido-paterno" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="apellido-materno" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="curp" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="folio-electronico" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "otorgante")
public class Otorgante {

    @XmlAttribute(name = "id-nacionalidad", required = true)
    protected String idNacionalidad;
    @XmlAttribute(name = "tipo-persona", required = true)
    protected String tipoPersona;
    @XmlAttribute(name = "denominacion-razon-social")
    protected String denominacionRazonSocial;
    @XmlAttribute
    protected String nombre;
    @XmlAttribute(name = "apellido-paterno")
    protected String apellidoPaterno;
    @XmlAttribute(name = "apellido-materno")
    protected String apellidoMaterno;
    @XmlAttribute
    protected String curp;
    @XmlAttribute(name = "folio-electronico")
    protected String folioElectronico;

    /**
     * Gets the value of the idNacionalidad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdNacionalidad() {
        return idNacionalidad;
    }

    /**
     * Sets the value of the idNacionalidad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdNacionalidad(String value) {
        this.idNacionalidad = value;
    }

    /**
     * Gets the value of the tipoPersona property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoPersona() {
        return tipoPersona;
    }

    /**
     * Sets the value of the tipoPersona property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoPersona(String value) {
        this.tipoPersona = value;
    }

    /**
     * Gets the value of the denominacionRazonSocial property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDenominacionRazonSocial() {
        return denominacionRazonSocial;
    }

    /**
     * Sets the value of the denominacionRazonSocial property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDenominacionRazonSocial(String value) {
        this.denominacionRazonSocial = value;
    }

    /**
     * Gets the value of the nombre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets the value of the nombre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Gets the value of the apellidoPaterno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Sets the value of the apellidoPaterno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApellidoPaterno(String value) {
        this.apellidoPaterno = value;
    }

    /**
     * Gets the value of the apellidoMaterno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Sets the value of the apellidoMaterno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApellidoMaterno(String value) {
        this.apellidoMaterno = value;
    }

    /**
     * Gets the value of the curp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurp() {
        return curp;
    }

    /**
     * Sets the value of the curp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurp(String value) {
        this.curp = value;
    }

    /**
     * Gets the value of the folioElectronico property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFolioElectronico() {
        return folioElectronico;
    }

    /**
     * Sets the value of the folioElectronico property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFolioElectronico(String value) {
        this.folioElectronico = value;
    }

}
