package dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import util.HibernateSessionFactory;

import bean.Movie;
import bean.MovieCondition;
import dao.MovieDao;

public class MovieDaoImpl implements MovieDao {

	public List<Movie> getAll() throws HibernateException {
		Session session = HibernateSessionFactory.getSession();
		// 使用Criteria
		Criteria criteria = session.createCriteria(Movie.class);
		List<Movie> movies = criteria.list();
		return movies;
	}

	public void save(Movie movie) throws HibernateException {

		Session session = HibernateSessionFactory.getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			session.save(movie);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();

		} finally {
			HibernateSessionFactory.closeSession();
		}

	}

	public List<Movie> searchByCondition(MovieCondition condition)
			throws HibernateException {
		StringBuffer hql = new StringBuffer("from Movie where 1=1");

		if (null != condition.getTitile()) {
			hql.append(" AND titile like :titile");

		}

		if (null != condition.getActor()) {
			hql.append(" AND actor like :actor");

		}

		if (null != condition.getDirector()) {
			hql.append(" AND director like :director");

		}

		if (null != condition.getType()) {
			hql.append(" AND type=:type");

		}

		if (null != condition.getMinPrice()) {
			hql.append(" AND price>=:minPrice");

		}
		if (null != condition.getMinPrice()) {
			hql.append(" AND price<=:maxPrice");

		}
		// 根据条件动态拼接hql
		Session session = HibernateSessionFactory.getSession();

		Query query = session.createQuery(hql.toString());
		// 整个参数放入
		query.setProperties(condition);

		List<Movie> movies = query.list();
		return movies;

	}

}
