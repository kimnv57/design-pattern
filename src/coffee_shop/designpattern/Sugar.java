package coffee_shop.designpattern;

public class Sugar extends CoffeeWithCondements{

	private static final float SUGAR_COST = 1;

	public Sugar(Coffee coffee) {
		super(coffee, "Sugar", SUGAR_COST);
	}

}
