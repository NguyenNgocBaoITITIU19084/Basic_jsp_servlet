package com.BatDongSan.Service.impl;

import java.util.List;

import javax.inject.Inject;

import com.BatDongSan.DAO.ICategoryDAO;
import com.BatDongSan.Model.CategoryModel;
import com.BatDongSan.Service.ICategoryService;

public class CategoryService implements ICategoryService {

	@Inject
	private ICategoryDAO categoryDAO;
	
	@Override
	public List<CategoryModel> findAll() {
		return categoryDAO.findAll();
	}

}
