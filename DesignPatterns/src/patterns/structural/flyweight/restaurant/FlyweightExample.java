package patterns.structural.flyweight.restaurant;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

public class FlyweightExample {
	
	public static void main(String[] args) {
		Restaurant restaurant = new Restaurant();
		restaurant.takeOrder("Cappuccino", new BigDecimal(1.50), Currency.getInstance(Locale.GERMANY), 2);
		restaurant.takeOrder("Pizza Hawaii", new BigDecimal(4.30), Currency.getInstance(Locale.GERMANY), 1);
		restaurant.takeOrder("Espresso", new BigDecimal(0.70), Currency.getInstance(Locale.GERMANY), 1);
		restaurant.takeOrder("Pizza Margherita", new BigDecimal(3.50), Currency.getInstance(Locale.GERMANY), 897);
		restaurant.takeOrder("Garlic bread", new BigDecimal(1.20), Currency.getInstance(Locale.GERMANY), 97);
		restaurant.takeOrder("Pizza Farmer", new BigDecimal(5.50), Currency.getInstance(Locale.GERMANY), 3);
		restaurant.takeOrder("Vermut bianco", new BigDecimal(1.55), Currency.getInstance(Locale.GERMANY), 3);
		restaurant.takeOrder("Metaxa", new BigDecimal(2.50), Currency.getInstance(Locale.GERMANY), 3);
		restaurant.takeOrder("Sprite", new BigDecimal(1.30), Currency.getInstance(Locale.GERMANY), 96);
		restaurant.takeOrder("Red bull", new BigDecimal(3.00), Currency.getInstance(Locale.GERMANY), 552);
		restaurant.takeOrder("Mozzarella Caprese ", new BigDecimal(5.10), Currency.getInstance(Locale.GERMANY), 121);
		restaurant.takeOrder("Linguini aglio olio e pepperoncino", new BigDecimal(8.50), Currency.getInstance(Locale.GERMANY), 121);
		restaurant.takeOrder("Cappuccino", new BigDecimal(1.50), Currency.getInstance(Locale.GERMANY), 96);
		restaurant.takeOrder("Pizza Hawaii", new BigDecimal(4.30), Currency.getInstance(Locale.GERMANY), 96);

		restaurant.service();
		
		System.out.println("Ordered items in cache: " + MenuItem.menuItemsInCache());
	}
	
}
