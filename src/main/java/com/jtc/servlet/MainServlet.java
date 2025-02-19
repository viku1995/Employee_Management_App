package com.jtc.servlet;

import java.io.IOException;

import com.jtc.dao.*;
import com.jtc.dbconnection.EmailUtil;
import com.jtc.dbconnection.OTPUtil;
import com.jtc.model.Client;
import com.jtc.model.Employee;
import com.jtc.model.Project;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet{
	
	 
    private EmployeeDAO employeeDAO;
    private ProjectDAO projectDAO;
    private ClientDAO clientDAO;
    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        employeeDAO = new EmployeeDAO();
        projectDAO = new ProjectDAO();
        clientDAO = new ClientDAO();
        userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        // Handle different actions based on the action parameter
        if ("getEmployee".equals(action)) {
            long employeeId = Long.parseLong(request.getParameter("employeeId"));
            Employee employee = employeeDAO.getEmployeeById(employeeId);
            request.setAttribute("employee", employee);
            RequestDispatcher dispatcher = request.getRequestDispatcher("employeeDetails.jsp");
            dispatcher.forward(request, response);
            
        } else if ("getProject".equals(action)) {
            long projectId = Long.parseLong(request.getParameter("projectId"));
            Project project = projectDAO.getProjectById(projectId);
            request.setAttribute("project", project);
            RequestDispatcher dispatcher = request.getRequestDispatcher("projectDetails.jsp");
            dispatcher.forward(request, response);
            
        } else if ("getClient".equals(action)) {
            long clientId = Long.parseLong(request.getParameter("clientId"));
            Client client = clientDAO.getClientById(clientId);
            request.setAttribute("client", client);
            RequestDispatcher dispatcher = request.getRequestDispatcher("clientDetails.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("addEmployee".equals(action)) {
            String name = request.getParameter("name");
            String dept = request.getParameter("dept");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String joiningDate = request.getParameter("joiningDate");

            Employee employee = new Employee(name, dept, email, phone, joiningDate);
            boolean success = employeeDAO.addEmployee(employee);
            if (success) {
                response.sendRedirect("employeeList.jsp");
                
            } else {
                request.setAttribute("error", "Failed to add employee.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("addEmployee.jsp");
                dispatcher.forward(request, response);
            }
            
        } else if ("addProject".equals(action)) {
            String projectName = request.getParameter("projectName");
            String startDate = request.getParameter("startDate");
            String endDate = request.getParameter("endDate");

            Project project = new Project(0, projectName, startDate, endDate);
            boolean success = projectDAO.addProject(project);
            if (success) {
                response.sendRedirect("projectList.jsp");
                
            } else {
                request.setAttribute("error", "Failed to add project.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("addProject.jsp");
                dispatcher.forward(request, response);
            }
            
        } else if ("addClient".equals(action)) {
            String clientName = request.getParameter("clientName");
            String relationshipDate = request.getParameter("relationshipDate");

            Client client = new Client(0, clientName, relationshipDate);
            boolean success = clientDAO.addClient(client);
            if (success) {
                response.sendRedirect("clientList.jsp");
            } else {
                request.setAttribute("error", "Failed to add client.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("addClient.jsp");
                dispatcher.forward(request, response);
            }
            
        } else if ("login".equals(action)) {
            String userId = request.getParameter("userId");
            String password = request.getParameter("password");

            boolean isAuthenticated = userDAO.authenticateUser(userId, password);
            if (isAuthenticated) {
                HttpSession session = request.getSession();
                session.setAttribute("userId", userId);
                response.sendRedirect("dashboard.jsp");
                
            } else {
                request.setAttribute("error", "Invalid credentials.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);
            }
        }
    }
    
    
    private static final String OTP_SUBJECT = "Your Login OTP";

    protected void doPost1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("login".equals(action)) {
            String email = request.getParameter("email");
            String otp = OTPUtil.generateOTP();

            // Send OTP via email
            String emailBody = "Your OTP for login is: " + otp;
            EmailUtil.sendEmail(email, OTP_SUBJECT, emailBody);

            // Store OTP in session for validation
            HttpSession session = request.getSession();
            session.setAttribute("otp", otp);
            session.setAttribute("email", email);

            response.sendRedirect("verifyOtp.jsp");
        } else if ("verifyOtp".equals(action)) {
            String enteredOtp = request.getParameter("otp");
            HttpSession session = request.getSession();
            String generatedOtp = (String) session.getAttribute("otp");

            if (generatedOtp != null && generatedOtp.equals(enteredOtp)) {
                response.sendRedirect("employeeDashboard.jsp");
            } else {
                request.setAttribute("error", "Invalid OTP. Please try again.");
                request.getRequestDispatcher("verifyOtp.jsp").forward(request, response);
            }
        }
    }


 
   

    @Override
    public void destroy() {
        super.destroy();
        if (employeeDAO != null)
        	employeeDAO.close();
		if (projectDAO != null)
			projectDAO.close();
		if (clientDAO != null) 
			clientDAO.close();
		if (userDAO != null) 
			userDAO.close();
    }
}


