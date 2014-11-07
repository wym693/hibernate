package biz.impl;

import java.util.List;

import org.hibernate.HibernateException;

import bean.Movie;
import bean.MovieCondition;
import bean.Type;
import biz.MovieBiz;
import dao.MovieDao;
import dao.TypeDao;
import dao.impl.MovieDaoImpl;
import dao.impl.TypeDaoImpl;

public class MovieBizImpl implements MovieBiz {
	
	private MovieDao movieDao=new MovieDaoImpl();
	
	
	private TypeDao  typeDao=new TypeDaoImpl();
	

	public List<Type> getAllType() throws HibernateException {
		return typeDao.getAll();
		
	}

	public void addMovie(Movie movie) throws HibernateException {
		movieDao.save(movie);
	}

	public List<Movie> searchMovie(MovieCondition condition)
			throws HibernateException {
		return movieDao.searchByCondition(condition);
		
		
	}
	
	//根据id查找Type
	public Type getTypeById(int id) throws HibernateException{
		return typeDao.getTypeById(id);
	}



	public List<Movie> getAllMovie() throws HibernateException {
		return movieDao.getAll();
	}

}
