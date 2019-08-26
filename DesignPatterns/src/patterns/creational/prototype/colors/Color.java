package patterns.creational.prototype.colors;

abstract class Color implements Cloneable
{

	protected String colorName;

	abstract void addColor();

	public Object clone()
	{
		Object clone = null;
		try {
			clone = super.clone();
		} finally {
			return clone;
		}
	}
}

