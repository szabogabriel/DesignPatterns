package patterns.creational.factorymethod.transport;

public class TruckTransport implements Transport {

	@Override
	public void deliver() {
		System.out.println("=> It has been delivered with a truck\n");
	}

}