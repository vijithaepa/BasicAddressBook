/**
 * 
 */
package com.addressbook.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.addressbook.entity.AddressBook;
import com.addressbook.entity.Contact;

/**
 * @author Vijitha Epa
 * 
 */
public class AddressBookBuilderTest {

	@Test
	public void shouldCreateAddressBookWithName() {
		AddressBookBuilder builder = AddressBookBuilder.getAddressBookBuilder();
		AddressBook addressBook = builder.withName("Book 1").build();
		assertNotNull(addressBook);
		assertEquals("Book 1", addressBook.getName());
	}

	@Test
	public void shouldCreateAddressBookWithContactSet() {
		AddressBookBuilder addressBookbuilder = AddressBookBuilder.getAddressBookBuilder();
		ContactBuilder contactBuilder = ContactBuilder.getContactBuilder();
		Contact contact1 = contactBuilder.withName("Will").withNumber("0199999999").withNumber("0299999999").build();
		Contact contact2 = contactBuilder.withName("Will").withNumber("0199999999").withNumber("0299999999").build();
		Set<Contact> contactSet = new HashSet<Contact>();
		contactSet.add(contact1);
		contactSet.add(contact2);
		AddressBook book = addressBookbuilder.withName("Book 1").withContacts(contactSet).build();

		assertNotNull(book);
		assertEquals(contactSet.size(), book.getContacts().size());
	}

	@Test
	public void shouldCreateAddressBookWithContact() {
		AddressBookBuilder addressBookbuilder = AddressBookBuilder.getAddressBookBuilder();
		ContactBuilder contactBuilder = ContactBuilder.getContactBuilder();
		Contact contact1 = contactBuilder.withName("Will").withNumber("0199999999").withNumber("0299999999").build();
		AddressBook book = addressBookbuilder.withName("Book 1").withContact(contact1).build();
		
		assertNotNull(book);
		assertEquals(1, book.getContacts().size());
		
		Contact contact2 = contactBuilder.withName("Boby").withNumber("0199999999").withNumber("0299999999").build();
		book = addressBookbuilder.withContact(contact2).build();
		
		assertNotNull(book);
		assertEquals(2, book.getContacts().size());
	}

	@Test
	public void shouldCreateAddressBookWithANewContact() {
		AddressBookBuilder addressBookbuilder = AddressBookBuilder.getAddressBookBuilder();
		ContactBuilder contactBuilder = ContactBuilder.getContactBuilder();
		Contact contact1 = contactBuilder.withName("Will").withNumber("0199999999").withNumber("0299999999").build();
		AddressBook book = addressBookbuilder.withName("Book 1").withContact(contact1).build();
		assertNotNull(book);
		assertEquals(1, book.getContacts().size());
		
		Contact contact2 = contactBuilder.withName("Bill").withNumber("0399999999").withNumber("0499999999").build();
		Set<Contact> contactSet = new HashSet<Contact>();
		contactSet.add(contact2);
		book = addressBookbuilder.withName("Book 1").withNewContactSet(contactSet).build();
		assertNotNull(book);
		assertEquals(1, book.getContacts().size());
	}

}
