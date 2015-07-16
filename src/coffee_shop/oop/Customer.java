package coffee_shop.oop;

public class Customer {
	
	private String name;
	public Customer(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return "Customer: "+name;
	};
}
