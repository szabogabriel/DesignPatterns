package patterns.structural.flyweight.restaurant;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;

public class Restaurant {
	
	private final ArrayList<Order> orders = new ArrayList<>();

	public void takeOrder(String itemName, BigDecimal itemPrice, Currency currency, int tableNumber) {
		orders.add(Order.of(itemName, itemPrice, currency, tableNumber));
	}

	public void service() {
		orders.forEach(Order::serve);
		orders.clear();
	}
}
