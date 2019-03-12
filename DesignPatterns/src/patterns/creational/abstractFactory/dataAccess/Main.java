package patterns.creational.abstractFactory.dataAccess;

import java.util.List;

import patterns.creational.abstractFactory.dataAccess.dao.ConfigurationDAO;
import patterns.creational.abstractFactory.dataAccess.dao.UserDAO;

public class Main {
	
	public static String DATA_PERSISTANCE = "MEMORY"; //SQL, MEMORY
	
	public static void main(String [] args) {
		DataAccess dataAccess = DataAccess.Factory.create();
		
		testConf(dataAccess);
		
		testUser(dataAccess);
	}
	
	private static void testConf(DataAccess dataAccess) {
		ConfigurationDAO configurationDao = dataAccess.getConfigurationDAO();
		
		System.out.println("--- Config ---");
		configurationDao.add("key1", "value1");
		System.out.println("Original " + configurationDao.getValue("key1"));
		
		configurationDao.update("key1", "value2");
		System.out.println("Changed " + configurationDao.getValue("key1"));
		
		List<String> confKeys = configurationDao.getKeys();
		for (String it : confKeys) 
			System.out.println("Keys: " + it);
		
		configurationDao.remove("key1");
		String val = configurationDao.getValue("key1");
		System.out.println("Value removed: " + (val == null));
	}
	
	private static void testUser(DataAccess dataAccess) {
		System.out.println("--- Users ---");
		
		UserDAO userDao = dataAccess.getUserDAO();		
		userDao.addUser("user1", "password1");
		System.out.println("Is valid (unchanged): " + userDao.isCorrectCredentials("user1", "password1"));
		System.out.println("Is valid (shouldn't): " + userDao.isCorrectCredentials("user1", "xxxxxxxxx"));
		
		userDao.changePassword("user1", "password2");
		System.out.println("Is valid (changed): " + userDao.isCorrectCredentials("user1", "password2"));
		
		List<String> names = userDao.getUsernames();
		for (String it : names)
			System.out.println("Names: " + it);
		
		userDao.removeUser("user1");
		System.out.println("Value removed: " + (userDao.getUsernames().size() == 0));
	}

}
