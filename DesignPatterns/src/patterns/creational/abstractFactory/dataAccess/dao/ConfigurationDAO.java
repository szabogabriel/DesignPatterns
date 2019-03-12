package patterns.creational.abstractFactory.dataAccess.dao;

import java.util.List;

public interface ConfigurationDAO {
	
	List<String> getKeys();
	
	String getValue(String key);
	
	void add(String key, String value);
	
	void update(String key, String value);
	
	void remove(String key);

}
