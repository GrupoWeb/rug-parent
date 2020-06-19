
package gt.gob.rgm.rug.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.7-b01-
 * Generated source version: 2.1
 * 
 */
@WebService(name = "PagoServicePortType", targetNamespace = "https://rug.rgm.gob.gt/services/rug-rgm-web-service")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface PagoServicePortType {


    /**
     * 
     * @param getUsuarioRGMRequest
     * @return
     *     returns gt.gob.rgm.rug.ws.GetUsuarioRGMResponse
     */
    @WebMethod(action = "getUsuarioRGM")
    @WebResult(name = "getUsuarioRGMResponse", targetNamespace = "https://rug.rgm.gob.gt/services/rug-rgm-web-service", partName = "getUsuarioRGMResponse")
    public GetUsuarioRGMResponse getUsuarioRGM(
        @WebParam(name = "getUsuarioRGMRequest", targetNamespace = "https://rug.rgm.gob.gt/services/rug-rgm-web-service", partName = "getUsuarioRGMRequest")
        GetUsuarioRGMRequest getUsuarioRGMRequest);

    /**
     * 
     * @param setBoletaRGMRequest
     * @return
     *     returns gt.gob.rgm.rug.ws.SetBoletaRGMResponse
     */
    @WebMethod(action = "getUsuarioRGM")
    @WebResult(name = "setBoletaRGMResponse", targetNamespace = "https://rug.rgm.gob.gt/services/rug-rgm-web-service", partName = "setBoletaRGMResponse")
    public SetBoletaRGMResponse setBoletaRGM(
        @WebParam(name = "setBoletaRGMRequest", targetNamespace = "https://rug.rgm.gob.gt/services/rug-rgm-web-service", partName = "setBoletaRGMRequest")
        SetBoletaRGMRequest setBoletaRGMRequest);

    /**
     * 
     * @param revertBoletaRGMRequest
     * @return
     *     returns gt.gob.rgm.rug.ws.RevertBoletaRGMResponse
     */
    @WebMethod(action = "getUsuarioRGM")
    @WebResult(name = "revertBoletaRGMResponse", targetNamespace = "https://rug.rgm.gob.gt/services/rug-rgm-web-service", partName = "revertBoletaRGMResponse")
    public RevertBoletaRGMResponse revertBoletaRGM(
        @WebParam(name = "revertBoletaRGMRequest", targetNamespace = "https://rug.rgm.gob.gt/services/rug-rgm-web-service", partName = "revertBoletaRGMRequest")
        RevertBoletaRGMRequest revertBoletaRGMRequest);

    /**
     * 
     * @param confirmBoletaRGMRequest
     * @return
     *     returns gt.gob.rgm.rug.ws.ConfirmBoletaRGMResponse
     */
    @WebMethod(action = "getUsuarioRGM")
    @WebResult(name = "confirmBoletaRGMResponse", targetNamespace = "https://rug.rgm.gob.gt/services/rug-rgm-web-service", partName = "confirmBoletaRGMResponse")
    public ConfirmBoletaRGMResponse confirmBoletaRGM(
        @WebParam(name = "confirmBoletaRGMRequest", targetNamespace = "https://rug.rgm.gob.gt/services/rug-rgm-web-service", partName = "confirmBoletaRGMRequest")
        ConfirmBoletaRGMRequest confirmBoletaRGMRequest);

}
