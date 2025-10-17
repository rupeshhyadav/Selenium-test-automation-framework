package com.ui.pojos;

public class InvalidUser {
	private String invalidEmailAddress;
	private String invalidPassword;

	public InvalidUser(String invalidEmailAddress, String invalidPassword) {
		super();
		this.invalidEmailAddress = invalidEmailAddress;
		this.invalidPassword = invalidPassword;
	}

	public String getInvalidEmailAddress() {
		return invalidEmailAddress;
	}

	public void setInvalidEmailAddress(String invalidEmailAddress) {
		this.invalidEmailAddress = invalidEmailAddress;
	}

	public String getInvalidPassword() {
		return invalidPassword;
	}

	public void setInvalidPassword(String invalidPassword) {
		this.invalidPassword = invalidPassword;
	}
	

}
