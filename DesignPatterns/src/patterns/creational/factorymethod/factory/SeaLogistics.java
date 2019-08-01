package patterns.creational.factorymethod.factory;

import patterns.creational.factorymethod.transport.ShipTransport;
import patterns.creational.factorymethod.transport.Transport;

public class SeaLogistics extends Logistics {

	public Transport createTransport(String description, int distance, double weight) {
		return new ShipTransport();
	}
	
}
