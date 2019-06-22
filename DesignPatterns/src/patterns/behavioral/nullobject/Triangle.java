package patterns.behavioral.nullobject;

public class Triangle implements IShape {

	@Override
	public int getLineCount() {
		return 3;
	}

	@Override
	public String getName() {
		return "Triangle";
	}
	

}
