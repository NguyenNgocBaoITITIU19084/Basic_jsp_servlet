package com.BatDongSan.Service;

import java.util.List;

import com.BatDongSan.Model.NewsModel;

public interface INewService{
	List<NewsModel> findByCategoryId(Long CategoryId);
}
