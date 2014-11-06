package dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.classic.Session;

import util.HibernateSessionFactory;
import bean.Type;
import dao.TypeDao;

public class TypeDaoImpl implements TypeDao{

	public List<Type> getAll() throws HibernateException {
		List<Type> types=null;
		String hql="from Type";
		
		Session session=HibernateSessionFactory.getSession();
		
		Query query=session.createQuery(hql);
		
		 types=query.list();
		
		 HibernateSessionFactory.closeSession();
		
		
		return types;
	}

}
