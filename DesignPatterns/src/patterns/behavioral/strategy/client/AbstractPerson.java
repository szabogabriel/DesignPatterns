package patterns.behavioral.strategy.client;

import java.util.List;
import java.util.Map;

import patterns.behavioral.strategy.pojo.Document;
import patterns.behavioral.strategy.pojo.Topic;
import patterns.behavioral.strategy.types.IWritingStrategy;

public abstract class AbstractPerson {
	private IWritingStrategy writingStrategy;

	public AbstractPerson(IWritingStrategy writingStrategy) {
		this.writingStrategy = writingStrategy;
	}
	
	public void useStrategy(final Map<Topic, List<Document>> library) {
		this.writingStrategy.write(library);
	}
}
