package patterns.behavioral.command;

/**
 * Class responsible for the making of coffee
 * @author vojtekbalazs
 *
 */
public class CoffeeMachine {
	private boolean coffee=true;
	private boolean milk=false;
	private boolean steam=false;
	
	public CoffeeMachine() {
		
	}
	
	/** 
	 * Creates simple coffee, no milk, no magic
	 */
	public void createEspresso() {
		System.out.println("Making simple black coffee");
		System.out.println("coffee:" + coffee + ", milk:" + milk + ", steam:" + steam);
	}
	
	/**
	 * Creates a capuccino 
	 */
	public void createCapuccino() {
		milk=true;
		steam=true;
		System.out.println("Making capuccino" );
		System.out.println("coffee:" + coffee + ", milk:" + milk + ", steam:" + steam);
	}
	
	/**
	 * Creates coffee with milk
	 */
	public void createCoffeWithMilk() {
		milk=true;
		steam=false;
		System.out.println("Making coffe with milk" );
		System.out.println("coffee:" + coffee + ", milk:" + milk + ", steam:" + steam);
	}

}
