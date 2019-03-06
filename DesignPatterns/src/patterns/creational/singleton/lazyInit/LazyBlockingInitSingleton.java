package patterns.creational.singleton.lazyInit;

import java.util.logging.Level;
import java.util.logging.Logger;

import patterns.creational.singleton.Testable;

public class LazyBlockingInitSingleton implements Testable {
	
	private static LazyBlockingInitSingleton INSTANCE;
	
	private LazyBlockingInitSingleton() {
		
	}
	
	public static synchronized LazyBlockingInitSingleton getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new LazyBlockingInitSingleton();
		}
		return INSTANCE;
	}

	@Override
	public void sayHello() {
		Logger.getAnonymousLogger().log(Level.INFO, "Hello from " + this.getClass().getName());
	}

}
