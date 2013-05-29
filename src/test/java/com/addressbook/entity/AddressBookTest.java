/**
 *  Test class for Address Book entity.
 */
package com.addressbook.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashSet;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import com.addressbook.util.ContactBuilder;

/**
 * @author Vijitha Epa
 */

public class AddressBookTest {

	private static final String AddressBookName = "Book 01";
	private static AddressBook addressBook;

	@BeforeClass
	public static void setUp() {
		addressBook = new AddressBook(AddressBookName);
		addressBook.setContact(getFriedndsSet());
	}

	@Test
	public void addressBookCreatedWithGivenName() {
		assertEquals(AddressBookName, addressBook.getName());
	}

	@Test
	public void addressBookCreatedWithGivenFriends() {
		assertNotNull(addressBook.getContacts());
		assertEquals(addressBook.getContacts().size(), getFriedndsSet().size());
	}

	private static Set<Contact> getFriedndsSet() {
		Set<Contact> friends = new HashSet<Contact>();
		ContactBuilder byulder = ContactBuilder.getContactBuilder();
		Contact friend1 = byulder.withName("Boby").withNumber("0199999901").withNumber("0199999902").build();
		Contact friend2 = byulder.withName("kamal").withNumber("0299999901").withNumber("0299999902").build();
		friends.add(friend1);
		friends.add(friend2);
		return friends;
	}
}
