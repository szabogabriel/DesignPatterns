package patterns.behavioral.memento;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DietCaretaker {

	private static DietCaretaker instance;
	
	private List<IMemento> mementoList = new ArrayList<>();
	
	
	public static synchronized DietCaretaker getIntance() {
		if (instance==null) {
			instance = new DietCaretaker();
		}
		
		return instance;
	}
	
	private DietCaretaker() {
		
	}
	
	public void undo(DietInfoOriginator dietInfo) {
		mementoList.stream().sorted(Comparator.comparing(IMemento::getTimestamp).reversed()).findFirst().ifPresent(m->dietInfo.restore(m));
	}

	public void undo(DietInfoOriginator dietInfo, String snapshotName) {
		mementoList.stream().filter(m->m.getSnapshotname()!=null && m.getSnapshotname().equals(snapshotName)).findFirst().ifPresent(m->dietInfo.restore(m));		
	}
	
	public void doSomething(DietInfoOriginator dietInfo) {		
		mementoList.add(dietInfo.save());
	}

	public void doSomething(DietInfoOriginator dietInfo, String snapshotName) {		
		mementoList.add(dietInfo.save(snapshotName));
	}

	
}
