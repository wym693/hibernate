package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Movie;

public class SaveMovieServlet extends HttpServlet {
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    //设置编码
		request.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		
		
		//获取数据
		
		String name=request.getParameter("name");
		//int
		String typeid=request.getParameter("typeid");
		
		String actor=request.getParameter("actor");
		
		String director=request.getParameter("director");
		
		String price=request.getParameter("price");
		
		//根据id获取type类型
		
		Movie movie=new Movie();
		//完成保存  条件查找
		
		
		
		
		
		
		
		
		//发给业务层
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
