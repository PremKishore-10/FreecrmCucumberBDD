package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	public static Properties prop;
	
	public Properties init_prop() {
		prop = new Properties();
		try {
			FileInputStream file = new FileInputStream("D:/eclipse/eclipse-workspace/FreeCRMBDDTest/src/test/resources/config/config.properties");
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}
