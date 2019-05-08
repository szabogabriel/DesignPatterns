package other.references;

import java.lang.ref.SoftReference;

/**
 * <h1>Soft Reference</h1>
 * <p>
 * <ul>
 * 		<li>To create such references {@link SoftReference} class is used.</li>
 * 		<li>If an object has no strong reference but has a soft reference, then the garbage collector reclaims this object’s memory when GC badly needs to free up some memory.</li>
 * 		<li>All soft references to softly-reachable objects are guaranteed to have been cleared before the virtual machine throws an OutOfMemoryError.</li>
 * 		<li>Most often used to implement memory-sensitive caches.</li>
 * </ul>
 */
public class SoftReferenceExample {
	
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
        
        // Let's create a Soft Reference to the ObjectWithFinalize object 
        // to which 'o' is also pointing. 
        SoftReference<ObjectWithFinalize> softRefToO = new SoftReference<>(o); 
        System.out.println(
        		String.format("BEFORE GC: Get allways returns the instance: %s", 
        				softRefToO.get()));
          
        // Now, object to which 'o' was pointing earlier is eligible for garbage collection.
        // However, it should not be garbage collected, until JVM is in need of memory badly.
        o = null;  
        
        // Let's give GC a chance to collect it
        suggestGc();

        // Can we still retrieve back the object through the soft reference?
        // Yes, JVM was not in badly need of free memory.
        System.out.println(
        		String.format("AFTER GC: Can we still retrieve back the object? (Yes, JVM was not in badly need of free memory) %s", 
        				softRefToO.get()));
    } 
	
}
