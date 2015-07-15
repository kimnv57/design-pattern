/**
 * Copyright © 2015 Ntq-Solution.
 * 
 */
package builder;

/**
 * class Pepsi.java
 * 
 * @version 1 4:09:43 PM
 * @author kimnv57
 *
 */
public class Pepsi extends ColdDrink {

	@Override
	public float price() {
		return 35.0f;
	}

	@Override
	public String name() {
		return "Pepsi";
	}
}