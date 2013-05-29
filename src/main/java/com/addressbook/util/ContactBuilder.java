/**
 * 
 */
package com.addressbook.util;

import java.util.HashSet;
import java.util.Set;

import com.addressbook.entity.Contact;

/**
 * Builder class for {@link Contact}.
 * 
 * @author Vijitha Epa
 */
public class ContactBuilder implements EntityBuilder<Contact> {

	private String name;
	private Set<String> numbers = new HashSet<String>();

	private ContactBuilder() {
	}

	/**
	 * @return a {@link ContactBuilder} instance.
	 */
	public static ContactBuilder getContactBuilder() {
		return new ContactBuilder();
	}

	/**
	 * Build with Contact Name.
	 * 
	 * @param name as String.
	 */
	public ContactBuilder withName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Build with adding Contact Number Set.
	 * 
	 * @param numbers as Set<String>.
	 * @return ContactBuilder instance.
	 */
	public ContactBuilder withNumberSet(Set<String> numbers) {
		this.numbers.addAll(numbers);
		return this;
	}

	/**
	 * Build with Contact Number.
	 * 
	 * @param number as String.
	 * @return ContactBuilder instance.
	 */
	public ContactBuilder withNumber(String number) {
		numbers.add(number);
		return this;
	}

	/**
	 * Build with setting New Contact Number Set.
	 * 
	 * @param numbers as Set<String>.
	 * @return ContactBuilder instance.
	 */
	public ContactBuilder withNewNumberSet(Set<String> numbers) {
		this.numbers = numbers;
		return this;
	}

	/**
	 * Build the {@link Contact} type instance.
	 */
	public Contact build() {
		Contact contact = new Contact(name);
		contact.setNumbers(numbers);
		return contact;
	}
}
