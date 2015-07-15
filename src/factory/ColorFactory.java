/**
 * Copyright © 2015 Ntq-Solution.
 * 
 */
package factory;


/**
 * class ColorFactory.java
 * 
 * @version 1 11:47:14 AM
 * @author kimnv57
 *
 */
public class ColorFactory extends AbstractFactory {

	@Override
	public Shape getShape(String shapeType) {
		return null;
	}

	@Override
	Color getColor(String color) {

		if (color == null) {
			return null;
		}

		if (color.equalsIgnoreCase("RED")) {
			return new Red();

		} else if (color.equalsIgnoreCase("GREEN")) {
			return new Green();

		} else if (color.equalsIgnoreCase("BLUE")) {
			return new Blue();
		}

		return null;
	}
}