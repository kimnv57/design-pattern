package coffee_shop.designpattern;

abstract class Coffee {
	public String description;
	public float price;
	public Coffee(String description,float price) {
		this.description = description;
		this.price = price;
	}
	public float getCost() {
		return price;
	}
	public String getDescription() {
		return description;
	}
	
	@Override
	public String toString() {
		return String.format("%s, %.1f$", getDescription(), getCost());
	}

}
