package patterns.structural.bridge.implementation;

import java.util.concurrent.TimeUnit;

import patterns.structural.bridge.abstraction.Vehicle;

public class PaintWorkShop implements Workshop {

    public PaintWorkShop() {
        super();
    }

    @Override
    public void work(Vehicle vehicle) {

        System.out.print("Painting... ");
        long timeToTake = 20 * vehicle.minWorkTime();
        try {
        	TimeUnit.MILLISECONDS.sleep(timeToTake);
        } catch (InterruptedException exp) {
        	// nothing to do for now.
        } 
        System.out.printf("(Time taken: %d millis), Done.\n", Long.valueOf(timeToTake));
    }
}

