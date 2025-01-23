package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import PatternSingleton.DatabaseConnection;

public class user {
	public boolean validateUser(String username, String password) throws ClassNotFoundException {
        try {
    		Connection c = DatabaseConnection.getInstance().getConnection();
            String query = "SELECT * FROM user WHERE login = ? AND mdp = ?";
            PreparedStatement stmt = c.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); 
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
