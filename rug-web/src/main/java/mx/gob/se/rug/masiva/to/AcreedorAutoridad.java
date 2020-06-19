//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-548 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.16 at 01:24:04 PM CDT 
//


package mx.gob.se.rug.masiva.to;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *       &lt;attribute name="tipo-persona" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="id-nacionalidad" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *       &lt;attribute name="denominacion-razon-social" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="apellido-paterno" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="apellido-materno" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="telefono" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *       &lt;attribute name="telefono-extension" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" />
 *       &lt;attribute name="correo-electronico" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="rfc" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="id-pais-residencia" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *       &lt;attribute name="calle" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="numero-exterior" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="numero-interior" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="id-colonia" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *       &lt;attribute name="id-localidad" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *       &lt;attribute name="domicilio-extranjero-uno" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="domicilio-extranjero-dos" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="poblacion" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="zona-postal" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "acreedor-autoridad")
public class AcreedorAutoridad {

    @XmlAttribute(name = "tipo-persona", required = true)
    protected String tipoPersona;
    @XmlAttribute(name = "id-nacionalidad", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger idNacionalidad;
    @XmlAttribute(name = "denominacion-razon-social")
    protected String denominacionRazonSocial;
    @XmlAttribute
    protected String nombre;
    @XmlAttribute(name = "apellido-paterno")
    protected String apellidoPaterno;
    @XmlAttribute(name = "apellido-materno")
    protected String apellidoMaterno;
    @XmlAttribute(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger telefono;
    @XmlAttribute(name = "telefono-extension")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger telefonoExtension;
    @XmlAttribute(name = "correo-electronico")
    protected String correoElectronico;
    @XmlAttribute
    protected String rfc;
    @XmlAttribute(name = "id-pais-residencia", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger idPaisResidencia;
    @XmlAttribute
    protected String calle;
    @XmlAttribute(name = "numero-exterior")
    protected String numeroExterior;
    @XmlAttribute(name = "numero-interior")
    protected String numeroInterior;
    @XmlAttribute(name = "id-colonia")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger idColonia;
    @XmlAttribute(name = "id-localidad")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger idLocalidad;
    @XmlAttribute(name = "domicilio-extranjero-uno")
    protected String domicilioExtranjeroUno;
    @XmlAttribute(name = "domicilio-extranjero-dos")
    protected String domicilioExtranjeroDos;
    @XmlAttribute
    protected String poblacion;
    @XmlAttribute(name = "zona-postal")
    protected String zonaPostal;

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
     * Gets the value of the idNacionalidad property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIdNacionalidad() {
        return idNacionalidad;
    }

    /**
     * Sets the value of the idNacionalidad property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIdNacionalidad(BigInteger value) {
        this.idNacionalidad = value;
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
     * Gets the value of the telefono property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTelefono() {
        return telefono;
    }

    /**
     * Sets the value of the telefono property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTelefono(BigInteger value) {
        this.telefono = value;
    }

    /**
     * Gets the value of the telefonoExtension property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTelefonoExtension() {
        return telefonoExtension;
    }

    /**
     * Sets the value of the telefonoExtension property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTelefonoExtension(BigInteger value) {
        this.telefonoExtension = value;
    }

    /**
     * Gets the value of the correoElectronico property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * Sets the value of the correoElectronico property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorreoElectronico(String value) {
        this.correoElectronico = value;
    }

    /**
     * Gets the value of the rfc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * Sets the value of the rfc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRfc(String value) {
        this.rfc = value;
    }

    /**
     * Gets the value of the idPaisResidencia property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIdPaisResidencia() {
        return idPaisResidencia;
    }

    /**
     * Sets the value of the idPaisResidencia property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIdPaisResidencia(BigInteger value) {
        this.idPaisResidencia = value;
    }

    /**
     * Gets the value of the calle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Sets the value of the calle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCalle(String value) {
        this.calle = value;
    }

    /**
     * Gets the value of the numeroExterior property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroExterior() {
        return numeroExterior;
    }

    /**
     * Sets the value of the numeroExterior property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroExterior(String value) {
        this.numeroExterior = value;
    }

    /**
     * Gets the value of the numeroInterior property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroInterior() {
        return numeroInterior;
    }

    /**
     * Sets the value of the numeroInterior property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroInterior(String value) {
        this.numeroInterior = value;
    }

    /**
     * Gets the value of the idColonia property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIdColonia() {
        return idColonia;
    }

    /**
     * Sets the value of the idColonia property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIdColonia(BigInteger value) {
        this.idColonia = value;
    }

    /**
     * Gets the value of the idLocalidad property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIdLocalidad() {
        return idLocalidad;
    }

    /**
     * Sets the value of the idLocalidad property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIdLocalidad(BigInteger value) {
        this.idLocalidad = value;
    }

    /**
     * Gets the value of the domicilioExtranjeroUno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDomicilioExtranjeroUno() {
        return domicilioExtranjeroUno;
    }

    /**
     * Sets the value of the domicilioExtranjeroUno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDomicilioExtranjeroUno(String value) {
        this.domicilioExtranjeroUno = value;
    }

    /**
     * Gets the value of the domicilioExtranjeroDos property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDomicilioExtranjeroDos() {
        return domicilioExtranjeroDos;
    }

    /**
     * Sets the value of the domicilioExtranjeroDos property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDomicilioExtranjeroDos(String value) {
        this.domicilioExtranjeroDos = value;
    }

    /**
     * Gets the value of the poblacion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPoblacion() {
        return poblacion;
    }

    /**
     * Sets the value of the poblacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPoblacion(String value) {
        this.poblacion = value;
    }

    /**
     * Gets the value of the zonaPostal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZonaPostal() {
        return zonaPostal;
    }

    /**
     * Sets the value of the zonaPostal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZonaPostal(String value) {
        this.zonaPostal = value;
    }

}
