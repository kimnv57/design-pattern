/**
 * Copyright © 2015 Ntq-Solution.
 * 
 */
package builder;

/**
 * class Buger.java
 * 
 * @version 1 4:05:48 PM
 * @author kimnv57
 *
 */
public abstract class Burger implements Item {

	@Override
	public Packing packing() {
		return new Wrapper();
	}

	@Override
	public abstract float price();
}
