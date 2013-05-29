/**
 * 
 */
package com.addressbook.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * @author Vijitha Epa
 *
 */
public class PropertyLoaderTest {
	
	@Test
	public void shouldLoadPropertyFromFile(){
		PropertyLoader propertyLoader = PropertyLoader.getPropertyLoader();
		String[] testValues = propertyLoader.getArrayOfValues("testKey");
		assertNotNull(testValues);
		assertEquals(1, testValues.length);
	}

}
