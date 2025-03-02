package com.mtoaima.internationalization_and_versioning.entity;

public class Name {
	private String firstName;
	private String SecondName;
	
	public Name(String firstName, String SecondName ) {
		super();
		this.firstName = firstName;
		this.SecondName = SecondName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getSecondName() {
		return SecondName;
	}

	
}
