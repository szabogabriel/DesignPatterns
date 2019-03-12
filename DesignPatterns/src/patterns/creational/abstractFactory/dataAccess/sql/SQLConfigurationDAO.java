package patterns.creational.abstractFactory.dataAccess.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import patterns.creational.abstractFactory.dataAccess.dao.ConfigurationDAO;

public class SQLConfigurationDAO implements ConfigurationDAO {
	
	private Connection CONNECTION;
	
	public SQLConfigurationDAO(Connection dbConnection) {
		CONNECTION = dbConnection;
	}

	@Override
	public List<String> getKeys() {
		List<String> ret = new ArrayList<>();
		
		try (PreparedStatement ps = CONNECTION.prepareStatement("SELECT KEY FROM CONFIGURATION;"); ResultSet rs = ps.executeQuery()){
			while (rs.next()) {
				ret.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ret;
	}

	@Override
	public String getValue(String key) {
		String ret = "";
		
		try (PreparedStatement ps = CONNECTION.prepareStatement("SELECT VALUE FROM CONFIGURATION WHERE KEY=?;")) {
			ps.setString(1, key);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					ret = rs.getString(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ret;
	}

	@Override
	public void add(String key, String value) {
		try (PreparedStatement ps = CONNECTION.prepareStatement("INSERT INTO CONFIGURATION (KEY, VALUE) VALUES (?, ?);")) {
			ps.setString(1, key);
			ps.setString(2, value);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void update(String key, String value) {
		try (PreparedStatement ps = CONNECTION.prepareStatement("UPDATE CONFIGURATION SET VALUE=? WHERE KEY=?;")) {
			ps.setString(1, value);
			ps.setString(2, key);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remove(String key) {
		try (PreparedStatement ps = CONNECTION.prepareStatement("REMOVE FROM CONFIGURATION WHERE KEY=?;")) {
			ps.setString(1, key);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
