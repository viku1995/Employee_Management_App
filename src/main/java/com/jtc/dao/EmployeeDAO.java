package com.jtc.dao;

import java.sql.*;
import java.sql.PreparedStatement;
import java.util.*;

import com.jtc.dbconnection.DBConnection;
import com.jtc.model.Employee;

public class EmployeeDAO {
	
	 // Add new employee
    public boolean addEmployee(Employee emp) {
        String sql = "INSERT INTO employees (emp_id, name, dept, email, phone, joining_date) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, emp.getEmpid());
            ps.setString(2, emp.getEmpname());
            ps.setString(3, emp.getEmpdepartment());
            ps.setString(4, emp.getEmpemail());
            ps.setString(5, emp.getEmpphone());
            ps.setString(6, emp.getEmpjoiningDate());
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get employee by ID
    public Employee getEmployeeById(long employeeId) {
        String sql = "SELECT * FROM employees WHERE emp_id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, employeeId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Employee(
                    rs.getLong("emp_id"),
                    rs.getString("name"),
                    rs.getString("dept"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    rs.getString("joining_date")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Get all employees
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employees";
        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                employees.add(new Employee(
                		 rs.getLong("emp_id"),
                         rs.getString("name"),
                         rs.getString("dept"),
                         rs.getString("email"),
                         rs.getString("phone"),
                         rs.getString("joining_date")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    // Update employee details
    public boolean updateEmployee(Employee emp) {
        String sql = "UPDATE employees SET name = ?, dept = ?, phone = ? WHERE emp_id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, emp.getEmpname());
            ps.setString(2, emp.getEmpdepartment());
            ps.setString(3, emp.getEmpphone());
            ps.setLong(4, emp.getEmpid());
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete employee
    public boolean deleteEmployee(String empId) {
        String sql = "DELETE FROM employees WHERE emp_id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, empId);
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

	public void close() {
		// TODO Auto-generated method stub
		
	}
}


