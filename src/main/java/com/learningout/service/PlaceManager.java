package com.learningout.service;

import java.io.Serializable;
import java.util.List;

import com.learningout.domain.Place;

public interface PlaceManager extends Serializable{
	public List<Place> getPlaces();

	public List<Place> searchPlaces(String term);

	public Place findPlaceById(long placeId);

	public void savePlace(Place currentPlace);

	public void deletePlace(Place place);
}
