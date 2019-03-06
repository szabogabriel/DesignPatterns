package patterns.creational.singleton;

import patterns.creational.singleton.en.EnumSingleton;
import patterns.creational.singleton.lazyInit.LazyBlockingInitSingleton;
import patterns.creational.singleton.lazyInit.LazyNonBlockingInitSingleton;
import patterns.creational.singleton.lazyStaticInit.LazyStaticInitClass;
import patterns.creational.singleton.serializable.CorrectSerializableSingleton;
import patterns.creational.singleton.staticBlock.StaticBlockSingleton;
import patterns.creational.singleton.staticPublicFinal.SimplePublicStaticFinalInstanceSingleton;

public class Main {
	
	public static void main(String [] args) {
		EnumSingleton.getInstance().sayHello();
		
		LazyBlockingInitSingleton.getInstance().sayHello();
		LazyNonBlockingInitSingleton.getInstance().sayHello();
		
		LazyStaticInitClass.getInstance().sayHello();

		CorrectSerializableSingleton.getInstance().sayHello();

		StaticBlockSingleton.getInstance().sayHello();
		
		SimplePublicStaticFinalInstanceSingleton.getInstance().sayHello();
		
	}

}
