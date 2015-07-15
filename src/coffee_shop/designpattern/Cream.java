package coffee_shop.designpattern;

public class Cream extends CoffeeWithCondements{

	private static final float CREAM_COST = 2;

	public Cream(Coffee coffee) {
		super(coffee, "Cream", CREAM_COST);
	}

}
