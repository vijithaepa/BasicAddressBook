/**
 * 
 */
package com.addressbook.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.addressbook.entity.AddressBook;
import com.addressbook.entity.Contact;

/**
 * @author Vijitha Epa
 */
public class DirectoryLoaderTest {

	DirectoryLoader loader;
	
	@Before
	public void setUp(){
		loader = new DirectoryLoader();
	}
	
	@Test
	public void shouldLoadDirectory() {
		Map<String, AddressBook> directory = loader.loadDirectory();
		assertNotNull(directory);
		assertEquals(3, directory.get("Book01").getContacts().size());
	}
	
//	@Test
	public void shouldLoadNumbers(){
		Set<String> numbersSet = loader.loadNumbersSet("Boby");
		assertNotNull(numbersSet);
		assertEquals(3, numbersSet.size());
	}
	
//	@Test
	public void shouldLoadContacts(){
		Set<Contact> contactsSet = loader.loadContacts("Book01");
		assertNotNull(contactsSet);
		assertEquals(3, contactsSet.size());
	}
	
}
