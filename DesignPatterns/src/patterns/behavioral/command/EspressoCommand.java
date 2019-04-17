package patterns.behavioral.command;

public class EspressoCommand implements Command {
	private final CoffeeMachine coffeeMachine;
	
	public EspressoCommand (CoffeeMachine coffeMachine) {
		this.coffeeMachine = coffeMachine;
	}

	@Override
	public void execute() {
		coffeeMachine.createEspresso();

	}

}
