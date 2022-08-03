package com.BatDongSan.Controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BatDongSan.Model.UserModel;
import com.BatDongSan.Service.ICategoryService;
import com.BatDongSan.Service.INewService;

@WebServlet(urlPatterns  = {"/trang-chu"})
public class HomeController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	

	@Inject
	private ICategoryService categoryService;
	
	@Inject
	private INewService newService;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		UserModel userModel = new UserModel();
//		userModel.setFullName("xin chao Bao Nguyen");
//		request.setAttribute("model", userModel);
		
		long code = 1L;
		request.setAttribute("news", newService.findByCategoryId(code));
		request.setAttribute("categories", categoryService.findAll());
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
		rd.forward(request, response);
	}
}
