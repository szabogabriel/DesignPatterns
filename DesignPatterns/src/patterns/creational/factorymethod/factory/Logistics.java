package patterns.creational.factorymethod.factory;

import java.util.UUID;

import patterns.creational.factorymethod.transport.Transport;

public abstract class Logistics {
	
	public UUID giveOrderNumber() {
		UUID uuid = UUID.randomUUID();
		System.out.println(String.format("Your order number is %s.", uuid));
		return uuid;
	}
	
	protected abstract Transport createTransport(String description, int distance, double weight);

	public void deliver(Transport transport) { 
		transport.deliver();
	}
	
	public void planAndDeliver(String description, int distance, double weight) {
		System.out.println(String.format("Thank you for ordering a transportation of %s with %.2f kg weight to %d km remote distance.", 
				description, weight, distance));
		giveOrderNumber();
		Transport transport = createTransport(description, distance, weight);
		deliver(transport);
	}
}

