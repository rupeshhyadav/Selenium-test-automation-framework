package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.constants.ENV;
import com.google.gson.Gson;
import com.ui.pojos.Config;
import com.ui.pojos.Environment;

public class JsonUtil {

	public static Environment readFromJson(ENV env) {
		Gson gson = new Gson();
		File jsonfile = new File(System.getProperty("user.dir") + "/config/config.json");
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(jsonfile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Config config = gson.fromJson(fileReader, Config.class);
		Environment environment = config.getEnvironments().get("QA");

		return environment;
	}

}
