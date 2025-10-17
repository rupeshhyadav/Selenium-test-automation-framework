package com.ui.pojos;

public class AddressPojo {
	private String address1;
	private String city;
	private String state;
	private String postalCode;
	private String homePhoneNumber;
	private String alias;

	public AddressPojo(String address1, String city, String state, String postalCode, String homePhoneNumber,
			String alias) {
		super();
		this.address1 = address1;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.homePhoneNumber = homePhoneNumber;
		this.alias = alias;
	}

	public String getAddress1() {
		return address1;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getHomePhoneNumber() {
		return homePhoneNumber;
	}

	public String getAlias() {
		return alias;
	}

}
