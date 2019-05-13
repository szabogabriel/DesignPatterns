package patterns.structural.bridge.abstraction;

import java.util.ArrayList;
import java.util.List;

import patterns.structural.bridge.implementation.Workshop;

public abstract class Vehicle {
	protected List<Workshop> workshops = new ArrayList<>();
  
    public boolean joinWorkshop(Workshop workshop) {
    	return workshops.add(workshop);
    }
    
    public abstract void manufacture(); 
    public abstract int minWorkTime();
}
