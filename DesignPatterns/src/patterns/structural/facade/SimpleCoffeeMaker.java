package patterns.structural.facade;

import patterns.structural.facade.machine.CoffeeDispenser;
import patterns.structural.facade.machine.CupHolder;
import patterns.structural.facade.machine.MilkDispenser;
import patterns.structural.facade.machine.SugarDispenser;
import patterns.structural.facade.machine.WaterHeater;

public class SimpleCoffeeMaker {
	
	private CoffeeDispenser coffeeDispenser;
	private WaterHeater waterHeater;
	private SugarDispenser sugarDispenser;
	private CupHolder cupHolder;
	private MilkDispenser milkDispenser;
	
	public SimpleCoffeeMaker() {
		coffeeDispenser = new CoffeeDispenser();
		waterHeater = new WaterHeater();
		sugarDispenser = new SugarDispenser();
		cupHolder = new CupHolder();
		milkDispenser = new MilkDispenser();
	}

	public void makeCapuccino(boolean addSugar) {
		System.out.println("SimpleCoffeeMaker - making capuccino - started");
		cupHolder.releaseCup();
		coffeeDispenser.disperseCoffee();
		milkDispenser.addMilk();
		waterHeater.heatWater();
		waterHeater.pourWater();
		if (addSugar) sugarDispenser.addSugar();
		System.out.println("SimpleCoffeeMaker - making capuccino - finished");
	}
	
	public void makePresso(boolean addSugar) {
		System.out.println("SimpleCoffeeMaker - making presso - started");
		cupHolder.releaseCup();
		coffeeDispenser.disperseCoffee();
		waterHeater.heatWater();
		waterHeater.pourWater();
		if (addSugar) sugarDispenser.addSugar();
		milkDispenser.addMilk();
		System.out.println("SimpleCoffeeMaker - making presso - finished");
	}
	
	public void clean() {
		System.out.println("SimpleCoffeeMaker - cleaning - started");
		waterHeater.heatWater();
		waterHeater.pourWater();
		System.out.println("SimpleCoffeeMaker - cleaning - finished");
	}
	
}
