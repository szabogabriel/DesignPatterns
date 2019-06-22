package patterns.behavioral.nullobject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClient {
	
	private static List<IShape> shapeList = new ArrayList<IShape>();

	public static void main(String[] args) {

		Scanner scanner;
		String input = "";

		while (!"exit".equalsIgnoreCase(input)) {
			System.out.println();
			System.out.println("Enter your choice:");
			System.out.println("'s' for square");
			System.out.println("'t' for triangle");
			System.out.println("'sum' for sum of lines");
			System.out.println("'show' for showing list content");
			System.out.println("'exit' for exit app");

			scanner = new Scanner(System.in);
			if (scanner.hasNextLine()) {
				input = scanner.nextLine();
			}

			switch (input.toLowerCase()) {
				case "s":
					addShape(new Square());
					break;
				case "t":
					addShape(new Triangle());
					break;
				case "sum":
					printSum(shapeList);
					break;
				case "show":
					printList(shapeList);
					break;
				case "exit":
					System.out.println("Closing the application");
					break;
				default:
					addShape(new NoShape());
			}
		}
	}
	
	private static void addShape(IShape shape) {
		System.out.println("Added to list:" + shape.getName());
		shapeList.add(shape);
	}

	private static void printSum(List<IShape> shapeList) {
		int sum = 0;
		for (IShape shape : shapeList) {
			sum += shape.getLineCount();
		}
		System.out.println(sum);
	}

	private static void printList(List<IShape> shapeList) {
		int squareCount = 0;
		int triangleCount = 0;
		int unknownCount = 0;
		for (IShape shape : shapeList) {
			if (shape instanceof Square) {
				squareCount++;
			} else if (shape instanceof Triangle) {
				triangleCount++;
			} else if (shape instanceof NoShape) {
				unknownCount++;
			} else {
				new RuntimeException("Not handled shape in list");
			}
		}

		System.out.println("Squares:" + squareCount);
		System.out.println("Triangles:" + triangleCount);
		System.out.println("Invalid inputs:" + unknownCount);
	}

}
