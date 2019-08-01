package patterns.structural.facade;

public class ThirstyClientDemo {
	
	public static void main(String[] args) {
		SimpleCoffeeMaker coffeeMaker = new SimpleCoffeeMaker();
		coffeeMaker.makeCapuccino(true);
		coffeeMaker.clean();
		coffeeMaker.makePresso(false);
	}
	
}
