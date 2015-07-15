/**
 * Copyright © 2015 Ntq-Solution.
 * 
 */
package builder;

/**
 * class CokeDrink.java
 * 
 * @version 1 4:09:12 PM
 * @author kimnv57
 *
 */
public class Coke extends ColdDrink {

	@Override
	public float price() {
		return 30.0f;
	}

	@Override
	public String name() {
		return "Coke";
	}
}