package patterns.structural.flyweight.restaurant;

import java.math.BigDecimal;
import java.util.Currency;

@FunctionalInterface
public interface Order {
	
	void serve();

    static Order of(String itemName, BigDecimal itemPrice, Currency currency, int tableNumber) {
        MenuItem item = MenuItem.intern(itemName, itemPrice, currency);
        return () -> System.out.println("Serving " + item + " to table " + tableNumber);
    }
}

