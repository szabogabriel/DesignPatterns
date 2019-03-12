package patterns.creational.abstractFactory.dataAccess.dao;

import java.util.List;

public interface UserDAO {
	
	List<String> getUsernames();
	
	boolean isCorrectCredentials(String username, String password);
	
	void addUser(String username, String password);
	
	void removeUser(String username);
	
	void changePassword(String username, String newPassword);

}
