package patterns.creational.factorymethod.transport;

public class CarTransport implements Transport {

	@Override
	public void deliver() {
		System.out.println("=> It will be delivered with a car\n");
	}

}
