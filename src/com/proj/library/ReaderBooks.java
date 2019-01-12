package com.proj.library;

public class ReaderBooks {
	private String firstName;
	private String lastName;
	private String city;
	private String street;
	private Integer nrHouse;
	private Integer nrFlat;
	private String title;
	private Long time;
	
	public ReaderBooks(String firstName, String lastName, String city, String street, Integer nrHouse, Integer nrFlat,
			String title, Long time) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.street = street;
		this.nrHouse = nrHouse;
		this.nrFlat = nrFlat;
		this.title = title;
		this.time = time;
	}

	public String getImie() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getNazwisko() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiasto() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getUlica() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Integer getNrdomu() {
		return nrHouse;
	}

	public void setNrHouse(Integer nrHouse) {
		this.nrHouse = nrHouse;
	}

	public Integer getNrmieszkania() {
		return nrFlat;
	}

	public void setNrFlat(Integer nrFlat) {
		this.nrFlat = nrFlat;
	}

	public String getTytul() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getCzas() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}
	
	
}
