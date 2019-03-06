package patterns.creational.singleton.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class Test {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		testCorrect();
		testIncorrect();
	}
	
	private static void testCorrect() throws FileNotFoundException, IOException, ClassNotFoundException {
		File tmpFile = new File("/tmp/correct.ser");
		CorrectSerializableSingleton instanceOne = CorrectSerializableSingleton.getInstance();
		ObjectOutput out = new ObjectOutputStream(new FileOutputStream(tmpFile));
		out.writeObject(instanceOne);
		out.close();

		ObjectInput in = new ObjectInputStream(new FileInputStream(tmpFile));
		CorrectSerializableSingleton instanceTwo = (CorrectSerializableSingleton) in.readObject();
		in.close();

		System.out.println("correctInstanceOne hashCode=" + instanceOne.hashCode());
		System.out.println("correctInstanceTwo hashCode=" + instanceTwo.hashCode());
	}
	
	private static void testIncorrect() throws FileNotFoundException, IOException, ClassNotFoundException {
		File tmpFile = new File("/tmp/incorrect.ser");
		IncorrectSerializableSingleton instanceOne = IncorrectSerializableSingleton.getInstance();
		ObjectOutput out = new ObjectOutputStream(new FileOutputStream(tmpFile));
		out.writeObject(instanceOne);
		out.close();

		ObjectInput in = new ObjectInputStream(new FileInputStream(tmpFile));
		IncorrectSerializableSingleton instanceTwo = (IncorrectSerializableSingleton) in.readObject();
		in.close();

		System.out.println("incorrectInstanceOne hashCode=" + instanceOne.hashCode());
		System.out.println("incorrectInstanceTwo hashCode=" + instanceTwo.hashCode());
		
		tmpFile.delete();
	}

}
