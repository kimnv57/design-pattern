/**
 * Copyright © 2015 Ntq-Solution.
 * 
 */
package builder;

/**
 * class MealBuilder.java
 * 
 * @version 1 4:12:15 PM
 * @author kimnv57
 *
 */
public class MealBuilder {

	public Meal prepareVegMeal() {
		Meal meal = new Meal();
		meal.addItem(new VegBurger());
		meal.addItem(new Coke());
		return meal;
	}

	public Meal prepareNonVegMeal() {
		Meal meal = new Meal();
		meal.addItem(new ChickenBurger());
		meal.addItem(new Pepsi());
		return meal;
	}
}