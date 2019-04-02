package patterns.behavioral.strategy.types;

import java.util.List;
import java.util.Map;

import patterns.behavioral.strategy.pojo.Document;
import patterns.behavioral.strategy.pojo.Topic;

public interface IWritingStrategy {
	void write(final Map<Topic, List<Document>> library);
}
