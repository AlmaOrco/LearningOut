package com.learningout.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.learningout.domain.Place;

@Repository(value="placeDao")
public class JPAPlaceDao implements PlaceDao {

	private EntityManager em = null;
	
	 /*
     * Sets the entity manager.
     */
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
	
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
	public List<Place> getPlaceList() {
		return em.createQuery("select p from Place p order by p.idPlace").getResultList();
	}
    
    @Transactional(readOnly = false)
	public void savePlace(Place place) {
    	em.merge(place);
	}

}
