package com.jtc.dao;

import java.sql.*;
import java.util.*;

import com.jtc.dbconnection.DBConnection;
import com.jtc.model.Client;

public class ClientDAO {
	
	private Connection conn;

    public ClientDAO() {
        try {
            conn = DBConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to add a new client
    public boolean addClient(Client client) {
        String query = "INSERT INTO client (name, relationship_date) VALUES (?, ?)";
        try (PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setString(1, client.getClientname());
            pst.setString(2, client.getClientrelationshipDate());
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Method to get a client by their ID
    public Client getClientById(long clientId) {
        String query = "SELECT * FROM client WHERE client_id = ?";
        try (PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setLong(1, clientId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new Client(rs.getLong("client_id"), rs.getString("name"),
                        rs.getString("relationship_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to get all clients
    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();
        String query = "SELECT * FROM client";
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                clients.add(new Client(rs.getLong("client_id"), rs.getString("name"),
                        rs.getString("relationship_date")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    // Method to update a client's information (excluding client ID)
    public boolean updateClient(Client client) {
        String query = "UPDATE client SET name = ?, relationship_date = ? WHERE client_id = ?";
        try (PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setString(1, client.getClientname());
            pst.setString(2, client.getClientrelationshipDate());
            pst.setLong(3, client.getClientid());
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Method to delete a client
    public boolean deleteClient(long clientId) {
        String query = "DELETE FROM client WHERE client_id = ?";
        try (PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setLong(1, clientId);
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

