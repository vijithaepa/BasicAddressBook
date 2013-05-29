/**
 * 
 */
package com.addressbook.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Contacts Entity.
 * 
 * @author Vijitha Epa
 */
public class Contact implements Comparable<Contact> {

	private String name;
	private Set<String> numbers = new HashSet<String>();

	/**
	 * @param string
	 */
	public Contact(String contactName) {
		name = contactName;
	}

	/**
	 * Add a number to the {@Link Contact}.
	 * 
	 * @param string as number;
	 */
	public void addNumber(String number) {
		numbers.add(number);

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getNumbers() {
		return numbers;
	}

	public void setNumbers(Set<String> numbers) {
		this.numbers = numbers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return name + " : \t" + numbers;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Contact o) {
		return this.name.compareTo(o.name);
	}

}
