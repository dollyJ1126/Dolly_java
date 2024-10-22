<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="styles.css">
    <title>Add Employee</title>
</head>
<body>
    <h2>Add Employee</h2>
    <form action="EmployeeController" method="post">
        <input type="hidden" name="action" value="add">
        <label>First Name:</label>
        <input type="text" name="firstName" required><br>
        <label>Last Name:</label>
        <input type="text" name="lastName" required><br>
        <label>Email:</label>
        <input type="email" name="email" required><br>
        <label>Mobile:</label>
        <input type="text" name="mobile" required><br>
        <label>Address:</label>
        <textarea name="address" required></textarea><br>
        <label>Gender:</label>
        <input type="radio" name="gender" value="Male" required> Male
        <input type="radio" name="gender" value="Female" required> Female<br>
        <label>Password:</label>
        <input type="password" name="password" required><br>
        <button type="submit">Submit</button>
    </form>
    <br>
    <a href="index.jsp">Back to Menu</a>
</body>
</html>
