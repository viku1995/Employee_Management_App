<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Verify otp</title>
</head>
<body>
<h2> Enter Otp</h2>

<form action="MainServlet" method="post">
        <input type="hidden" name="action" value="verifyOtp">
        
        <label>OTP:</label>
        <input type="text" name="otp" required>
        
        <button type="submit">Verify</button>
    </form>

    <!-- Display error message if OTP is incorrect -->
    <%
        String error = (String) request.getAttribute("error");
        if (error != null) {
    %>
        <p style="color: red;"><%= error %></p>
    <%
        }
    %>

    <p><a href="login.jsp">Resend OTP</a></p>

</body>
</html>