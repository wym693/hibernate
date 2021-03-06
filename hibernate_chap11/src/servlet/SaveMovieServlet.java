package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Movie;
import bean.Type;
import biz.MovieBiz;
import biz.impl.MovieBizImpl;

public class SaveMovieServlet extends HttpServlet {
	
	private MovieBiz mb=new MovieBizImpl();
	
	
	
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
		response.setCharacterEncoding("utf-8");
		
		
		
		//获取数据
		
		String title=request.getParameter("name");
		//int
		String typeid=request.getParameter("typeid");
		
		String actor=request.getParameter("actor");
		
		String director=request.getParameter("director");
		
		String price=request.getParameter("price");
		
		
		//根据id获取type类型
		Type type=mb.getTypeById(Integer.parseInt(typeid));
		
		
		//完成保存  条件查找
		Movie movie=new Movie(title,director,actor,Double.parseDouble(price),type);
		//发给业务层
		
		
		mb.addMovie(movie);
		//添加成功
		response.getWriter().write("<script language=javascript>alert('add Movie Success');window.location.href='index.jsp'</script>");
		
		response.getWriter().flush();
		
		//调整首页
		
//		response.sendRedirect("index.jsp");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
