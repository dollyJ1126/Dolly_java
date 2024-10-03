package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.bean.Product;
import com.util.DBUtil;

public class ProductDAO {

	 public void addProduct(Product product) {
	        String sql = "INSERT INTO products (name, price, quantity, company) VALUES (?, ?, ?, ?)";

	        try (Connection conn=DBUtil.createConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setString(1, product.getName());
	            pstmt.setDouble(2, product.getPrice());
	            pstmt.setInt(3, product.getQuantity());
	            pstmt.setString(4, product.getCompany());
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public List<Product> getAllProducts() {
	        List<Product> productList = new ArrayList<>();
	        String sql = "SELECT * FROM products";

	        try (Connection conn=DBUtil.createConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql);
	             ResultSet rs = pstmt.executeQuery()) {

	            while (rs.next()) {
	                int id = rs.getInt("id");
	                String name = rs.getString("name");
	                double price = rs.getDouble("price");
	                int quantity = rs.getInt("quantity");
	                String company = rs.getString("company");
	                Product product = new Product();
	                productList.add(product);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return productList;
	    }

	    public Product getProductById(int id) {
	        Product product = null;
	        String sql = "SELECT * FROM products WHERE id = ?";

	        try (Connection conn=DBUtil.createConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setInt(1, id);
	            ResultSet rs = pstmt.executeQuery();

	            if (rs.next()) {
	                String name = rs.getString("name");
	                double price = rs.getDouble("price");
	                int quantity = rs.getInt("quantity");
	                String company = rs.getString("company");
	                product = new Product();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return product;
	    }

	
	    public void updateProduct(Product updatedProduct) {
	        String sql = "UPDATE products SET name = ?, price = ?, quantity = ?, company = ? WHERE id = ?";

	        try (Connection conn=DBUtil.createConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setString(1, updatedProduct.getName());
	            pstmt.setDouble(2, updatedProduct.getPrice());
	            pstmt.setInt(3, updatedProduct.getQuantity());
	            pstmt.setString(4, updatedProduct.getCompany());
	            pstmt.setInt(5, updatedProduct.getId());
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }


	    public void deleteProduct(int id) {
	        String sql = "DELETE FROM products WHERE id = ?";

	        try (Connection conn=DBUtil.createConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setInt(1, id);
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	  
	}