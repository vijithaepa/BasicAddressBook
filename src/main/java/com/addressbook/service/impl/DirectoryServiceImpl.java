/**
 * 
 */
package com.addressbook.service.impl;

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.addressbook.entity.AddressBook;
import com.addressbook.entity.Contact;
import com.addressbook.service.DirectoryService;
import com.addressbook.util.AddressBookBuilder;
import com.addressbook.util.DirectoryLoader;

/**
 * Service methods to Directory operations.
 * 
 * @author Vijitha Epa
 */
public class DirectoryServiceImpl implements DirectoryService {

	private Map<String, AddressBook> directory;

	public DirectoryServiceImpl() {
		directory = new Hashtable<String, AddressBook>();
		DirectoryLoader loader = new DirectoryLoader();
		directory = loader.loadDirectory();
	}

	/**
	 * Is Deprecated method, since no use as per the requirements.
	 * 
	 * @param string as AddressBook name.
	 */
	public void createAddressBook(String name) {
		directory = new Hashtable<String, AddressBook>();
		directory.put(name, AddressBookBuilder.getAddressBookBuilder().withName(name).build());
	}

	/**
	 * Return an {@link AddressBook} by the name.
	 * 
	 * @param string as bookName.
	 * @return AddressBook.
	 */
	public AddressBook getAddressBookByName(String bookName) {
		return directory.get(bookName);
	}

	/**
	 * Return All {@link AddressBook}s.
	 * 
	 * @return Map of AddressBook.
	 */
	public Map<String, AddressBook> getBooks() {
		return directory;
	}

	/**
	 * Add Set of {@Link Contact}s to a existing {@link AddressBook}.
	 * 
	 * @param string as bookName.
	 * @param friedndsSet as Set of Contact.
	 */
	public void addContactsToAddressBook(String bookName, Set<Contact> contactSet) {
		AddressBook book = directory.get(bookName);
		book.addContacts(contactSet);
	}

	/**
	 * Add a {@Link Contact} to a existing {@link AddressBook}.
	 * 
	 * @param string as bookName.
	 * @param contact as Contact.
	 */
	public void addContactToAddressBook(String bookName, Contact friend) {
		directory.get(bookName).addContact(friend);

	}

	/**
	 * Return all contacts avoiding duplicate contacts.
	 */
	public Set<Contact> getAllContacts() {
		Set<Contact> uniqueContactSet = new TreeSet<Contact>();
		for (String bookName : directory.keySet()) {
			AddressBook addressBook = directory.get(bookName);
			uniqueContactSet.addAll(addressBook.getContacts());
		}
		return uniqueContactSet;
	}
}
