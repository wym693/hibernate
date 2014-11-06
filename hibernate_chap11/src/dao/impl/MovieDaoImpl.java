package dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

import util.HibernateSessionFactory;

import bean.Movie;
import bean.MovieCondition;
import dao.MovieDao;

public class MovieDaoImpl implements MovieDao {

	public List<Movie> getAll() throws HibernateException {
		return null;
	}

	public void save(Movie movie) throws HibernateException {
		
	     Session session=HibernateSessionFactory.getSession();
	     session.save(movie);
	     
	     session.getTransaction().commit();//提交事务
	     HibernateSessionFactory.closeSession();
	     
	     
	     
	     
	     

	}

	public List<Movie> searchByCondition(MovieCondition condition)
			throws HibernateException {
		return null;
	}

}
