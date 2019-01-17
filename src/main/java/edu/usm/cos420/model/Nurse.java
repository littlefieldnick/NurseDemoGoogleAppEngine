package edu.usm.cos420.model;


import java.io.Serializable;

public class Nurse implements Serializable{
    private int id;
    private String firstName;
    private String lastName;
    private String countryCode;
    
    public int getId() {
  		return id;
  	}
  	public void setId(int id) {
  		this.id = id;
  	}
  	public String getFirstName() {
  		return firstName;
  	}
  	public void setFirstName(String firstName) {
  		this.firstName = firstName;
  	}
  	public String getLastName() {
  		return lastName;
  	}
  	public void setLastName(String lastName) {
  		this.lastName = lastName;
  	}
  	public String getCountryCode() {
  		return countryCode;
  	}
  	public void setCountryCode(String countryCode) {
  		this.countryCode = countryCode;
  	}
  	
  	public String toString() {
  		return "Nurse : " + getId() + " " + getFirstName() + " " + getLastName() + " " + getCountryCode();
  	}
 }
