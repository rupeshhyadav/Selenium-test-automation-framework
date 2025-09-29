package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojos.User;

public class ExcelReaderUtility {

	public static Iterator<User> readFromXlsx() {

		File xlsxFile = new File(System.getProperty("user.dir") + "/testData/loginData1.xlsx");
		XSSFWorkbook xssfworkbook;
		XSSFSheet xssfSheet;
		Iterator<Row> rowIterator;
		Row row;
		Cell emailCell;
		Cell passwordCell;
		List<User> userList = null;
		User user;
		try {
			xssfworkbook = new XSSFWorkbook(xlsxFile);
			userList = new ArrayList<User>();
			xssfSheet = xssfworkbook.getSheet("Sheet1");
			rowIterator = xssfSheet.iterator();
			rowIterator.next();
			while (rowIterator.hasNext()) {
				row = rowIterator.next();
				emailCell = row.getCell(0);
				passwordCell = row.getCell(1);
				user = new User(emailCell.toString(), passwordCell.toString());
				userList.add(user);
				xssfworkbook.close();

			}

		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userList.iterator();
	}

	public static void readDataExcel() {
		File file = new File(System.getProperty("user.dir") + "/testData/loginData1.xlsx");
		try {
			XSSFWorkbook xssfwb = new XSSFWorkbook(file);
			XSSFSheet xssfsheet = xssfwb.getSheet("Sheet1");
			Iterator<Row> it = xssfsheet.iterator();
			it.next();
			while (it.hasNext()) {
				Row row = it.next();
				System.out.println(row.getCell(0));
				System.out.println(row.getCell(1));
				xssfwb.close();

			}
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
