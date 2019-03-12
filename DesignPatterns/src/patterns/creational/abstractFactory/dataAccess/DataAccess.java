package patterns.creational.abstractFactory.dataAccess;

import patterns.creational.abstractFactory.dataAccess.dao.ConfigurationDAO;
import patterns.creational.abstractFactory.dataAccess.dao.UserDAO;

public interface DataAccess {
	
	ConfigurationDAO getConfigurationDAO();
	
	UserDAO getUserDAO();
	
}
