package patterns.behavioral.nullobject;

public class Square implements IShape {

	@Override
	public int getLineCount() {
		return 4;
	}

	@Override
	public String getName() {
		return "Square";
	}
	

}
