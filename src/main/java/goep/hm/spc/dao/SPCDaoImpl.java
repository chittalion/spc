package goep.hm.spc.dao;

import goep.hm.spc.model.SpcResult;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

/**
 * The DAO implementaion of Sorting and saving of SPC Results
 *
 */
@Component
public class SPCDaoImpl implements ISPCDao {

	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;

	@Override
	public void save(SpcResult spcResult) {
		em.persist(spcResult);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SpcResult> findAll() {
		return em.createQuery("SELECT p FROM spc_result p").getResultList();
	}

}
