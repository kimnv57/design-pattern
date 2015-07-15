package coffee_shop.designpattern;

abstract class CoffeeWithCondements extends Coffee{
	Coffee coffee;
	
	public CoffeeWithCondements(Coffee coffee,String description, float price) {
		super(description, price);
		this.coffee=coffee;
	}
	@Override
	public float getCost() {
		return coffee.getCost()+price;
	}
	@Override
	public String getDescription() {
		return coffee.getDescription()+", "+description;
	}
	
	
}
