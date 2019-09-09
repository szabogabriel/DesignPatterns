package patterns.structural.flyweight.restaurant;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.WeakHashMap;

public class MenuItem {
	
	private final String itemName;
	private final BigDecimal itemPrice;
	private final Currency currency;
	
	private static final WeakHashMap<String, MenuItem> CACHE = new WeakHashMap<>();

	// The constructor is private, only intern() can call it
	private MenuItem(String itemName, BigDecimal itemPrice, Currency currency) {
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.currency = currency;
	}

	public static MenuItem intern(String itemName, BigDecimal itemPrice, Currency currency) {
		synchronized (CACHE) {
			return CACHE.computeIfAbsent(itemName, k -> new MenuItem(itemName, itemPrice, currency));
		}
	}

	@Override
	public String toString() {
		return String.format("%s for %.2f %s", itemName, itemPrice, currency.getSymbol());
	}

	public static int menuItemsInCache() {
		synchronized (CACHE) {
			return CACHE.size();
		}
	}
}
