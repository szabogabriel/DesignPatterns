package patterns.structural.bridge.abstraction;

import patterns.structural.bridge.implementation.Workshop;

public class Bike extends Vehicle {
    @Override
    public void manufacture() {
          System.out.println("Manufactoring Bike...");
          for (Workshop workshop : workshops) {
        	  workshop.work(this);
          }
          System.out.println("Done.");
          System.out.println();
    }
    @Override
    public int minWorkTime() {
    	return 5;
    }
}
