package patterns.creational.factorymethod.transport;

public class BikeTransport implements Transport {

	@Override
	public void deliver() {
		System.out.println("=> It will be delivered with a bike\n");
	}

}
