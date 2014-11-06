package biz;

import java.util.List;

import org.hibernate.HibernateException;

import bean.Movie;
import bean.MovieCondition;
import bean.Type;

public interface MovieBiz {
	

	//添加业务
	public void addMovie(Movie movie) throws HibernateException;
	
	
	//查询操作
	
	public List<Movie> searchMovie(MovieCondition condition) throws HibernateException;
	
	public List<Type> getAllType() throws HibernateException ;
	


}
