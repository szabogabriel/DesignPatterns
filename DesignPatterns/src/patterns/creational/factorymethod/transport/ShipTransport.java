package patterns.creational.factorymethod.transport;

public class ShipTransport implements Transport {

	@Override
	public void deliver() {
		System.out.println("=> It will be delivered with a ship\n");
	}

}
