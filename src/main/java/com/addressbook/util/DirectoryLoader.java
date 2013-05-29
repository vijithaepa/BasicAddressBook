/**
 * 
 */
package com.addressbook.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.addressbook.entity.AddressBook;
import com.addressbook.entity.Contact;

/**
 * Utility class to load Data from property file and populate
 * {@link AddressBook} Map.
 * 
 * @author Vijitha Epa
 */
public class DirectoryLoader {

	private static PropertyLoader propLoader;

	/**
	 * Load full directory with {@Link AddressBook} instances.
	 * 
	 * @return Map<String, AddressBook>.
	 */
	public Map<String, AddressBook> loadDirectory() {
		propLoader = PropertyLoader.getPropertyLoader();
		Map<String, AddressBook> directory = new HashMap<String, AddressBook>();
		AddressBookBuilder bookBuilder = AddressBookBuilder.getAddressBookBuilder();

		String bookName;
		String[] addressBooks = propLoader.getArrayOfValues("AddressBooks");

		for (int i = 0; i < addressBooks.length; i++) {
			bookName = addressBooks[i];
			AddressBook book = bookBuilder.withName(bookName).withNewContactSet(loadContacts(bookName)).build();
			directory.put(bookName, book);
		}

		return directory;
	}

	/**
	 * Load {@Link Contact} instances.
	 * 
	 * @param bookName as String.
	 * @return Set<Contact>.
	 */
	public Set<Contact> loadContacts(String bookName) {
		propLoader = PropertyLoader.getPropertyLoader();
		String contactName;
		Set<Contact> contactsSet = new TreeSet<Contact>();
		ContactBuilder contactBuilder = ContactBuilder.getContactBuilder();
		String[] contactNames = propLoader.getArrayOfValues(bookName);
		for (int j = 0; j < contactNames.length; j++) {
			contactName = contactNames[j];
			Set<String> numbersSet = loadNumbersSet(contactName);

			Contact contact = contactBuilder.withName(contactName).withNewNumberSet(numbersSet).build();
			contactsSet.add(contact);
		}

		return contactsSet;
	}

	/**
	 * Load full Set of numbers.
	 * 
	 * @param contactName as String.
	 * @return Set<String>.
	 */
	public Set<String> loadNumbersSet(String contactName) {
		propLoader = PropertyLoader.getPropertyLoader();
		String[] numbers = propLoader.getArrayOfValues(contactName);
		Set<String> numberSet = new HashSet<String>();
		for (int k = 0; k < numbers.length; k++) {
			numberSet.add(numbers[k]);
		}
		return numberSet;
	}

}
