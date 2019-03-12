package patterns.creational.abstractFactory.dataAccess.memory;

import patterns.creational.abstractFactory.dataAccess.DataAccess;
import patterns.creational.abstractFactory.dataAccess.dao.ConfigurationDAO;
import patterns.creational.abstractFactory.dataAccess.dao.UserDAO;

public final class MemoryDataAccessFactory implements DataAccess {
	
	public static final MemoryDataAccessFactory INSTANCE = new MemoryDataAccessFactory();
	
	private final ConfigurationDAO CONFIG = new MemoryConfigurationDAO();
	private final UserDAO USER = new MemoryUserDAO();
	
	private MemoryDataAccessFactory() {
		init();
	}
	
	private void init() {
		CONFIG.add("defaultKey1", "defaultValue1");
		USER.addUser("admin", "admin");
	}

	@Override
	public ConfigurationDAO getConfigurationDAO() {
		return CONFIG;
	}

	@Override
	public UserDAO getUserDAO() {
		return USER;
	}
	
}
