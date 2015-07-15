/**
 * Copyright © 2015 Ntq-Solution.
 * 
 */
package builder;

/**
 * class VegBugger.java
 * 
 * @version 1 4:05:58 PM
 * @author kimnv57
 *
 */
public class VegBurger extends Burger {

	@Override
	public float price() {
		return 25.0f;
	}

	@Override
	public String name() {
		return "Veg Burger";
	}
}