<%@page import="com.bean.Product"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
    <title>Product List</title>
</head>
<body>
    <h1>Product List</h1>
    <h2><a href="addProduct.jsp">Add New Product</a></h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Company</th>
            <th>Actions</th>
        </tr>
        <%
            List<Product> products = (List<Product>) request.getAttribute("productList");
            if (products != null && !products.isEmpty()) {
                for (Product product : products) {
        %>
            <tr>
                <td><%= product.getId() %></td>
                <td><%= product.getName() %></td>
                <td><%= product.getPrice() %></td>
                <td><%= product.getQuantity() %></td>
                <td><%= product.getCompany() %></td>
                <td>
                    <form action="products" method="post" style="display:inline;">
                        <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="productId" value="<%= product.getId() %>">
                        <input type="submit" value="Delete">
                    </form>
                    <form action="editProduct.jsp" method="get" style="display:inline;">
                        <input type="hidden" name="productId" value="<%= product.getId() %>">
                        <input type="submit" value="Edit">
                    </form>
                </td>
            </tr>
        <%
                }
            } else {
        %>
            <tr>
                <td colspan="6">No products found.</td>
            </tr>
        <%
            }
        %>
    </table>
</body>
</html>
