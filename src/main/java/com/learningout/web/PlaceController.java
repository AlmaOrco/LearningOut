package com.learningout.web;

import java.util.ArrayList;
import java.util.Collection;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.learningout.domain.Place;
import com.learningout.service.BindingErrorsResponse;
import com.learningout.service.PlaceManager;

@RestController
@CrossOrigin(exposedHeaders = "errors, content-type")
//@RequestMapping("api/places")
public class PlaceController {

    protected final Log logger = LogFactory.getLog(getClass());
    
    @Autowired
    private PlaceManager placeDao;

    @RequestMapping(value = "api/places", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Collection<Place>> getAllPlaces(){
    	Collection<Place> places = new ArrayList<Place>();
    	places.addAll(this.placeDao.getPlaces());
    	if(places.isEmpty()){
    		return new ResponseEntity<Collection<Place>>(HttpStatus.NOT_FOUND);
    	}
    	return new ResponseEntity<Collection<Place>>(places, HttpStatus.OK);
    }
    
    @RequestMapping(value = "api/places/{placeId}.json", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Place> getPlace(@PathVariable("placeId") long placeId){
    	Place place = new Place();
    	place = this.placeDao.findPlaceById(placeId);
    	if(place == null){
    		return new ResponseEntity<Place>(HttpStatus.NOT_FOUND);
    	}
    	return new ResponseEntity<Place>(place, HttpStatus.OK);
    }
    
    @RequestMapping(value = "api/places/search.json", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Collection<Place>> getPlace(@RequestParam(value = "term") String term){
    	Collection<Place> placesList = new ArrayList<Place>();
    	placesList.addAll(this.placeDao.searchPlaces(term));
    	
    	// In this occasion this is not recomended because HttpStatus.NOT_FOUND, without headers cause problems with our error handler in Angular.
    	// It's better for this function (in-time filter) to send an empty Array than NOT_FOUND status.
//    	if(placesList.isEmpty()){
//    		return new ResponseEntity<Collection<Place>>(HttpStatus.NOT_FOUND);
//    	}
    	return new ResponseEntity<Collection<Place>>(placesList, HttpStatus.OK);
    }

    @RequestMapping(value = "api/places/add/place.json", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Place> addPlace(@RequestBody @Valid Place place, BindingResult bindingResult, UriComponentsBuilder ucBuilder){
		BindingErrorsResponse errors = new BindingErrorsResponse();
		HttpHeaders headers = new HttpHeaders();
		if(bindingResult.hasErrors() || (place == null)){
			errors.addAllErrors(bindingResult);
			headers.add("errors", errors.toJSON());
			return new ResponseEntity<Place>(headers, HttpStatus.BAD_REQUEST);
		}
		this.placeDao.savePlace(place);
		headers.setLocation(ucBuilder.path("/api/place/{id}").buildAndExpand(place.getIdPlace()).toUri());
		return new ResponseEntity<Place>(place, headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "api/places/update/{placeId}.json", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Place> updatePlace(@PathVariable("placeId") long placeId, @RequestBody @Valid Place place, BindingResult bindingResult, UriComponentsBuilder ucBuilder){
    	    	
		BindingErrorsResponse errors = new BindingErrorsResponse();
		HttpHeaders headers = new HttpHeaders();
		if(bindingResult.hasErrors() || (place == null)){
			errors.addAllErrors(bindingResult);
			headers.add("errors", errors.toJSON());
			return new ResponseEntity<Place>(headers, HttpStatus.BAD_REQUEST);
		}
		Place currentPlace = this.placeDao.findPlaceById(placeId);
		if(currentPlace == null){
			return new ResponseEntity<Place>(HttpStatus.NOT_FOUND);
		}
		currentPlace.setProvince(place.getProvince());
		currentPlace.setNamePlace(place.getNamePlace());
		currentPlace.setLocation(place.getLocation());
		currentPlace.setPostalCode(place.getPostalCode());
		this.placeDao.savePlace(currentPlace);
		return new ResponseEntity<Place>(currentPlace, HttpStatus.NO_CONTENT);
    }
    
	@RequestMapping(value = "api/places/delete/{placeId}.json", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@Transactional
	public ResponseEntity<Void> deletePlace(@PathVariable("placeId") long placeId){
		System.out.println("Entrando en Delete");
		Place place = this.placeDao.findPlaceById(placeId);
		if(place == null){
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		this.placeDao.deletePlace(place);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
    
	public void setPlaceDao(PlaceManager placeDao) {
		this.placeDao = placeDao;
	}
    
}