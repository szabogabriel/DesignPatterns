package patterns.behavioral.strategy.types;

import java.util.List;
import java.util.Map;

import patterns.behavioral.strategy.pojo.Document;
import patterns.behavioral.strategy.pojo.Topic;

public class DirectionStrategy implements IWritingStrategy {

	@Override
	public void write(final Map<Topic, List<Document>> library) {
		System.out.println("Direction strategy");
		for (Document doc : library.get(Topic.POP)) {
			System.out.println("Blame Radicova and don't read: " + doc.getName());
		}
		
		System.out.println("");
	}

}
