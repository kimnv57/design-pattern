/**
 * Copyright © 2015 Ntq-Solution.
 * 
 */
package prototype;

/**
 * class Square.java
 * 
 * @version 1 5:02:40 PM
 * @author kimnv57
 *
 */
public class Square extends Shape {

	public Square() {
		type = "Square";
	}

	@Override
	public void draw() {
		System.out.println("Inside Square::draw() method.");
	}
}