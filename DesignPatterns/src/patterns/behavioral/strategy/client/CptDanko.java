package patterns.behavioral.strategy.client;

import patterns.behavioral.strategy.types.CptDantkoStrategy;

public class CptDanko extends AbstractPerson {

	public CptDanko() {
		super(new CptDantkoStrategy());
	}
}
