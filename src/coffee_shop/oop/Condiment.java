package coffee_shop.oop;

abstract class Condiment{
	private String name;
	private float cost;
	public Condiment(String name,float cost) {
		this.name=name;
		this.cost=cost;
	}
	public String getName() {
		return name;
	}
	public float getCost() {
		return cost;
	}
	
	
}
