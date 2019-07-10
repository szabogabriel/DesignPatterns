package patterns.behavioral.memento;

import java.time.LocalDate;

public class MementoDemo {

	public static void main(String[] args) throws InterruptedException {
		
		//first day
		DietInfoOriginator dietInfo = new DietInfoOriginator("Karol", 50, 1000, LocalDate.now(), 100);
		
		//store first day
		DietCaretaker.getIntance().doSomething(dietInfo);
		
		System.out.println("Day 1: " + dietInfo);
		
		
		Thread.sleep(100);

		//second day
		
		dietInfo.set(60, 2000, LocalDate.now().plusDays(1), 150);

		//store second day
		DietCaretaker.getIntance().doSomething(dietInfo, "DAY2");

		System.out.println("Day 2: " + dietInfo);
		

		Thread.sleep(100);

		//third day
		dietInfo.set(70, 3000, LocalDate.now().plusDays(2), 200);
		
		//store third day
		DietCaretaker.getIntance().doSomething(dietInfo);

		System.out.println("Day 3: " + dietInfo);
		
		
		Thread.sleep(100);

		//fourth day
		dietInfo.set(80, 4000, LocalDate.now().plusDays(3), 250);
		
		System.out.println("Day 4: " + dietInfo);

		
		//Undo
		DietCaretaker.getIntance().undo(dietInfo);
		
		System.out.println();
		System.out.println("Undo: " + dietInfo);

		//Undo to snapshot name DAY2
		DietCaretaker.getIntance().undo(dietInfo, "DAY2");

		System.out.println();
		System.out.println("Undo to Snapshot DAY2: " + dietInfo);

	}
}
