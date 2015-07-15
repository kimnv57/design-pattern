package coffee_shop.designpattern;

import java.util.ArrayList;

public class Order {
	private float cost;
	private ArrayList<Coffee> coffees;
	private User user;
	public Order(ArrayList<Coffee> coffees,User user) {
		this.coffees=coffees;
		this.user=user;
		cost=0;
		for(Coffee c: coffees) {
			cost=cost + c.getCost();
		}
	}
	
	public ArrayList<Coffee> getCoffees() {
		return coffees;
	}
	
	
	public void setCoffees(ArrayList<Coffee> coffees) {
		this.coffees = coffees;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		StringBuilder descrip=new StringBuilder();
		for(Coffee c:coffees) {
			descrip.append(c);
			descrip.append("\n");
		}
		return user.getName()+": \n"+descrip
				+ "total cost: "+cost;
	}

	public float getCost() {
		return cost;
	}

}
