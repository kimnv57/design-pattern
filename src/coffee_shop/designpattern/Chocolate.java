package coffee_shop.designpattern;

public class Chocolate extends CoffeeWithCondements {

	private static final float CHOCOLATE_COST = 4;

	public Chocolate(Coffee coffee) {
		super(coffee, "Chocolate", CHOCOLATE_COST);
	}

}
