package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojos.User;

public class CSVReaderUtility {

	public static Iterator<User> readCsvFile() {
		File csvFile = new File(System.getProperty("user.dir") + "/testData/loginData.csv");
		FileReader fr;
		CSVReader csvreader;
		String[] line;
		User userData;
		List<User> userList = null;

		try {
			fr = new FileReader(csvFile);
			csvreader = new CSVReader(fr);
			csvreader.readNext(); // skip first line
			userList = new ArrayList<User>();
			while ((line = csvreader.readNext()) != null) {
				userData = new User(line[0], line[1]);
				userList.add(userData);

			}
		} catch (IOException | CsvValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userList.iterator();

	}

}
