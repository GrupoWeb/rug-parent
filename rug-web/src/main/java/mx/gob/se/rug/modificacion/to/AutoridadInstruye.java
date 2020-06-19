package mx.gob.se.rug.modificacion.to;

import java.io.Serializable;

public class AutoridadInstruye implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String anotacionJuez;
	private Integer idTipoTramite;
	private String etiquetaTipoTramite;
	public String getAnotacionJuez() {
		return anotacionJuez;
	}
	public void setAnotacionJuez(String anotacionJuez) {
		this.anotacionJuez = anotacionJuez;
	}
	public Integer getIdTipoTramite() {
		return idTipoTramite;
	}
	public void setIdTipoTramite(Integer idTipoTramite) {
		this.idTipoTramite = idTipoTramite;
	}
	public String getEtiquetaTipoTramite() {
		
		switch(idTipoTramite){
		case 1: etiquetaTipoTramite="Persona que solicita o Autoridad que instruye la Inscripci�n y contenido de la Resoluci�n ";break;
		case 2: etiquetaTipoTramite="Persona que solicita o Autoridad que instruye la Anotaci�n";break;
		case 4: etiquetaTipoTramite="Persona que solicita o Autoridad que instruye la Cancelaci�n y Resoluci�n Judicial ";break;
		case 6: etiquetaTipoTramite="Persona que solicita o Autoridad que instruye la Rectificaci�n y contenido de la Resoluci�n";break;
		case 7: etiquetaTipoTramite="Persona que solicita o Autoridad que instruye la Modificaci�n y contenido de la Resoluci�n";break;
		case 8: etiquetaTipoTramite="Persona que solicita o Autoridad que instruye la Transmisi�n y contenido de la Resoluci�n";break;
		case 9: etiquetaTipoTramite="Persona que solicita o Autoridad que instruye la Renovaci�n o Reducci�n de la Vigencia ";break;
		default:etiquetaTipoTramite ="";break;
		}
		
		return etiquetaTipoTramite;
	}

	
	
	
	
	
	
	
	

}
