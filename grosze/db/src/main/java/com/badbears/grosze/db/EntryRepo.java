package com.badbears.grosze.db;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.badbears.grosze.db.model.Entry;

@Repository
public class EntryRepo {

	@PersistenceContext(unitName="groszePU")
	private EntityManager em;
		
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void save(Entry entry) {
		em.persist(entry);
	}
	
	public boolean isInRepo(Long itemId, BigDecimal cost) {
		
		Query q = em.createQuery("SELECT e FROM Entry e WHERE e.itemId = ?1 AND e.cost = ?2");
		q.setParameter(1, itemId);
		q.setParameter(2, cost);
		@SuppressWarnings("unchecked")
		List<Entry> results = (List<Entry>) q.getResultList();				
		return results.size() == 1;
	}	
	
	public List<Entry> find(Long itemId) {
		Query q = em.createQuery("SELECT e FROM Entry e WHERE e.itemId = ?1");
		q.setParameter(1, itemId);
		@SuppressWarnings("unchecked")
		List<Entry> results = (List<Entry>) q.getResultList();				
		return results;
	}	
	
}
