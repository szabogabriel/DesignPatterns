package patterns.behavioral.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import patterns.behavioral.strategy.client.AbstractPerson;
import patterns.behavioral.strategy.client.CptDanko;
import patterns.behavioral.strategy.client.Developer;
import patterns.behavioral.strategy.client.Prism;
import patterns.behavioral.strategy.pojo.Document;
import patterns.behavioral.strategy.pojo.Topic;

public class Main {
	private final Map<Topic, List<Document>> library = new ConcurrentHashMap<>();
	
	public static void main(String[] args) {
		final Main strategyExample = new Main();
		
		strategyExample.buildLibrary();
		strategyExample.execute();
	}
	
	private void execute() {
		final AbstractPerson danko = new CptDanko();
		danko.useStrategy(this.library);
		
		final AbstractPerson prism = new Prism();
		prism.useStrategy(this.library);
		
		final AbstractPerson developer = new Developer();
		developer.useStrategy(this.library);
	}

	private void buildLibrary() {
		final List<Document> lawDocs = new ArrayList<>();
		lawDocs.add(new Document("Law for dummies"));
		lawDocs.add(new Document("How to understand book - Law for dummies"));
		this.library.put(Topic.LAW, lawDocs);
		
		final List<Document> itDocs = new ArrayList<>();
		itDocs.add(new Document("Design Patterns: Elements of Reusable Object-Oriented Software"));
		this.library.put(Topic.IT, itDocs);
		
		final List<Document> popDocs = new ArrayList<>();
		popDocs.add(new Document("I won't be here in 2014"));
		popDocs.add(new Document("How to work for people"));
		this.library.put(Topic.POP, popDocs);
	}
}
