package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.bean.Product;
import com.dao.ProductDAO;


public class MyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO;
       
	  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	            throws ServletException, IOException {
	        String action = request.getParameter("action");

	        switch (action) {
	            case "add":
	                addProduct(request);
	                break;
	            case "edit":
	                editProduct(request);
	                break;
	            case "delete":
	                deleteProduct(request);
	                break;
	            default:
	                break;
	        }
	        response.sendRedirect("products.jsp");
	    }

	    private void addProduct(HttpServletRequest request) {
	        String name = request.getParameter("productName");
	        double price = Double.parseDouble(request.getParameter("productPrice"));
	        int quantity = Integer.parseInt(request.getParameter("productQuantity"));
	        String company = request.getParameter("productCompany");

	        Product product = new Product(); 
	        productDAO.addProduct(product);
	    }

	    private void editProduct(HttpServletRequest request) {
	        int id = Integer.parseInt(request.getParameter("productId"));
	        Product product = productDAO.getProductById(id);
	        if (product != null) {
	            String name = request.getParameter("productName");
	            double price = Double.parseDouble(request.getParameter("productPrice"));
	            int quantity = Integer.parseInt(request.getParameter("productQuantity"));
	            String company = request.getParameter("productCompany");

	            product.setName(name);
	            product.setPrice(price);
	            product.setQuantity(quantity);
	            product.setCompany(company);
	            productDAO.updateProduct(product);
	        }
	    }

	    private void deleteProduct(HttpServletRequest request) {
	        int id = Integer.parseInt(request.getParameter("productId"));
	        productDAO.deleteProduct(id);
	    }

	    @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	            throws ServletException, IOException {
	        List<Product> products = productDAO.getAllProducts();
	        request.setAttribute("productList", products);
	        request.getRequestDispatcher("listproducts.jsp").forward(request, response);
	    }
	}