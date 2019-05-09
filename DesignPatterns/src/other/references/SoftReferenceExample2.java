package other.references;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

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
public class SoftReferenceExample2 {
	
	public static class ObjectWithFinalize {
		@Override
		protected void finalize() throws Throwable {
			System.out.println(String.format("The object %s is being finalized!", this));
			super.finalize();
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
		System.out.println("The strong reference 'o' has been set to null. The soft reference 'softRefToO' stays active!");
    	
    	// Let's allocate some heap and make JVM in need of free memory
    	List<byte[]> data = new ArrayList<byte[]>();
    	try {
    		while (true) {
    	    	System.out.println("Allocating additional 500 MB");
    			data.add(new byte [500_000_000]);
    		}
    	} catch (OutOfMemoryError e) {
                // The soft object should have been collected before this
                System.out.println("Out of memory error raised");
            	System.out.println(String.format("AFTER GC: softRefToO.get(): %s", softRefToO.get()));
        }
    } 
	
}
