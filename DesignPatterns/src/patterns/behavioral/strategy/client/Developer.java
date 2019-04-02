package patterns.behavioral.strategy.client;

import patterns.behavioral.strategy.types.WiseManStrategy;

public class Developer extends AbstractPerson {

	public Developer() {
		super(new WiseManStrategy());
	}
}
