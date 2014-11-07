package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Movie;
import bean.MovieCondition;
import bean.Type;
import biz.MovieBiz;
import biz.impl.MovieBizImpl;

public class SearchMovieServlet extends HttpServlet {
	
	private MovieBiz movieBiz=new MovieBizImpl();
	
	
	
	
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
		
		//获取查询条件
		
		String title=request.getParameter("name");
		//模糊查找关键字
		title="%"+title+"%";
		
		//int
		String typeid=request.getParameter("typeid");
		
		String actor=request.getParameter("actor");
		actor="%"+actor+"%";
		
		String director=request.getParameter("director");
		
		director="%"+director+"%";
		
		String minPrice=request.getParameter("minPrice");
		String maxPrice=request.getParameter("maxPrice");
		
		//根据id获取type类型
		Type type=movieBiz.getTypeById(Integer.parseInt(typeid));
		
		MovieCondition condition=new MovieCondition(title, director, actor, Double.parseDouble(minPrice), Double.parseDouble(maxPrice), type);
		
		List<Movie> movies=movieBiz.searchMovie(condition);
		
	
		
		//绑定Movies
		request.setAttribute("movies", movies);
		
		request.getRequestDispatcher("search.jsp").forward(request, response);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
