/**
 * Copyright © 2015 Ntq-Solution.
 * 
 */
package factory;


/**
 * class AbstractFactory.java
 * 
 * @version 1 11:45:56 AM
 * @author kimnv57
 *
 */
public abstract class AbstractFactory {
	abstract Color getColor(String color);

	abstract Shape getShape(String shape);
}