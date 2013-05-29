/**
 * 
 */
package com.addressbook.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.junit.BeforeClass;
import org.junit.Test;

import com.addressbook.entity.AddressBook;
import com.addressbook.entity.Contact;
import com.addressbook.service.impl.DirectoryServiceImpl;
import com.addressbook.util.ContactBuilder;

/**
 * @author Vijitha Epa
 */
public class DirectoryServiceTest {

	private static DirectoryService directoryService;

	@BeforeClass
	public static void setUp() {
		directoryService = new DirectoryServiceImpl();
	}


	@Test
	public void shouldReturnAddressBookWithNames() {
		assertNotNull(directoryService.getAddressBookByName("Book01"));
		assertNotNull(directoryService.getBooks());
		assertEquals(2, directoryService.getBooks().size());
	}
	
	@Test
	public void shouldReturnAllAddressBooks(){
		Map<String,AddressBook> directory = directoryService.getBooks();
		assertNotNull(directory);
		assertEquals(2, directory.size());
	}

	@Test
	public void shouldCreateAddressBookWithContacts() {
		directoryService.createAddressBook("Book 1");
		directoryService.addContactToAddressBook("Book 1", getContact("Boby"));
		directoryService.addContactToAddressBook("Book 1", getContact("Viki"));
		directoryService.addContactToAddressBook("Book 1", getContact("Sam"));
		AddressBook book = directoryService.getAddressBookByName("Book 1");
		assertNotNull(book);
		assertEquals(3, book.getContacts().size());
	}

	@Test
	public void shouldCreateAddressBookWithContactSet() {
		directoryService.createAddressBook("Book 1");
		Set<Contact> contactSet = new TreeSet<Contact>();
		contactSet.add(getContact("Boby"));
		contactSet.add(getContact("Viki"));
		contactSet.add(getContact("Sam"));
		directoryService.addContactsToAddressBook("Book 1", contactSet);
		AddressBook book = directoryService.getAddressBookByName("Book 1");
		assertNotNull(book);
		assertEquals(3, book.getContacts().size());
	}
	
	@Test
	public void shouldReturnUniqueContactsForDifferentBookName() {
		Set<Contact> contacts = directoryService.getAllContacts();
		assertNotNull(contacts);
		assertEquals(6, contacts.size());
	}
	

	private Contact getContact(String contactName) {
		ContactBuilder builder = ContactBuilder.getContactBuilder();
		Contact friend = builder.withName(contactName).withNumber("0199999999").withNumber("0299999999").build();
		return friend;
	}

}
