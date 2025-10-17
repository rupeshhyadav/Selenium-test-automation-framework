package com.utility;

import com.github.javafaker.Faker;
import com.ui.pojos.AddressPojo;

public class FakerUtility {

	public static AddressPojo getFakerData() {
		Faker faker = new Faker();
		AddressPojo addressPojo = new AddressPojo(faker.address().buildingNumber(), faker.address().city(),
				faker.address().state(), faker.numerify("#####"), faker.phoneNumber().cellPhone(), "Test123");
		return addressPojo;
	}

}
