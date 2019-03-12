package patterns.creational.abstractFactory.dataAccess;

import patterns.creational.abstractFactory.dataAccess.memory.MemoryDataAccessFactory;
import patterns.creational.abstractFactory.dataAccess.sql.SQLDataAccessFactory;

public class DataAccessFactory {
	
	// Create the abstract factory.
	public static DataAccess create() {
		DataAccess ret = null;
		
		switch (Main.DATA_PERSISTANCE) {
		case "MEMORY"	: ret = createMemoryDataAccess();
		case "SQL"		: ret = createSQLDataAccess();
		}
		
		return ret;
	}
	
	private static DataAccess createMemoryDataAccess() {
		return MemoryDataAccessFactory.INSTANCE;
	}
	
	private static DataAccess createSQLDataAccess() {
		return new SQLDataAccessFactory();
	}

}
