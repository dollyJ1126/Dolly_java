<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.bean.Employee" %>
<%@ page import="com.dao.EmployeeDAO" %>
<%
    EmployeeDAO employeeDAO = new EmployeeDAO();
    List<Employee> employees = employeeDAO.getAllEmployees();
%>
<html>
<head>
    <link rel="stylesheet" href="styles.css">
    <title>View Employees</title>
</head>
<body>
    <h2>List of Employees</h2>
    <table border="1">
        <tr>
            <th>EMPID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Mobile</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <%
            for (Employee employee : employees) {
        %>
        <tr>
            <td><%= employee.getEmpId() %></td>
            <td><%= employee.getFirstName() %></td>
            <td><%= employee.getLastName() %></td>
            <td><%= employee.getEmail() %></td>
            <td><%= employee.getMobile() %></td>
            <td><a href="EmployeeController?action=edit&empId=<%= employee.getEmpId() %>">Edit</a></td>
            <td>
                <form action="EmployeeController" method="post" style="display:inline;">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="empId" value="<%= employee.getEmpId() %>">
                    <button type="submit" onclick="return confirm('Are you sure you want to delete this employee?');">Delete</button>
                </form>
            </td>
        </tr>
        <%
            }
        %>
    </table>
    <br>
    <a href="index.jsp">Back to Menu</a>
</body>
</html>
