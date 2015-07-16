package coffee_shop.oop;

import java.util.ArrayList;

public class Order {
	private ArrayList<Coffee> coffees;
	private Customer customer;
	public Order(ArrayList<Coffee> coffees,Customer customer) {
		this.coffees=coffees;
		this.customer=customer;
	}
	
	public Order(Customer customer, Coffee coffee) {
		this.customer=customer;
		coffees=new ArrayList<Coffee>();
		coffees.add(coffee);
	}

	public float getCost() {
		float cost=0;
		for(Coffee c: coffees) {
			cost+=c.getCost();
		}
		return cost;
	}
	
	public void addCoffee(Coffee c) {
		coffees.add(c);
	}
	
	public String getDesciption() {
		StringBuilder des=new StringBuilder();
		des.append(customer.getDescription()+"\n");
		for(Coffee c:coffees) {
			des.append(c.getDescription()+"\n");
		}
		des.append("Total cost: "+getCost()+"$");
		return des.toString();
	}
}
