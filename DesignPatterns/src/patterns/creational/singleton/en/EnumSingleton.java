package patterns.creational.singleton.en;

import java.util.logging.Level;
import java.util.logging.Logger;

import patterns.creational.singleton.Testable;

public enum EnumSingleton implements Testable {
	
	INSTANCE {

		@Override
		public void sayHello() {
			Logger.getAnonymousLogger().log(Level.INFO, "Hello from EnumSingleton");
		}
		
	};
	
	public static EnumSingleton getInstance() {
		return EnumSingleton.INSTANCE;
	}

}
