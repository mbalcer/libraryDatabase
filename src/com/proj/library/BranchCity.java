package com.proj.library;

import java.math.BigDecimal;

public class BranchCity {
	private String nameBranch;
	private String city;
	private String street;
	private Integer numberHouse;
	private String firstName;
	private String lastName;
	private BigDecimal salary;
	
	public BranchCity(String nameBranch, String city, String street, Integer numberHouse, String firstName,
			String lastName, BigDecimal salary) {
		this.nameBranch = nameBranch;
		this.city = city;
		this.street = street;
		this.numberHouse = numberHouse;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}

	public String getNazwa() {
		return nameBranch;
	}

	public void setNameBranch(String nameBranch) {
		this.nameBranch = nameBranch;
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

	public Integer getNumer() {
		return numberHouse;
	}

	public void setNumberHouse(Integer numberHouse) {
		this.numberHouse = numberHouse;
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

	public BigDecimal getWynagrodzenie() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
}
