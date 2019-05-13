package patterns.structural.bridge;

import patterns.structural.bridge.abstraction.Bike;
import patterns.structural.bridge.abstraction.Bus;
import patterns.structural.bridge.abstraction.Vehicle;
import patterns.structural.bridge.implementation.AssembleWorkShop;
import patterns.structural.bridge.implementation.PaintWorkShop;
import patterns.structural.bridge.implementation.ProduceWorkShop;

public class BridgePattern {

	public BridgePattern() {
		super();
	}
	
	public static void main(String[] args) {
		
        patterns.structural.bridge.abstraction.Vehicle bike = new Bike();
        bike.joinWorkshop(new ProduceWorkShop());
        bike.joinWorkshop(new AssembleWorkShop());
        bike.joinWorkshop(new PaintWorkShop());
        bike.manufacture();
        
        Vehicle bus = new Bus();
        bus.joinWorkshop(new ProduceWorkShop());
        bus.joinWorkshop(new AssembleWorkShop());
        bus.manufacture();
	}

}
