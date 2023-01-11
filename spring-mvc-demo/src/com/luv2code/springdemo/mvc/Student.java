package com.luv2code.springdemo.mvc;

import java.util.LinkedHashMap;

import com.luv2code.springdemo.mvc.validation.CourseCode;

public class Student {
	
	public String firstName;
	public String lastName;
	public String country;

	private LinkedHashMap<String, String> countryOptions;
	private LinkedHashMap<String, String> favoriteLanguageOptions;
	
	public String favoriteLanguage;
	public String favoriteDatabase;
	
	public String[] operatingSystems;
	
	@CourseCode(value={"TOPS", "LUV", "e5Core"}, message="must start with TOPS or LUV or e5Core")
	public String courseCode;

	public Student() {
		
		// populate country options: using ISO country code 
		countryOptions = new LinkedHashMap<>();
		countryOptions.put("BR","Brazil");
		countryOptions.put("FR","France");
		countryOptions.put("DE","Germany");
		countryOptions.put("IN","India");
		countryOptions.put("US","United States of America");
		
		// populate language options
		favoriteLanguageOptions = new LinkedHashMap<>();
		
		favoriteLanguageOptions.put("C#", "C#");
		favoriteLanguageOptions.put("Java", "Java");
		favoriteLanguageOptions.put("Cobol", "Cobol");
		favoriteLanguageOptions.put("PhP", "PhP");
		
	}
	

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}
	
	public String getFavoriteDatabase() {
		return favoriteDatabase;
	}

	public void setFavoriteDatabase(String favoriteDatabase) {
		this.favoriteDatabase = favoriteDatabase;
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}
	
	public LinkedHashMap<String, String> getFavoriteLanguageOptions() {
		return favoriteLanguageOptions;
	}
	
	public String[] getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}
}
