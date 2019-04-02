package patterns.behavioral.strategy.types;

import java.util.List;
import java.util.Map;

import patterns.behavioral.strategy.pojo.Document;
import patterns.behavioral.strategy.pojo.Topic;

public class WiseManStrategy implements IWritingStrategy {

	@Override
	public void write(final Map<Topic, List<Document>> library) {
		System.out.println("Wise man strategy");
		
		for (Document doc : library.get(Topic.IT)) {
			System.out.println("I've read and understood: " + doc.getName());
		}
		
		System.out.println("");
	}

}
