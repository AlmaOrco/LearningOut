package com.learningout.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.learningout.domain.Place;
import com.learningout.repository.PlaceDao;

@Component
public class SimplePlaceManager implements PlaceManager {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private PlaceDao placeDao;
		
	public List<Place> getPlaces() {
		return placeDao.getPlaceList();
	}

	public void setPlaceDao(PlaceDao placeDao) {
		this.placeDao = placeDao;
	}

	@Override
	public List<Place> searchPlaces(String term) {
		return placeDao.searchPlaces(term);
	}

	@Override
	public Place findPlaceById(long id) {
		return placeDao.findPlaceById(id);
	}

	@Override
	public void savePlace(Place currentPlace) {
		this.placeDao.savePlace(currentPlace);
	}

	@Override
	@Transactional
	public void deletePlace(Place place) throws DataAccessException {
		this.placeDao.deletePlace(place);
	}
}
