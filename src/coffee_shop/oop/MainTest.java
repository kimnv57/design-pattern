package coffee_shop.oop;

public class MainTest {

	public static void main(String[] args) {
		Customer kim = new Customer("Nguyen Van Kim");
		Coffee americano = new Americano();
		
		americano.addCondiment(new Milk());
		Order kimOrder =new Order(kim,americano);
		kimOrder.addCoffee(americano);
		System.out.println(kimOrder.getDesciption());
	}

}
