package patterns.creational.singleton.lazyStaticInit;

import java.util.logging.Level;
import java.util.logging.Logger;

import patterns.creational.singleton.Testable;

public class LazyStaticInitClass implements Testable {
	
	private LazyStaticInitClass() {
		
	}
	
	private static class LazyStaticInitClassHelper {
		private static final LazyStaticInitClass INSTANCE = new LazyStaticInitClass();
	}
	
	public static LazyStaticInitClass getInstance() {
		return LazyStaticInitClassHelper.INSTANCE;
	}

	@Override
	public void sayHello() {
		Logger.getAnonymousLogger().log(Level.INFO, "Hello from " + this.getClass().getName());
	}
	
}
