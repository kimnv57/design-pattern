package coffee_shop.designpattern;

public class Ice extends CoffeeWithCondements{

	private static final float ICE_COST = 0;

	public Ice(Coffee coffee) {
		super(coffee, "Ice", ICE_COST);
	}

}
