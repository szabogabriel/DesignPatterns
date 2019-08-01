package patterns.creational.factorymethod;

import patterns.creational.factorymethod.factory.Logistics;
import patterns.creational.factorymethod.factory.RoadLogistics;
import patterns.creational.factorymethod.factory.SeaLogistics;

public class LogisticsApp {
	
	public static void main(String[] args) {
		System.out.println("*** Factory Pattern Demo ***\n");
		
		Logistics roadLogistics = new RoadLogistics();
		roadLogistics.planAndDeliver("pizza", 1, 0.5);
		roadLogistics.planAndDeliver("pizza", 10, 0.5);
		roadLogistics.planAndDeliver("wash machine", 1, 25);
		roadLogistics.planAndDeliver("new car", 10, 750);
		roadLogistics.planAndDeliver("dron", 1500, 0.75);

		System.out.println("");

		Logistics seaLogistics = new SeaLogistics();
		seaLogistics.planAndDeliver("barrel of petrol", 17000, 27000000);
	}

}
