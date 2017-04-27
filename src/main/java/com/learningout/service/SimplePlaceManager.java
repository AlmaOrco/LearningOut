package com.learningout.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learningout.domain.Place;
import com.learningout.repository.PlaceDao;

@Component
public class SimplePlaceManager implements PlaceManager {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private PlaceDao placeDao;
	
//	private List<Place> places;
	
	public List<Place> getPlaces() {
		return placeDao.getPlaceList();
	}

//	public void setPlaces(List<Place> places) {
//		this.places = places;
//	}
//
//	public PlaceDao getPlaceDao() {
//		return placeDao;
//	}

	public void setPlaceDao(PlaceDao placeDao) {
		this.placeDao = placeDao;
	}

}
