package com.BatDongSan.DAO.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.BatDongSan.DAO.ICategoryDAO;
import com.BatDongSan.Model.CategoryModel;

public class CategoryDAO implements ICategoryDAO {

	public Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/laptrinhjavaweb";
			String user = "root";
			String password = "123456789";
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			return null;
		}

	}

	public List<CategoryModel> findAll() {
		List<CategoryModel> results = new ArrayList<>();
		String query = "select * from category";
		PreparedStatement pst = null;
		ResultSet rs = null;
		Connection connection = null;
		try {
			connection = getConnection();
			if (connection != null) {
				pst = connection.prepareStatement(query);
				rs = pst.executeQuery();
				while (rs.next()) {
					CategoryModel category = new CategoryModel();
					category.setId(rs.getLong("id"));
					category.setName(rs.getString("name"));
					category.setCode(rs.getString("code"));
					results.add(category);
				}
			}
			return results;
		} catch (SQLException e) {
			return null;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (pst != null) {
					pst.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
