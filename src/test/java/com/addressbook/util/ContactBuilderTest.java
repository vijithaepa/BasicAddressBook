/**
 * 
 */
package com.addressbook.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.addressbook.entity.Contact;

/**
 * @author Vijitha Epa
 * 
 */
public class ContactBuilderTest {

	@Test
	public void shouldBuildContactWithName() {
		String name = "Boby";
		ContactBuilder contactBuilder = ContactBuilder.getContactBuilder();
		Contact contact = contactBuilder.withName(name).build();

		assertNotNull(contact);
		assertEquals(name, contact.getName());
	}
	
	@Test
	public void shouldBuildContactWithNumberSet(){
		String name = "Boby";
		Set<String> numbers = new HashSet<String>();
		numbers.add("0199999999");
		numbers.add("0299999999");
		ContactBuilder contactBuilder = ContactBuilder.getContactBuilder();
		Contact contact = contactBuilder.withName(name).withNumberSet(numbers).build();
		assertNotNull(contact);
		assertEquals(2, contact.getNumbers().size());
		
		numbers.add("0399999999");
		contact = contactBuilder.withName(name).withNumberSet(numbers).build();
		assertNotNull(contact);
		assertEquals(3, contact.getNumbers().size());
	}
	
	@Test
	public void shouldBuildContactWithNewNumberSet(){
		String name = "Boby";
		Set<String> numbers = new HashSet<String>();
		numbers.add("0199999999");
		numbers.add("0299999999");
		ContactBuilder contactBuilder = ContactBuilder.getContactBuilder();
		Contact contact = contactBuilder.withName(name).withNewNumberSet(numbers).build();

		assertNotNull(contact);
		assertEquals(2, contact.getNumbers().size());
	}
	
	@Test
	public void shouldBuildContactWithNumber(){
		String name = "Boby";
		String number1 = "0199999999";
		String number2 = "0299999999";

		ContactBuilder contactBuilder = ContactBuilder.getContactBuilder();
		Contact contact = contactBuilder.withName(name).withNumber(number1).withNumber(number2).build();

		assertNotNull(contact);
		assertEquals(2, contact.getNumbers().size());
	}
}
