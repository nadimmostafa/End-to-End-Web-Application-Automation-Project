package org.nadim.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	public static String getPropertyData(String key) {
		Properties pro = new Properties();
		try {
			FileInputStream file = new FileInputStream(new File("./configuration/config.properties"));
			pro.load(file);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pro.getProperty(key);
	}
}
