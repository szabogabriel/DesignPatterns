package patterns.creational.objectpool;

import java.util.UUID;

public class ExpensiveResourcePool extends AbstractObjectPool {

	   public ExpensiveResourcePool(int size) {
	      super(size);
	   }

	   @Override
	   public ExpensiveResource createNew() {
	      return new ExpensiveResource(UUID.randomUUID().toString());
	   }
}
