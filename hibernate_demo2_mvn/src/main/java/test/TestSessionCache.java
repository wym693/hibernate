package test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.Teacher;

import util.HibernateSessionFactory;

public class TestSessionCache {
	public static void main(String[] args) {
		
		
		updateCache();
		
	}

	private static void updateCache() {
		
		Session session=HibernateSessionFactory.getSession();
		
		
		Teacher teacher=(Teacher) session.get(Teacher.class, new Integer(12));
		
		
		
		
		
		
		
		
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			
			System.out.println("更新前");
			System.out.println(teacher.getId()+"\t"+teacher.getName());
			
			teacher.setName("王老师");
			session.update(teacher);
			
			
			teacher.setName("陈老师");
			session.update(teacher);
			
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally{
			HibernateSessionFactory.closeSession();
		}
		
		
		
		
		
		
		
		
		
		
	}

}
