package other.references;

import java.lang.ref.WeakReference;

/**
 * <h1>Weak Reference</h1>
 * <p>
 * <ul>
 * 		<li>To create such references {@link WeakReference} class is used.</li>
 * 		<li>If JVM detects an object with only weak references (i.e. no strong or soft references linked to this object), it will be marked for garbage collection.</li>
 * 		<li>It does not prevent the referent from being made finalizable, finalized, and then reclaimed.</li>
 * 		<li>It is often used to implement canonicalizing mappings or to fix  the Lapsed Listener problem.</li>
 * </ul>
 */
public class WeakReferenceExample {
	
	public static class ObjectWithFinalize {
		@Override
		protected void finalize() throws Throwable {
			System.out.println(String.format("The object %s is being finalized!", this));
			super.finalize();
		}
	}

	private static void suggestGc() {
		for (int i = 1; i <= 3; i++) {
			System.gc();
			try {
				System.out.println("Calling System.gc() and sleeping 1 second ...");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) 
    { 
        // Strong Reference - by default 
		ObjectWithFinalize o = new ObjectWithFinalize();
        
        // Let's create a Weak Reference to the ObjectWithFinalize object 
        // to which 'o' is also pointing. 
        WeakReference<ObjectWithFinalize> weakRefToO = new WeakReference<ObjectWithFinalize>(o); 
        System.out.println(
        		String.format("BEFORE GC: Get method of the weak reference allways returns the instance: %s",
        				weakRefToO.get()));
          
        // Now, object to which 'o' was pointing earlier is  
        // eligible for garbage collection.
        o = null;  
        
        // Let's give GC a chance to collect it
        suggestGc();

        // When the gc method is called, usually the object is not accessible through the weak reference anymore.
        System.out.println(
        		String.format("AFTER GC: Get method of the weak reference is usually not returning the instance: %s",
        				weakRefToO.get()));
    } 
}
