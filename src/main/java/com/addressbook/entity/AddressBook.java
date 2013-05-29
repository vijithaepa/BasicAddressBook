/**
 * 
 */
package com.addressbook.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * AddressBook Entity.
 * 
 * @author Vijitha Epa
 */
public class AddressBook {

	private String bookName;
	private Set<Contact> contacts = new HashSet<Contact>();

	/**
	 * @param addressbookname
	 */
	public AddressBook(String addressbookname) {
		bookName = addressbookname;
	}

	/**
	 * @return String as name.
	 */
	public String getName() {
		return bookName;
	}

	/**
	 * Assign new Set of Contact to Address Book.
	 * 
	 * @param Set of Contact.
	 */
	public void setContact(Set<Contact> ContactSet) {
		contacts = ContactSet;

	}

	/**
	 * @return set of Contact.
	 */
	public Set<Contact> getContacts() {
		return contacts;
	}

	/**
	 * Add more set of Contact to Address Book.
	 * 
	 * @param contactSet as Set
	 */
	public void addContacts(Set<Contact> contactSet) {
		for (Contact contact : contactSet) {
			contacts.add(contact);
		}
	}

	/**
	 * Add one more Contact to Address Book.
	 * 
	 * @param contact as Contact.
	 */
	public void addContact(Contact contact) {
		contacts.add(contact);

	}

	@Override
	public String toString() {
		return "AddressBook [bookName=" + bookName + ", contacts=" + contacts + "]";
	}

}
