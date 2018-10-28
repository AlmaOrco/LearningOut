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
    	System.out.println("Obteniendo todos los lugares.");
		return em.createQuery("select p from Place p order by p.idPlace").getResultList();
	}
    
    @Transactional(readOnly = false)
    public void savePlace(Place place) {
        if (place.getIdPlace() == 0) {
            this.em.persist(place);
        } else {
            this.em.merge(place);
        }
	}

    @Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<Place> searchPlaces(String term) {
    	System.out.println("Obteniendo lugares filtrados.");
		List<Place> placesList = em.createQuery("select p from Place p where p.namePlace like '%" + term + "%'").getResultList();
		return placesList;
	}

    @Transactional(readOnly = true)
    public Place findPlaceById(long id) {
    	System.out.println("Obteniendo lugar por id. Id: " + id);
		return em.createQuery("select p from Place p where p.idPlace = " + id, Place.class).getSingleResult();
	}

	public void deletePlace(Place place) {
		long placeId = place.getIdPlace();
		this.em.createQuery("DELETE FROM Place p WHERE idPlace=" + placeId).executeUpdate();
		if (em.contains(place)) {
			em.remove(place);
		}
	}

    
}
