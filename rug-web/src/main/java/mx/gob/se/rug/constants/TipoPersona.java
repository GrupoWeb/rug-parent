package mx.gob.se.rug.constants;

/*
 * TipoPersona.java        04/05/2009
 *
 * Copyright (c) 2009 Secretar�a de Econom�a
 * Alfonso Reyes No. 30 Col. Hip�dromo Condesa C.P. 06140, 
 * Delegaci�n Cuauht�moc, M�xico, D.F.
 * Todos los Derechos Reservados.
 *
 * Este software es confidencial y contiene informaci�n perteneciente
 * a la Secretar�a de Econom�a.
 * 
 */


/**
 * 
 * 
 * @version 0.1
 * @author Alfonso Esquivel
 * 
 */
public enum TipoPersona {
	FISICA("PF"), MORAL("PM");

	private TipoPersona(String id) {
		this.id = id;
	}

	private String id;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

}

