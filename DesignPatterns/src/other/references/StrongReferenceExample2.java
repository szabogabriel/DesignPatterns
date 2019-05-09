package other.references;

import java.lang.ref.Reference;

/**
 * <h1>Strong Reference</h1>
 * <p>
 * <ul>
 * 		<li>This is a default type/class of {@link Reference} Object</li>
 * 		<li>Any object which has an active strong reference are not eligible for garbage collection</li>
 * 		<li>The object is garbage collected only when the variable which was strongly referenced points to {@code null}</li>
 * </ul>
 */
public class StrongReferenceExample2 {
	
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
		System.out.println(String.format("Our instance: %s", o));
    
		// Let's create a strong reference
		ObjectWithFinalize strongRefToO = o;
		
        // Now, object to which 'o' was pointing earlier is  
        // eligible for garbage collection. 
        o = null;
		System.out.println("The strong reference 'o' has been set to null. The strong reference 'strongRefToO' stays active!");
        
        // Let's verify GC won't finalize the object 'o'
        // as still have a strong reference (strongRefToO) to it
        suggestGc();
        System.out.println(String.format("Our strong reference 'strongRefToO' is still valid: %s", strongRefToO));
    } 
}
