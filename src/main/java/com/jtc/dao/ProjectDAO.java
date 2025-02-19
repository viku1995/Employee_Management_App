package com.jtc.dao;

import java.sql.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.*;

import com.jtc.dbconnection.DBConnection;
import com.jtc.model.Project;

public class ProjectDAO {
	  private Connection conn;

	    public ProjectDAO() {
	        try {
	            conn = DBConnection.getConnection();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    // Method to add a new project
	    public boolean addProject(Project project) {
	        String query = "INSERT INTO project (name, start_date, end_date) VALUES (?, ?, ?)";
	        try (PreparedStatement pst = conn.prepareStatement(query)) {
	            pst.setString(1, project.getProjectname());
	            pst.setString(2, project.getProjectstartDate());
	            pst.setString(3, project.getProjectendDate());
	            return pst.executeUpdate() > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	    // Method to get a project by its ID
	    public Project getProjectById(long projectId) {
	        String query = "SELECT * FROM project WHERE project_id = ?";
	        try (PreparedStatement pst = conn.prepareStatement(query)) {
	            pst.setLong(1, projectId);
	            ResultSet rs = pst.executeQuery();
	            if (rs.next()) {
	                return new Project(rs.getLong("project_id"), rs.getString("name"),
	                        rs.getString("start_date"), rs.getString("end_date"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

	    // Method to get all projects
	    public List<Project> getAllProjects() {
	        List<Project> projects = new ArrayList<>();
	        String query = "SELECT * FROM project";
	        try (Statement stmt = conn.createStatement()) {
	            ResultSet rs = stmt.executeQuery(query);
	            while (rs.next()) {
	                projects.add(new Project(rs.getLong("project_id"), rs.getString("name"),
	                        rs.getString("start_date"), rs.getString("end_date")));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return projects;
	    }

	    // Method to update project details (except the project ID)
	    public boolean updateProject(Project project) {
	        String query = "UPDATE project SET name = ?, start_date = ?, end_date = ? WHERE project_id = ?";
	        try (PreparedStatement pst = conn.prepareStatement(query)) {
	            pst.setString(1, project.getProjectname());
	            pst.setString(2, project.getProjectstartDate());
	            pst.setString(3, project.getProjectendDate());
	            pst.setLong(4, project.getProjectid());
	            return pst.executeUpdate() > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	    // Method to delete a project
	    public boolean deleteProject(long projectId) {
	        String query = "DELETE FROM project WHERE project_id = ?";
	        try (PreparedStatement pst = conn.prepareStatement(query)) {
	            pst.setLong(1, projectId);
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
	

