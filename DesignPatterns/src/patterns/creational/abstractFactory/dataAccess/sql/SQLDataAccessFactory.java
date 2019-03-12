package patterns.creational.abstractFactory.dataAccess.sql;

import java.sql.Connection;

import patterns.creational.abstractFactory.dataAccess.DataAccess;
import patterns.creational.abstractFactory.dataAccess.dao.ConfigurationDAO;
import patterns.creational.abstractFactory.dataAccess.dao.UserDAO;

public class SQLDataAccessFactory implements DataAccess {
	
	private Connection CONNECTION = null;
	
	public SQLDataAccessFactory() {
		CONNECTION = getConnection();
	}
	
	private Connection getConnection() {
		//TODO: acquire connection here.
		return null;
	}

	@Override
	public ConfigurationDAO getConfigurationDAO() {
		return new SQLConfigurationDAO(CONNECTION);
	}

	@Override
	public UserDAO getUserDAO() {
		return new SQLUserDAO(CONNECTION);
	}

}
