package com.learningout.service;

import java.io.Serializable;
import java.util.List;

import com.learningout.domain.Place;

public interface PlaceManager extends Serializable{
	public List<Place> getPlaces();
}
