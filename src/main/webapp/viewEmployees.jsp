<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Employees</title>
</head>
<body>

<h2>All Employees</h2>
    <table border="1">
        <tr>
            <th>Employee ID</th>
            <th>Name</th>
            <th>Department</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Date of Joining</th>
        </tr>
        
        <!-- Loop to display employees -->
        
        <c:forEach var="employee" items="${employees}">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.name}</td>
                <td>${employee.dept}</td>
                <td>${employee.email}</td>
                <td>${employee.phone}</td>
                <td>${employee.joiningDate}</td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>