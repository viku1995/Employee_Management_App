<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Project</title>
</head>
<body>

<h2>Add Project</h2>
    <form action="MainServlet" method="post">
        <input type="hidden" name="action" value="addProject">
        
        <label for="projectName">Project Name:</label><br>
        <input type="text" id="projectName" name="projectName" required><br><br>
        
        <label for="startDate">Start Date:</label><br>
        <input type="date" id="startDate" name="startDate" required><br><br>
        
        <label for="endDate">End Date:</label><br>
        <input type="date" id="endDate" name="endDate" required><br><br>
        
        <button type="submit">Add Project</button>
    </form>


</body>
</html>