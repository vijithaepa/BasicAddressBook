/**
 * 
 */
package com.addressbook.service;

import java.util.Map;
import java.util.Set;

import com.addressbook.entity.AddressBook;
import com.addressbook.entity.Contact;

/**
 * @author Vijitha Epa
 */
public interface DirectoryService {

	@Deprecated
	void createAddressBook(String name);

	public AddressBook getAddressBookByName(String bookName);

	public Map<String, AddressBook> getBooks();

	public void addContactsToAddressBook(String bookName, Set<Contact> friedsSet);

	public void addContactToAddressBook(String bookName, Contact friend);

	public Set<Contact> getAllContacts();
}
