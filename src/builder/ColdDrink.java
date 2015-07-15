/**
 * Copyright © 2015 Ntq-Solution.
 * 
 */
package builder;

/**
 * class ColdDrink.java
 * 
 * @version 1 4:07:43 PM
 * @author kimnv57
 *
 */
public abstract class ColdDrink implements Item {

	@Override
	public Packing packing() {
		return new Bottle();
	}

	@Override
	public abstract float price();
}