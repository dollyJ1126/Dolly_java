<%@page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Products</title>
</head>
<body>
    <h1>Add New Product</h1>
    <form action="products" method="post">
        <input type="hidden" name="action" value="add">
        <label>Product Name:</label>
        <input type="text" name="productName" required><br>
        <label>Product Price:</label>
        <input type="number" name="productPrice" required step="0.01"><br>
        <label>Product Quantity:</label>
        <input type="number" name="productQuantity" required><br>
        <label>Product Company:</label>
        <input type="text" name="productCompany" required><br>
        <input type="submit" value="Add Product">
    </form>
    <h2><a href="products">Back to Product List</a></h2>
</body>
</html>
