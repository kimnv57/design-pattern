/**
 * Copyright © 2015 Ntq-Solution.
 * 
 */
package factory;

/**
 * class FactoryProducer.java
 * 
 * @version 1 11:48:40 AM
 * @author kimnv57
 *
 */
public class FactoryProducer {
	public static AbstractFactory getFactory(String choice) {

		if (choice.equalsIgnoreCase("SHAPE")) {
			return new ShapeFactory();

		} else if (choice.equalsIgnoreCase("COLOR")) {
			return new ColorFactory();
		}

		return null;
	}
}