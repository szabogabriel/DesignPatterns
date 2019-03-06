package patterns.creational.singleton.serializable;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import patterns.creational.singleton.Testable;

public final class IncorrectSerializableSingleton implements Testable, Serializable {
	private static final long serialVersionUID = 2617209670900044218L;
	
	private static final IncorrectSerializableSingleton INSTANCE = new IncorrectSerializableSingleton();
	
	private IncorrectSerializableSingleton() {
		if (INSTANCE != null) {
			throw new IllegalAccessError();
		}
	}
	
	public static IncorrectSerializableSingleton getInstance() {
		return INSTANCE;
	}

	@Override
	public void sayHello() {
		Logger.getAnonymousLogger().log(Level.INFO, "Hello, from " + this.getClass().getName());
	}

}
