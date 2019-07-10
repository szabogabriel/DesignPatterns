package patterns.behavioral.memento;

import java.time.LocalDate;

public class DietInfoOriginator {

	private String personName;
	
	private int weight;
	
	private int calories;
	
	private LocalDate dietDate;
	
	private int salary;
	
	public DietInfoOriginator(String personName, int weight, int calories, LocalDate dietDate, int salary) {
		this.personName = personName;
		this.weight = weight;
		this.calories = calories;
		this.dietDate = dietDate;
		this.salary = salary;
	}

	public void set( int weight, int calories, LocalDate dietDate, int salary) {
		this.weight = weight;
		this.calories = calories;
		this.dietDate = dietDate;
		this.salary = salary;
	}
	
	
	public IMemento save() {
		DietMemento dm = new DietMemento(personName, weight, calories, dietDate, null);
		return dm;
	}

	public IMemento save(String snapshotName) {
		DietMemento dm = new DietMemento(personName, weight, calories, dietDate, snapshotName);
		return dm;
	}

	
	public void restore(IMemento m) {
		DietMemento dm = (DietMemento)m;
		this.personName = dm.getPersonName();
		this.weight = dm.getWeight();
		this.calories = dm.getCalories();
		this.dietDate = dm.getDietDate();
	}
	

	

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Diet Info of ");
		sb.append("\nPerson ").append(personName).append("\n Details - ").append("Weight: ").append(weight).append(", Calories: ").append(calories).
		append(", Diet date: ").append(dietDate).append("\nSalary: ").append(salary);
		return sb.toString();
	}
}
