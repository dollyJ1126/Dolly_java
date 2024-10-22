package com.dao;

import com.bean.Employee;
import com.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    public void addEmployee(Employee employee) {
        try (Connection con = DBUtil.createConnection();
             PreparedStatement ps = con.prepareStatement("INSERT INTO employee(firstName, lastName, email, mobile, address, gender, password) VALUES (?, ?, ?, ?, ?, ?, ?)")) {
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setString(3, employee.getEmail());
            ps.setString(4, employee.getMobile());
            ps.setString(5, employee.getAddress());
            ps.setString(6, employee.getGender());
            ps.setString(7, employee.getPassword());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (Connection con = DBUtil.createConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM employee")) {
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setEmpId(rs.getInt("empId"));
                employee.setFirstName(rs.getString("firstName"));
                employee.setLastName(rs.getString("lastName"));
                employee.setEmail(rs.getString("email"));
                employee.setMobile(rs.getString("mobile"));
                employee.setAddress(rs.getString("address"));
                employee.setGender(rs.getString("gender"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public Employee getEmployeeById(int empId) {
        Employee employee = null;
        try (Connection con = DBUtil.createConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM employee WHERE empId = ?")) {
            ps.setInt(1, empId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                employee = new Employee();
                employee.setEmpId(rs.getInt("empId"));
                employee.setFirstName(rs.getString("firstName"));
                employee.setLastName(rs.getString("lastName"));
                employee.setEmail(rs.getString("email"));
                employee.setMobile(rs.getString("mobile"));
                employee.setAddress(rs.getString("address"));
                employee.setGender(rs.getString("gender"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    public static void updateEmployee(Employee employee) {
        try (Connection con = DBUtil.createConnection();
             PreparedStatement ps = con.prepareStatement("UPDATE employee SET firstName = ?, lastName = ?, email = ?, mobile = ?, address = ?, gender = ?, password = ? WHERE empId = ?")) {
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setString(3, employee.getEmail());
            ps.setString(4, employee.getMobile());
            ps.setString(5, employee.getAddress());
            ps.setString(6, employee.getGender());
            ps.setString(7, employee.getPassword());
            ps.setInt(8, employee.getEmpId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(int empId) {
        try (Connection con = DBUtil.createConnection();
             PreparedStatement ps = con.prepareStatement("DELETE FROM employee WHERE empId = ?")) {
            ps.setInt(1, empId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
