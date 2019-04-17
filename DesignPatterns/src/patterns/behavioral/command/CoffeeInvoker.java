package patterns.behavioral.command;

import java.util.HashMap;

/**
 * Invoker Class that carries out the ordering of the coffee
 * @author vojtekbalazs
 *
 */
public class CoffeeInvoker {

	  private final HashMap<CoffeeType, Command> commandMap = new HashMap<>();
	  
	  public void register(CoffeeType coffeeType, Command command) {
	    commandMap.put(coffeeType, command);
	  }
	  
	  public void execute(CoffeeType coffeeType) {
	    Command command = commandMap.get(coffeeType);
	    if (command == null) {
	      throw new IllegalStateException("no command registered for " + coffeeType);
	    }
	    command.execute();
	  }
	
}
