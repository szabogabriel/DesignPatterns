package other.references;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * <h1>Phantom Reference</h1>
 * <p>
 * <ul>
 * 		<li>If the garbage collector determines at a certain point in time that the referent of a phantom reference is phantom reachable, 
 * then at that time or at some later time it will enqueue the reference.</li> 
 * 		<li>To create such references {@link PhantomReference} and {@link ReferenceQueue} classes are used.</li>
 * 		<li>In order to ensure that a reclaimable object remains so, the referent of a phantom reference may not be retrieved.
 * The get method of a phantom reference always returns {@code null}. </li>
 * 		<li>Phantom references are most often used for scheduling pre-mortem cleanup actions in a more flexible way than is possible with the Java finalization mechanism.</li>
 * 		<li>Unlike soft and weak references, phantom references are not automatically cleared by the garbage collector as they are enqueued.</li>
 * </ul>
 */
public class PhantomReferenceExample {
	
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
        
        // Let's create a Weak Reference to the object to which 'o' is also pointing. 
        ReferenceQueue<ObjectWithFinalize> referenceQueue = new ReferenceQueue<>();
        PhantomReference<ObjectWithFinalize> phantomRefToSb = new PhantomReference<>(o, referenceQueue);
        
        // We cannot retrieve back the object through the phantom reference. NEVER.
        // But we can find out if it has been enqueued by GC.
        System.out.println(String.format("BEFORE GC: Get allways returns null: %s", phantomRefToSb.get()));
        System.out.println(String.format("BEFORE GC: Is object enqueued by GC: %b", phantomRefToSb.isEnqueued()));
        System.out.println(String.format("BEFORE GC: referenceQueue.poll: %s", referenceQueue.poll()));

        // Now, let's loose the strong reference, the object to which 'o' was pointing earlier 
        // will be eligible for garbage collection.
        o = null;  

        // Let's give GC a chance to collect it
        suggestGc();
        
        // Let's check if GC enqueued the phantom reference
        System.out.println(String.format("AFTER GC: Get allways returns null: %s", phantomRefToSb.get()));
        System.out.println(String.format("AFTER GC: Is object enqueued by GC: %b", phantomRefToSb.isEnqueued()));
        System.out.println(String.format("AFTER GC: referenceQueue.poll: %s", referenceQueue.poll()));
        System.out.println(String.format("AFTER GC: 2nd call of referenceQueue.poll: %s", referenceQueue.poll()));
    } 
}
