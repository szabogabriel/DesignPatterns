package patterns.behavioral.command;

/** 
 * Command class for making a capuccino
 * @author vojtekbalazs
 *
 */
public class CapuccinoCommand implements Command {
	private final CoffeeMachine coffeeMachine;
	
	public CapuccinoCommand (CoffeeMachine coffeeMachine) {
		this.coffeeMachine = coffeeMachine;
	}

	@Override
	public void execute() {
		coffeeMachine.createCapuccino();

	}

}
