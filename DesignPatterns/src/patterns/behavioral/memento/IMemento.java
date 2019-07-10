package patterns.behavioral.memento;

import java.time.Instant;
import java.time.LocalDate;

public interface IMemento {

	Instant getTimestamp();
	
	String getSnapshotname();
}
