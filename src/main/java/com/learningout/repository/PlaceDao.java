package com.learningout.repository;

import java.util.List;

import com.learningout.domain.Place;

public interface PlaceDao {

    public List<Place> getPlaceList();

    public void savePlace(Place place);

}
