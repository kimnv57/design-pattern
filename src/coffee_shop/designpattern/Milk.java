package coffee_shop.designpattern;

public class Milk extends CoffeeWithCondements{

	private static final float MILK_COST = 2;

	public Milk(Coffee coffee) {
		super(coffee, "Milk", MILK_COST);
	}

}
