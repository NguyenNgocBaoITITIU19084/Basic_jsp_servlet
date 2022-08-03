package com.BatDongSan.DAO.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.BatDongSan.DAO.INewDAO;
import com.BatDongSan.Model.NewsModel;

public class NewDAO implements INewDAO{

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

	@Override
	public List<NewsModel> findByCategoryId(Long CategoryId) {
		List<NewsModel> results = new ArrayList<>();
		String query = "select * from news where categoryid = ?";
		PreparedStatement pst = null;
		ResultSet rs = null;
		Connection connection = null;
		try {
			connection = getConnection();
			if (connection != null) {
				pst = connection.prepareStatement(query);
				pst.setLong(1, CategoryId);
				rs = pst.executeQuery();
				while (rs.next()) {
					NewsModel news = new NewsModel();
					news.setId(rs.getLong("id"));
					news.setTitle(rs.getString("title"));
					news.setShortDescription(rs.getString("shortdescription"));
					results.add(news);
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
