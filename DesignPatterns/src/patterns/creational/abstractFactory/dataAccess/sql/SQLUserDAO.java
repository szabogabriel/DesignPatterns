package patterns.creational.abstractFactory.dataAccess.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import patterns.creational.abstractFactory.dataAccess.dao.UserDAO;

public class SQLUserDAO implements UserDAO {
	
	private Connection CONNECTION;
	
	public SQLUserDAO(Connection dbConnection) {
		CONNECTION = dbConnection;
	}

	@Override
	public List<String> getUsernames() {
		List<String> ret = new ArrayList<>();
		
		try (PreparedStatement ps = CONNECTION.prepareStatement("SELECT USERNAME FROM USERS;");
				ResultSet rs = ps.executeQuery()) {
			while (rs.next())
				ret.add(rs.getString(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ret;
	}

	@Override
	public boolean isCorrectCredentials(String username, String password) {
		if (username != null && password != null) {
			String acquiredPassword = null;
			try (PreparedStatement ps = CONNECTION.prepareStatement("SELECT PASSWORD FROM USERS WHERE USERNAME=?;")) {
				ps.setString(1, username);
				try (ResultSet rs = ps.executeQuery()) {
					while (rs.next())
						acquiredPassword = rs.getString(1);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return acquiredPassword != null && acquiredPassword.equals(password);
		}
		return false;
	}

	@Override
	public void addUser(String username, String password) {
		if (username != null && password != null) {
			try (PreparedStatement ps = CONNECTION.prepareStatement("INSERT INTO USERS (USERNAME, PASSWORD) VALUES (?, ?);")) {
				ps.setString(1, username);
				ps.setString(2, password);
				ps.executeUpdate();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void removeUser(String username) {
		if (username != null) {
			try (PreparedStatement ps = CONNECTION.prepareStatement("DELETE FROM USERS WHERE USERNAME=?;")) {
				ps.setString(1, username);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void changePassword(String username, String newPassword) {
		if (username != null && newPassword != null) {
			try (PreparedStatement ps = CONNECTION.prepareStatement("UPDATE USERS SET PASSWORD=? WHERE USERNAME=?;")) {
				ps.setString(1, newPassword);
				ps.setString(2, username);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
