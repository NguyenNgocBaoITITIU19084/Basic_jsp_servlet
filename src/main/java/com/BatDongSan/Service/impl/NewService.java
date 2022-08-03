package com.BatDongSan.Service.impl;

import java.util.List;

import javax.inject.Inject;

import com.BatDongSan.DAO.INewDAO;
import com.BatDongSan.Model.NewsModel;
import com.BatDongSan.Service.INewService;

public class NewService implements INewService{
	
	@Inject
	private INewDAO newDAO;

	@Override
	public List<NewsModel> findByCategoryId(Long CategoryId) {
		return newDAO.findByCategoryId(CategoryId);
	}

}
