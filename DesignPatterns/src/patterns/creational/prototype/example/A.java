package patterns.creational.prototype.example;

public class A implements Cloneable {

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}


}

class B {
	A klon;

	public B(A a) throws CloneNotSupportedException {
		klon = (A) a.clone();
	}
}
