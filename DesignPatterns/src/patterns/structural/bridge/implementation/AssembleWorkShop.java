package patterns.structural.bridge.implementation;

import java.util.concurrent.TimeUnit;

import patterns.structural.bridge.abstraction.Vehicle;

public class AssembleWorkShop implements Workshop {

    public AssembleWorkShop() {
        super();
    }

    @Override

    public void work(Vehicle vehicle) {

        System.out.print("Assembling... ");
        long timeToTake = 200 * vehicle.minWorkTime();
        try {
        	TimeUnit.MILLISECONDS.sleep(timeToTake);
        } catch (InterruptedException exp) {
        	// nothing to do for now.
        } 
        System.out.printf("(Time taken: %d millis), Done.\n", Long.valueOf(timeToTake));

    }

}

