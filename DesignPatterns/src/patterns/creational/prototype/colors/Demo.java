package patterns.creational.prototype.colors;

class Demo
{
	public static void main (String[] args)
	{
		ColorStore.getColor("blue").addColor();
		ColorStore.getColor("black").addColor();
		ColorStore.getColor("black").addColor();
		ColorStore.getColor("blue").addColor();
	}
}
