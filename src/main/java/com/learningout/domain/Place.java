package com.learningout.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="place")
public class Place implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_place")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idPlace;
	
	@Column(name = "name_place")
	private String namePlace;
	
	private String location;
	private String province;
	
	@Column(name = "postal_code")
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
