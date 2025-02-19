package com.jtc.dao;

import java.sql.*;

import com.jtc.dbconnection.DBConnection;
import com.jtc.model.User;

public class UserDAO {
	
	private Connection conn;

    public UserDAO() {
        try {
            conn = DBConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to add a new user (admin or other users)
    public boolean addUser(User user) {
        String query = "INSERT INTO users (user_id, password) VALUES (?, ?)";
        try (PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setLong(1, user.getUserId());
            pst.setString(2, user.getPassword());
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Method to get a user by their ID
    public User getUserById(String userId) {
        String query = "SELECT * FROM users WHERE user_id = ?";
        try (PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setString(1, userId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new User(rs.getLong("user_id"), rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to authenticate a user
    public boolean authenticateUser(String userId, String password) {
        String query = "SELECT * FROM users WHERE user_id = ? AND password = ?";
        try (PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setString(1, userId);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            return rs.next(); // Returns true if user is found with matching credentials
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Method to update user password
    public boolean updateUserPassword(String userId, String newPassword) {
        String query = "UPDATE users SET password = ? WHERE user_id = ?";
        try (PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setString(1, newPassword);
            pst.setString(2, userId);
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Method to delete a user
    public boolean deleteUser(String userId) {
        String query = "DELETE FROM users WHERE user_id = ?";
        try (PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setString(1, userId);
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

	public void close() {
		// TODO Auto-generated method stub
		
	}
}


