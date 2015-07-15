/**
 * Copyright © 2015 Ntq-Solution.
 * 
 */
package builder;

/**
 * class ChikenBurger.java
 * 
 * @version 1 4:08:52 PM
 * @author kimnv57
 *
 */
public class ChickenBurger extends Burger {

	@Override
	public float price() {
		return 50.5f;
	}

	@Override
	public String name() {
		return "Chicken Burger";
	}
}