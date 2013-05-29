/**
 * 
 */
package com.addressbook.util;

import java.util.HashSet;
import java.util.Set;

import com.addressbook.entity.AddressBook;
import com.addressbook.entity.Contact;

/**
 * Builder class for {@link AddressBook}.
 * 
 * @author Vijitha Epa
 */
public class AddressBookBuilder implements EntityBuilder<AddressBook> {

	private String bookName;
	private Set<Contact> contacts = new HashSet<Contact>();

	private AddressBookBuilder() {

	}

	/**
	 * @return a {@link AddressBookBuilder} instance.
	 */
	public static AddressBookBuilder getAddressBookBuilder() {
		return new AddressBookBuilder();
	}

	/**
	 * Build with AddressBook Name.
	 * 
	 * @param bookName as String.
	 * @return AddressBookBuilder instance.
	 */
	public AddressBookBuilder withName(String bookName) {
		this.bookName = bookName;
		return this;
		

	}

	/**
	 * Build with {@link Contact}.
	 * 
	 * @param contact as {@link Contact}.
	 * @return AddressBookBuilder instance.
	 */
	public AddressBookBuilder withContact(Contact contact) {
		contacts.add(contact);
		return this;
	}

	/**
	 * Build with adding Contact Set.
	 * 
	 * @param contacts as Set<Contact>.
	 * @return AddressBookBuilder instance.
	 */
	public AddressBookBuilder withContacts(Set<Contact> contactSet) {
		contacts.addAll(contactSet);
		return this;
	}

	/**
	 * Build with setting new Contact Set.
	 * 
	 * @param contacts as Set<Contact>.
	 * @return AddressBookBuilder instance.
	 */
	public AddressBookBuilder withNewContactSet(Set<Contact> contactSet) {
		this.contacts = contactSet;
		return this;
	}

	/**
	 * Return the {@link AddressBook} type instance.
	 */
	public AddressBook build() {
		AddressBook addressBook = new AddressBook(bookName);
		addressBook.setContact(contacts);
		return addressBook;
	}
}
