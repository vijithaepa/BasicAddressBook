/**
 * 
 */
package com.addressbook.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Property loader
 * 
 * @author Vijitha Epa
 */
public class PropertyLoader {

	/**
	 * Property File location as src.
	 */
	private static final String SRC_DIRECTORY_PROPERTIES = "src/main/resources/Directory.properties";
	/**
	 * Property File location as class path.
	 */
	private static final String CLASSPATH_DIRECTORY_PROPERTIES = "classes/Directory.properties";

	private static Properties prop = new Properties();

	private PropertyLoader() {

	}

	/**
	 * Return {@link ContactBuilder} instance.
	 */
	public static PropertyLoader getPropertyLoader() {
		return new PropertyLoader();
	}

	/**
	 * Utility method to get values from a key. System will load the property
	 * file run time.
	 * 
	 * @param property key as a String.
	 * @return String[] of values separated by ",".
	 */
	public String[] getArrayOfValues(String key) {

		String values = getProprtyReader().getProperty(key);
		try {
			if (values.indexOf(',') > 0) {
				return values.split(",");
			} else {
				return new String[] { values };
			}
		} catch (NullPointerException ex) {
			throw new RuntimeException("Error on loading property...");
		}
	}

	/*
	 * Singleton method to return Property Reader.
	 */
	private Properties getProprtyReader() {

		File file;
		String filePath = SRC_DIRECTORY_PROPERTIES;
		file = new File(filePath);
		if (!file.exists()) {
			filePath = CLASSPATH_DIRECTORY_PROPERTIES;
			file = new File(filePath);
		}

		// System.out.println("File : " + filePath); //logging purposes.
		
		if (null != prop) {
			try {
				prop.load(new FileInputStream(filePath));
			} catch (FileNotFoundException fnfEx) {
				throw new RuntimeException("Property File cannot be found...");
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return prop;
	}
}
