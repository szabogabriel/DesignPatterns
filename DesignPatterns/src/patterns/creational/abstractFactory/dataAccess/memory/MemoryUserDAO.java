package patterns.creational.abstractFactory.dataAccess.memory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import patterns.creational.abstractFactory.dataAccess.dao.UserDAO;

public class MemoryUserDAO implements UserDAO {
	
	private final Map<String, String> USERS = new HashMap<>();
	
	{
		// init map here.
	}

	@Override
	public List<String> getUsernames() {
		return USERS.keySet().stream().collect(Collectors.toList());
	}

	@Override
	public boolean isCorrectCredentials(String username, String password) {
		return 
			username != null &&
			password != null &&
			password.equals(USERS.get(username));
	}

	@Override
	public void addUser(String username, String password) {
		if (username != null &&	password != null)
			USERS.put(username, password);
	}

	@Override
	public void removeUser(String username) {
		USERS.remove(username);
	}

	@Override
	public void changePassword(String username, String newPassword) {
		if (USERS.containsKey(username))
			USERS.put(username, newPassword);
	}

}
