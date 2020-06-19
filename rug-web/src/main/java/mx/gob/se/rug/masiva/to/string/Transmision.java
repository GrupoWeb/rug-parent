//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-548 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.16 at 10:22:20 AM CDT 
//


package mx.gob.se.rug.masiva.to.string;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *       &lt;sequence>
 *         &lt;element ref="{carga-masiva}persona-solicita-autoridad-instruye-asiento" minOccurs="0"/>
 *         &lt;element ref="{carga-masiva}acreedor" minOccurs="0"/>
 *         &lt;element ref="{carga-masiva}eliminar-partes-transmision" minOccurs="0"/>
 *         &lt;element ref="{carga-masiva}otorgante" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{carga-masiva}acreedor-adicional" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{carga-masiva}convenio"/>
 *         &lt;element ref="{carga-masiva}identificador-garantia"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "personaSolicitaAutoridadInstruyeAsiento",
    "acreedor",
    "eliminarPartesTransmision",
    "otorgante",
    "acreedorAdicional",
    "convenio",
    "identificadorGarantia"
})
@XmlRootElement(name = "transmision")
public class Transmision {

    @XmlElement(name = "persona-solicita-autoridad-instruye-asiento")
    protected PersonaSolicitaAutoridadInstruyeAsiento personaSolicitaAutoridadInstruyeAsiento;
    protected Acreedor acreedor;
    @XmlElement(name = "eliminar-partes-transmision")
    protected EliminarPartesTransmision eliminarPartesTransmision;
    protected List<Otorgante> otorgante;
    @XmlElement(name = "acreedor-adicional")
    protected List<AcreedorAdicional> acreedorAdicional;
    @XmlElement(required = true)
    protected Convenio convenio;
    @XmlElement(name = "identificador-garantia", required = true)
    protected IdentificadorGarantia identificadorGarantia;

    /**
     * Gets the value of the personaSolicitaAutoridadInstruyeAsiento property.
     * 
     * @return
     *     possible object is
     *     {@link PersonaSolicitaAutoridadInstruyeAsiento }
     *     
     */
    public PersonaSolicitaAutoridadInstruyeAsiento getPersonaSolicitaAutoridadInstruyeAsiento() {
        return personaSolicitaAutoridadInstruyeAsiento;
    }

    /**
     * Sets the value of the personaSolicitaAutoridadInstruyeAsiento property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonaSolicitaAutoridadInstruyeAsiento }
     *     
     */
    public void setPersonaSolicitaAutoridadInstruyeAsiento(PersonaSolicitaAutoridadInstruyeAsiento value) {
        this.personaSolicitaAutoridadInstruyeAsiento = value;
    }

    /**
     * Gets the value of the acreedor property.
     * 
     * @return
     *     possible object is
     *     {@link Acreedor }
     *     
     */
    public Acreedor getAcreedor() {
        return acreedor;
    }

    /**
     * Sets the value of the acreedor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Acreedor }
     *     
     */
    public void setAcreedor(Acreedor value) {
        this.acreedor = value;
    }

    /**
     * Gets the value of the eliminarPartesTransmision property.
     * 
     * @return
     *     possible object is
     *     {@link EliminarPartesTransmision }
     *     
     */
    public EliminarPartesTransmision getEliminarPartesTransmision() {
        return eliminarPartesTransmision;
    }

    /**
     * Sets the value of the eliminarPartesTransmision property.
     * 
     * @param value
     *     allowed object is
     *     {@link EliminarPartesTransmision }
     *     
     */
    public void setEliminarPartesTransmision(EliminarPartesTransmision value) {
        this.eliminarPartesTransmision = value;
    }

    /**
     * Gets the value of the otorgante property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the otorgante property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOtorgante().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Otorgante }
     * 
     * 
     */
    public List<Otorgante> getOtorgante() {
        if (otorgante == null) {
            otorgante = new ArrayList<Otorgante>();
        }
        return this.otorgante;
    }

    /**
     * Gets the value of the acreedorAdicional property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the acreedorAdicional property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAcreedorAdicional().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AcreedorAdicional }
     * 
     * 
     */
    public List<AcreedorAdicional> getAcreedorAdicional() {
        if (acreedorAdicional == null) {
            acreedorAdicional = new ArrayList<AcreedorAdicional>();
        }
        return this.acreedorAdicional;
    }

    /**
     * Gets the value of the convenio property.
     * 
     * @return
     *     possible object is
     *     {@link Convenio }
     *     
     */
    public Convenio getConvenio() {
        return convenio;
    }

    /**
     * Sets the value of the convenio property.
     * 
     * @param value
     *     allowed object is
     *     {@link Convenio }
     *     
     */
    public void setConvenio(Convenio value) {
        this.convenio = value;
    }

    /**
     * Gets the value of the identificadorGarantia property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificadorGarantia }
     *     
     */
    public IdentificadorGarantia getIdentificadorGarantia() {
        return identificadorGarantia;
    }

    /**
     * Sets the value of the identificadorGarantia property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificadorGarantia }
     *     
     */
    public void setIdentificadorGarantia(IdentificadorGarantia value) {
        this.identificadorGarantia = value;
    }

}
