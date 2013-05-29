/**
 * 
 */
package com.addressbook.util;

/**
 * Builder for type entities and return a type entity after build method
 * executed.
 * 
 * @author Vijitha Epa
 * 
 */
public interface EntityBuilder<T> {

	/**
	 * Build the entity and return.
	 * 
	 * @return
	 */
	T build();
}
