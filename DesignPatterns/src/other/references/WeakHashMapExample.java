package other.references;

import java.util.WeakHashMap;

/**
 * <h1>WeakHashMap - Example of Usage</h1>
 * <p>
 * <ul>
 * 		<li>Hash table based implementation of the Map interface, with weak keys.</li>
 * 		<li>An entry in a WeakHashMap will automatically be removed when its key is no longer in ordinary use.</li>
 * 		<li>When a key has been discarded its entry is effectively removed from the map, so this class behaves somewhat differently from other Map implementations.</li>
 * 		<li>Both null values and the null key are supported.</li>
 * </ul>
 */
public class WeakHashMapExample {
	
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
        // Create 2 strong references and primary keys 
		ObjectWithFinalize o1 = new ObjectWithFinalize();
		Integer pk1 = new Integer(1);
		ObjectWithFinalize o2 = new ObjectWithFinalize();
		Integer pk2 = new Integer(2);
        
        // Insert them into WeakHashMap
		WeakHashMap<Integer, ObjectWithFinalize> weakHashMap = new WeakHashMap<>();
		weakHashMap.put(pk1, o1);
		weakHashMap.put(pk2, o2);
        System.out.println(String.format("weakHashMap.size() == %d", weakHashMap.size()));
        System.out.println(String.format("weakHashMap.containsKey(pk1) == %b", weakHashMap.containsKey(pk1)));
        System.out.println(String.format("weakHashMap.containsKey(pk2) == %b", weakHashMap.containsKey(pk2)));
          
        // Make o1 eligible for garbage collection by clearing its PK
        pk1 = null;  
		System.out.println("The primary key 'pk1' has been set to null. The primary key 'pk1' stays not null!");
        
        // Let's give GC a chance to collect it
        suggestGc();
        
        // Check if o1 has been finalized
        System.out.println(String.format("weakHashMap.size() == %d", weakHashMap.size()));
        System.out.println(String.format("weakHashMap.containsKey(pk2) == %b", weakHashMap.containsKey(pk2)));
    } 
}
