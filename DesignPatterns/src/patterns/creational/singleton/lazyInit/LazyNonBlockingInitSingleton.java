package patterns.creational.singleton.lazyInit;

import java.util.logging.Level;
import java.util.logging.Logger;

import patterns.creational.singleton.Testable;

public class LazyNonBlockingInitSingleton implements Testable {
	
	private static volatile LazyNonBlockingInitSingleton INSTANCE;
	
	private LazyNonBlockingInitSingleton() {
		
	}
	
	public static LazyNonBlockingInitSingleton getInstance() {
		if (INSTANCE == null) {
			synchronized (LazyNonBlockingInitSingleton.class) {
				if (INSTANCE == null) {
					INSTANCE = new LazyNonBlockingInitSingleton();
				}
			}
		}
		return INSTANCE;
	}

	@Override
	public void sayHello() {
		Logger.getAnonymousLogger().log(Level.INFO, "Hello from " + this.getClass().getName());
	}

}
