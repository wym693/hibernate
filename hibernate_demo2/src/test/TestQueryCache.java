package test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.Student;
import bean.Teacher;

import util.HibernateSessionFactory;

public class TestQueryCache {
	public static void main(String[] args) {
		
		
		updateCache();
		
	}

	private static void updateCache() {
		
//		Session session=HibernateSessionFactory.getSession();
//		
//		String hql="from Student";
//		Query query=session.createQuery(hql);
//		
//		//设置使用缓存存储结果
//		query.setCacheable(true);
//		
//		List<Student> students=query.list();
//		
//		for (Student student : students) {
//			System.out.println(student.getId()+" "+student.getName());
//		}
//		HibernateSessionFactory.closeSession();
//		System.out.println("对比第二次有没有发出新的语句");
//		session=HibernateSessionFactory.getSession();
//		
//	
//		Query query2=session.createQuery(hql);
//		query2.setCacheable(true);
//		List<Student> students2=query2.list();
//		
//		for (Student student : students2) {
//			System.out.println(student.getId()+" "+student.getName());
//		}
		
		Session session=HibernateSessionFactory.getSession();
		
		String hql="from Teacher";
		Query query=session.createQuery(hql);
		
		//设置使用缓存存储结果
		query.setCacheable(true);
		
		List<Teacher> teachers=query.list();
		
		for (Teacher teacher : teachers) {
			System.out.println(teacher.getName());
		}
		HibernateSessionFactory.closeSession();
		System.out.println("对比第二次有没有发出新的语句");
		session=HibernateSessionFactory.getSession();
		
	
		Query query2=session.createQuery(hql);
		query2.setCacheable(true);
		List<Teacher> teachers2=query2.list();
		
		for (Teacher teacher : teachers2) {
			System.out.println(teacher.getName());
		}
		
		
		
		
		
		
		
		
		
	}

}
