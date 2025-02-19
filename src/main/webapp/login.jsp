<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

 <h2>Login</h2>
    <form action="MainServlet" method="post">
        <input type="hidden" name="action" value="login">
        
        <label for="email">Email:</label><br>
        <input type="email" id="email" name="email" required><br><br>
        
        <label for="otp">OTP:</label><br>
        <input type="text" id="otp" name="otp" required><br><br>
        
        <button type="submit">Login</button>
    </form>
</body>
</html>
