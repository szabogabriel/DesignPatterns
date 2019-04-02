package patterns.behavioral.strategy.types;

import java.util.List;
import java.util.Map;

import patterns.behavioral.strategy.pojo.Document;
import patterns.behavioral.strategy.pojo.Topic;

public class CptDantkoStrategy implements IWritingStrategy {

	@Override
	public void write(final Map<Topic, List<Document>> library) {
		System.out.println("Captain Danko strategy");
		
		for (Document doc : library.get(Topic.LAW)) {
			System.out.println("I've copied text from: " + doc.getName());
		}
		
		System.out.println("");
	}

}
