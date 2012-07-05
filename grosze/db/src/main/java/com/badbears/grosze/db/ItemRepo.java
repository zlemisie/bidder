package com.badbears.grosze.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.badbears.grosze.db.model.Entry;
import com.badbears.grosze.db.model.Item;

@Repository
public class ItemRepo {

	@PersistenceContext(unitName="groszePU")
	private EntityManager em;
		
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void save(Item item) {
		em.persist(item);
	}
	
	public boolean isInRepo(Long itemId) {
		Query q = em.createQuery("SELECT i FROM Item i WHERE i.itemId = ?1");
		q.setParameter(1, itemId);
		@SuppressWarnings("unchecked")
		List<Entry> results = (List<Entry>) q.getResultList();				
		return results.size() == 1;
	}
	
	public Item find(Long itemId) {
		Query q = em.createQuery("SELECT i FROM Item i WHERE i.itemId = ?1");
		q.setParameter(1, itemId);
		Item result = (Item)q.getSingleResult();				
		return result;
	}
	
}
