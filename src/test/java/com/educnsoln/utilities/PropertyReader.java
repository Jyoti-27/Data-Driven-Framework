package com.educnsoln.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

	static String homepath = System.getProperty("user.dir");
	static File file = new File(homepath + "\\src\\test\\resources\\Config.properties");

	public static String getProperty(String key) {
		Properties prop = new Properties();
		FileInputStream inputStream;
		try {
			inputStream = new FileInputStream(file);
			prop.load(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String value = (String) prop.get(key);
		return value;

	}

}