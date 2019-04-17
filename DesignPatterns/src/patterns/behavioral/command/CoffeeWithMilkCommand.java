package patterns.behavioral.command;

public class CoffeeWithMilkCommand implements Command {
	private final CoffeeMachine coffeeMachine;
	
	public CoffeeWithMilkCommand (CoffeeMachine coffeMachine) {
		this.coffeeMachine = coffeMachine;
	}

	@Override
	public void execute() {
		coffeeMachine.createCoffeWithMilk();

	}

}
