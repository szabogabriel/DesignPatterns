package patterns.behavioral.memento;

import java.time.Instant;
import java.time.LocalDate;

public class DietMemento implements IMemento {

	private String personName;
	
	private int weight;
	
	private int calories;
	
	private LocalDate dietDate;

	private String snapshotName;
	
	private Instant timestamp;
	
	public DietMemento(String personName, int weight, int calories, LocalDate dietDate, String snapshotName) {
		this.personName = personName;
		this.weight = weight;
		this.calories = calories;
		this.dietDate = dietDate;
		this.snapshotName = snapshotName;
		
		timestamp = Instant.now();
	}

	public String getPersonName() {
		return personName;
	}

	public int getWeight() {
		return weight;
	}

	public int getCalories() {
		return calories;
	}

	public LocalDate getDietDate() {
		return dietDate;
	}

	@Override
	public String getSnapshotname() {
		return snapshotName;
	}

	@Override
	public Instant getTimestamp() {
		return timestamp;
	}
	
	
}
