package patterns.behavioral.command;

public class CoffeeDemo {
	
	public CoffeeDemo() {
		
	}
	
	public static void main (final String[] args) {
		CoffeeMachine coffeeMachine = new CoffeeMachine();
		
		Command espresso = new EspressoCommand(coffeeMachine);
		Command withMilk = new CoffeeWithMilkCommand(coffeeMachine);
		Command capuccino = new CapuccinoCommand(coffeeMachine);
		
		CoffeeInvoker invoker = new CoffeeInvoker();
		
		invoker.register(CoffeeType.ESPRESSO, espresso);
		invoker.register(CoffeeType.MILK, withMilk);
		invoker.register(CoffeeType.CAPUCCINO, capuccino);
		
		invoker.execute(CoffeeType.ESPRESSO);
		invoker.execute(CoffeeType.MILK);
		invoker.execute(CoffeeType.CAPUCCINO);
		invoker.execute(CoffeeType.MILK);
		invoker.execute(CoffeeType.ESPRESSO);
		
		
		
	}

}
