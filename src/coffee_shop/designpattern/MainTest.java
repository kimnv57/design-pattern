package coffee_shop.designpattern;

public class MainTest {

	public static void main(String[] args) {
		// only cappuchino for first person
		Coffee cappucino = new Cappucino();
		System.out.println(cappucino);

		Coffee mycoffee = new DarkRoast(); // darkroast
		mycoffee = new Milk(mycoffee); // add milk
		mycoffee = new Milk(mycoffee); // add another milk
		mycoffee = new Cream(mycoffee);// add cream
		System.out.println(mycoffee);
	}

}
