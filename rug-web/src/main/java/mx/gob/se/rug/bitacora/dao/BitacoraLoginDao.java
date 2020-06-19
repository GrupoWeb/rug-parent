/*
 * BitacoraLoginDao.java        09/09/2009
 *
 * Copyright (c) 2009 Secretaría de Economía
 * Alfonso Reyes No. 30 Col. Hipódromo Condesa C.P. 06140,
 * Delegación Cuauhtémoc, México, D.F.
 * Todos los Derechos Reservados.
 *
 * Este software es confidencial y de uso exclusivo de la
 * Secretaría de Economía.
 *
 */

package mx.gob.se.rug.bitacora.dao;

import mx.gob.economia.dgi.framework.dao.exception.DaoException;
import mx.gob.se.rug.bitacora.dto.BitacoraLogin;

public interface BitacoraLoginDao {
	public boolean bitacoraLogin(BitacoraLogin bitacoraLogin)
			throws DaoException;
}
