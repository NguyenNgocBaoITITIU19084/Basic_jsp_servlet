package com.BatDongSan.DAO;

import java.util.List;

import com.BatDongSan.Model.CategoryModel;

public interface ICategoryDAO {
	List<CategoryModel> findAll();
}
