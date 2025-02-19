<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
</head>
<body>


 <h2>Add Employee</h2>
    <form action="MainServlet" method="post">
        <input type="hidden" name="action" value="addEmployee">
        
        <label for="name">Employee Name:</label><br>
        <input type="text" id="name" name="name" required><br><br>
        
        <label for="dept">Department:</label><br>
        <input type="text" id="dept" name="dept" required><br><br>
        
        <label for="email">Email:</label><br>
        <input type="email" id="email" name="email" required><br><br>
        
        <label for="phone">Phone:</label><br>
        <input type="tel" id="phone" name="phone" required><br><br>
        
        <label for="joiningDate">Date of Joining:</label><br>
        <input type="date" id="joiningDate" name="joiningDate" required><br><br>
        
        <button type="submit">Add Employee</button>
    </form>

</body>
</html>