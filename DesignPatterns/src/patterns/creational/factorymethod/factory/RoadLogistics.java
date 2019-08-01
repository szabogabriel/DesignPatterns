package patterns.creational.factorymethod.factory;

import patterns.creational.factorymethod.transport.BikeTransport;
import patterns.creational.factorymethod.transport.CarTransport;
import patterns.creational.factorymethod.transport.Transport;
import patterns.creational.factorymethod.transport.TruckTransport;

public class RoadLogistics extends Logistics {

	public Transport createTransport(String description, int distance, double weight) {
		if (weight >= 200 || distance >= 1000) {
			return new TruckTransport();
		} else if (weight >= 25) {
			return new CarTransport();
		} else {
			return new BikeTransport();
		}
	}
	
}
