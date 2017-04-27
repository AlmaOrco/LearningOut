package com.learningout.domain;

import java.io.Serializable;

public class PlaceDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private long idPlace;
	private String namePlace;
	private String location;
	private String province;
	private int postalCode;
	// TODO añadir lista de imágenes y main_image.

	public long getIdPlace() {
		return idPlace;
	}

	public void setIdPlace(long idPlace) {
		this.idPlace = idPlace;
	}

	public String getNamePlace() {
		return namePlace;
	}

	public void setNamePlace(String namePlace) {
		this.namePlace = namePlace;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	
	//TODO toString con el formato que vayamos a necesitar en Angular.

}
