package test;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.Student;
import bean.Teacher;

import util.HibernateSessionFactory;

public class TestEhCache {
	public static void main(String[] args) {
		
		
		updateCache();
		
	}

	private static void updateCache() {
		
		Session session=HibernateSessionFactory.getSession();
		
		
//		Student student1=(Student) session.get(Student.class, new Integer(12));
		Teacher teacher1=(Teacher) session.get(Teacher.class, new Integer(12));
		
		
		session.close();
		
		//�µ�Session ������Ĳ���ͬһ��session�ռ���
		session=HibernateSessionFactory.getSession();
		System.out.println("�Ա��Ƿ����?��û�з����µ����");
		
//		Student student2=(Student) session.get(Student.class, new Integer(12));
		Teacher teacher2=(Teacher) session.get(Teacher.class, new Integer(12));
		
		
//		System.out.println("��ַ�Ƚ�"+(student1==student2));
		System.out.println(teacher1);
		System.out.println(teacher2);
		
//		System.out.println(student1);
//		System.out.println(student2);
		
		
		session.close();
//		
//		Transaction tx=null;
//		try {
//			tx=session.beginTransaction();
//			
//			System.out.println("����ǰ");
//			System.out.println(teacher.getId()+"\t"+teacher.getName());
//			
//			teacher.setName("����ʦ");
//			session.update(teacher);
//			
//			
//			teacher.setName("����ʦ");
//			session.update(teacher);
//			
//			tx.commit();
//		} catch (HibernateException e) {
//			e.printStackTrace();
//			tx.rollback();
//		}finally{
//			HibernateSessionFactory.closeSession();
//		}
//		
		
		
		
		
		
		
		
		
		
	}

}
