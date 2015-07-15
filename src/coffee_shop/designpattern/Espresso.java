package coffee_shop.designpattern;

public class Espresso extends Coffee{

	private static final float ESPRESSO_COST = 15;

	public Espresso() {
		super("Espresso coffee", ESPRESSO_COST);
	}
}
