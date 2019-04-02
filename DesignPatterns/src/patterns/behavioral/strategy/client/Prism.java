package patterns.behavioral.strategy.client;

import patterns.behavioral.strategy.types.DirectionStrategy;

public class Prism extends AbstractPerson {

	public Prism() {
		super(new DirectionStrategy());
	}
}
