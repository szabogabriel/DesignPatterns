package patterns.creational.abstractFactory.dataAccess;

import patterns.creational.abstractFactory.dataAccess.memory.MemoryDataAccessFactory;
import patterns.creational.abstractFactory.dataAccess.sql.SQLDataAccessFactory;

public class DataAccessFactory {
	
	// Create the abstract factory.
	public static DataAccess create() {
		DataAccess ret = decide();
		
		return ret;
	}
	
	private static DataAccess decide() { 
		switch (Main.DATA_PERSISTANCE) {
		case "MEMORY"	: return MemoryDataAccessFactory.INSTANCE;
		case "SQL"		: return new SQLDataAccessFactory();
		default			: return null;
		}
	}

}
