package gt.gob.rgm.adm.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import gt.gob.rgm.adm.model.RugContrato;

public class RugContratoRepository {
	@PersistenceContext
	EntityManager em;
	
	public void save(RugContrato contrato) {
		em.persist(contrato);
	}
}
