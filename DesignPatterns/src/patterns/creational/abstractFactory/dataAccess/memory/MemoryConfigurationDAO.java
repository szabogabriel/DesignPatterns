package patterns.creational.abstractFactory.dataAccess.memory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import patterns.creational.abstractFactory.dataAccess.dao.ConfigurationDAO;

public class MemoryConfigurationDAO implements ConfigurationDAO {
	
	private final Map<String, String> CONFIGS = new HashMap<>();
	
	{
		//INIT configuration map here.
	}

	@Override
	public List<String> getKeys() {
		return CONFIGS.keySet().stream().collect(Collectors.toList());
	}

	@Override
	public String getValue(String key) {
		return CONFIGS.get(key);
	}

	@Override
	public void add(String key, String value) {
		CONFIGS.put(key, value);
	}
	
	@Override
	public void update(String key, String value) {
		CONFIGS.put(key, value);
	}

	@Override
	public void remove(String key) {
		CONFIGS.remove(key);
	}

}
