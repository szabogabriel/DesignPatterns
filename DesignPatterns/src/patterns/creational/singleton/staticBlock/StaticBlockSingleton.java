package patterns.creational.singleton.staticBlock;

import java.util.logging.Level;
import java.util.logging.Logger;

import patterns.creational.singleton.Testable;

public class StaticBlockSingleton implements Testable {
	
	private static StaticBlockSingleton INSTANCE;
	
	static {
		try {
			INSTANCE = new StaticBlockSingleton();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	private StaticBlockSingleton() {
		
	}
	
	public static StaticBlockSingleton getInstance() {
		return INSTANCE;
	}

	@Override
	public void sayHello() {
		Logger.getAnonymousLogger().log(Level.INFO, "Hello from " + this.getClass().getName());
	}

}
