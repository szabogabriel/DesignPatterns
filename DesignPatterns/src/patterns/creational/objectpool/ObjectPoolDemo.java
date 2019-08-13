package patterns.creational.objectpool;

public class ObjectPoolDemo {

	public static void main(String[] args) {
		final ExpensiveResourcePool pool = new ExpensiveResourcePool(3);
		
	      System.out.println("Simple usage");
	      System.out.println();
	      System.out.println("Pool size:" + pool.size());
			
	      /* simple usage - get the object */
	      IPoolableObject obj0 = pool.getObject();
	      /* simple usage - use the object */
	      obj0.doSomething();
			
	      /* to check that the object was removed from the pool */
	      System.out.println("Pool size:" + pool.size());
			
	      /* simple usage - return the object */
	      pool.releaseObject(obj0);
	      
	      System.out.println("Resource returned");
	      System.out.println("Pool size:" + pool.size());
	      
	      System.out.println();
	      System.out.println("extended usage");
	      System.out.println();
			
	      
	      final IPoolableObject obj1 = pool.getObject();
	      IPoolableObject obj2 = pool.getObject();
	      IPoolableObject obj3 = pool.getObject();
			
	      /* to check that the object was removed from the pool */
	      System.out.println("Pool size:" + pool.size());
	      obj1.doSomething();
	      obj2.doSomething();
	      obj3.doSomething();
			
	      /* create a new thread to simulate the long operation for obj1 - this will avoid blocking the test app */
	      Runnable exec = new Runnable() {
					
	         @Override
	         public void run() {
	            try {
	               Thread.sleep(10 * 1000);
	            } catch (InterruptedException e)	{
	               e.printStackTrace();
	            }
	            pool.releaseObject(obj1);
	            System.out.println("Resource returned");
	         }
	      };
	      Thread thread = new Thread(exec);
	      thread.start();	
			
	      /* will wait until the thread will finish and will return the object to the pool - 10 sec 
	       * will be the same object as for obj1.
	       */
	      System.out.println("Pool size:" + pool.size());
	      System.out.println("Getting resource");
	      IPoolableObject obj4 = pool.getObject();
	      obj4.doSomething();
			
	      /*return all objects to the pool */
	      pool.releaseObject(obj4);
	      pool.releaseObject(obj2);
	      pool.releaseObject(obj3);
			
	      /* check the pool size */
	      System.out.println("Pool size:" + pool.size());
			
	      /* shutdown the pool*/
	      pool.shutdown();
			
	      /* check the pool size */
	      System.out.println("Pool size:" + pool.size());

	}

}
