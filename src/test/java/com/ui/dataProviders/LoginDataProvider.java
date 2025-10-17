package com.ui.dataProviders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojos.InvalidTestData;
import com.ui.pojos.InvalidUser;
import com.ui.pojos.TestData;
import com.ui.pojos.User;
import com.utility.CSVReaderUtility;
import com.utility.ExcelReaderUtility;

public class LoginDataProvider {

	@DataProvider(name = "LoginTestDataProvider")
	public Iterator<Object[]> loginDataProvider() {

		Gson gson = new Gson();
		File file = new File(System.getProperty("user.dir") + "/testData/loginTestData.json");
		FileReader fr;
		TestData data = null;
		try {
			fr = new FileReader(file);
			data = gson.fromJson(fr, TestData.class);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Object[]> dataToReturn = new ArrayList<Object[]>();

		for (User user : data.getData()) {
			dataToReturn.add(new Object[] { user });

		}
		return dataToReturn.iterator();

	}

	@DataProvider(name = "LoginTestCsvDataProvider")
	public Iterator<User> loginCsvDataProvider() {
		return CSVReaderUtility.readCsvFile();
	}

	@DataProvider(name = "LoginTestXlsxDataProvider")
	public Iterator<User> loginXlsxDataProvider() {
		return ExcelReaderUtility.readFromXlsx();
	}

	@DataProvider(name = "InvalidLoginTestDataProvider")
	public Iterator<Object[]> invalidLoginDataProvider() {
		Gson gson = new Gson();
		File file = new File(System.getProperty("user.dir") + "/testData/invalidLoginTestData.json");
		FileReader fr;
		InvalidTestData data = null;
		try {
			fr = new FileReader(file);
			data=gson.fromJson(fr, InvalidTestData.class);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Object[]> dataToReturn = new ArrayList<Object[]>();
		for (InvalidUser invaliduser : data.getInvalidData()) {
			dataToReturn.add(new Object[] { invaliduser });

		}
		return dataToReturn.iterator();
	}

}
