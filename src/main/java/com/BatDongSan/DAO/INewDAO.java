package com.BatDongSan.DAO;

import java.util.List;

import com.BatDongSan.Model.NewsModel;

public interface INewDAO {
	List<NewsModel> findByCategoryId(Long CategoryId);
}
