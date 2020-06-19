/*
 * TuEmpresaBaseService.java        11/11/2009
 *
 * Copyright (c) 2009 Secretar�a de Econom�a
 * Alfonso Reyes No. 30 Col. Hip�dromo Condesa C.P. 06140, 
 * Delegaci�n Cuauht�moc, M�xico, D.F.
 * Todos los Derechos Reservados.
 *
 * Este software es confidencial y de uso exclusivo de la
 * Secretar�a de Econom�a.
 *
 */

package mx.gob.se.rug.fwk.service;

import mx.gob.economia.dgi.framework.base.service.AbstractBaseService;
import mx.gob.economia.dgi.framework.security.user.dto.User;

/**
 * Clase base de los servicios de negocio del proyecto tuempresa.
 * 
 * @author Alfonso Esquivel
 * @version 0.1
 * 
 */
public abstract class RugBaseService extends AbstractBaseService {
	private User user;

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

}
