package patterns.creational.singleton.staticPublicFinal;

import java.util.logging.Level;
import java.util.logging.Logger;

import patterns.creational.singleton.Testable;

// must be final
public final class SimplePublicStaticFinalInstanceSingleton implements Testable {
	
	private static final SimplePublicStaticFinalInstanceSingleton INSTANCE = new SimplePublicStaticFinalInstanceSingleton();
	
	private SimplePublicStaticFinalInstanceSingleton() {
		if (INSTANCE != null) {
			throw new IllegalAccessError();
		}
	}
	
	public static SimplePublicStaticFinalInstanceSingleton getInstance() {
		return INSTANCE;
	}

	@Override
	public void sayHello() {
		Logger.getAnonymousLogger().log(Level.INFO, "Hello, from " + this.getClass().getName());
	}

}
