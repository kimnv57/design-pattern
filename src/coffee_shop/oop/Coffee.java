package coffee_shop.oop;

import java.util.ArrayList;

abstract class Coffee {
	private String name;
	private float cost;
	ArrayList<Condiment> condiments;

	public Coffee(String name, float cost) {
		this.name = name;
		this.cost = cost;
		condiments=new ArrayList<Condiment>();
	}
	
	public void addCondiment(Condiment c) {
		condiments.add(c);
	}

	public String getDescription() {
		StringBuilder des = new StringBuilder();
		float cost=this.cost;
		des.append(name);
		for (Condiment c : condiments) {
			des.append(", "+c.getName());
			cost+=c.getCost();
		}
		des.append(": "+cost+"$");
		return des.toString();
	}

	public String getName() {
		return name;
	}

	public float getCost() {
		float cost=this.cost;
		for(Condiment c: condiments) {
			cost+=c.getCost();
		}
		return cost;
	}
}
