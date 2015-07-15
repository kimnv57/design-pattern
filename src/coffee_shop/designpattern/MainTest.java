package coffee_shop.designpattern;

import java.util.ArrayList;

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
		
		ArrayList<Coffee> coffees=new ArrayList<Coffee>();
		coffees.add(mycoffee);
		coffees.add(cappucino);
		
		User kim = new User("Nguyen Van Kim");
		
		Order neworder= new Order(coffees,kim);
		System.out.println();
		System.out.println(neworder);
	}

}
