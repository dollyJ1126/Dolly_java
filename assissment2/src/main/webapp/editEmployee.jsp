<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.bean.Employee" %>
<%@ page import="com.dao.EmployeeDAO" %>
<%
    String empIdStr = request.getParameter("empId");
    Employee employee = null;
    
    if (empIdStr != null && !empIdStr.isEmpty()) {
        try {
            int empId = Integer.parseInt(empIdStr);
            EmployeeDAO employeeDAO = new EmployeeDAO();
            employee = employeeDAO.getEmployeeById(empId);
        } catch (NumberFormatException e) {
            out.println("Invalid Employee ID format.");
        }
    } else {
        out.println("Employee ID is missing.");
    }

    if (employee == null) {
        out.println("<p>No employee found with the provided ID.</p>");
        return; // Exit the JSP if no employee found
    }
%>

<html>
<head>
    <link rel="stylesheet" href="styles.css">
    <title>Edit Employee</title>
</head>
<body>
    <h2>Edit Employee</h2>
    <form action="EmployeeController" method="post">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="empId" value="<%= employee.getEmpId() %>"> <!-- Assuming getId() returns empId -->
        <label>First Name:</label>
        <input type="text" name="firstName" value="<%= employee.getFirstName() %>" required><br>
        <label>Last Name:</label>
        <input type="text" name="lastName" value="<%= employee.getLastName() %>" required><br>
        <label>Email:</label>
        <input type="email" name="email" value="<%= employee.getEmail() %>" required><br>
        <label>Mobile:</label>
        <input type="text" name="mobile" value="<%= employee.getMobile() %>" required><br>
        <label>Address:</label>
        <textarea name="address" required><%= employee.getAddress() %></textarea><br>
        <label>Gender:</label>
        <input type="radio" name="gender" value="Male" <%= employee.getGender().equals("Male") ? "checked" : "" %>> Male
        <input type="radio" name="gender" value="Female" <%= employee.getGender().equals("Female") ? "checked" : "" %>> Female<br>
        <label>Password:</label>
        <input type="password" name="password" value="<%= employee.getPassword() %>" required><br>
        <button type="submit">Update</button>
    </form>
    <br>
    <a href="viewEmployees.jsp">Back to Employee List</a>
</body>
</html>
