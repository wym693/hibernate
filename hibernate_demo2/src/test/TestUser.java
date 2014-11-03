package test;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateSessionFactory;
import bean.User;

public class TestUser {

	
	public static void main(String[] args) {
		
		add();
		
		
		
		
	}

	private static void add() {
		
		
		Session session= HibernateSessionFactory.getSession();
		
		User user=new User("����2014",25,1.73);
//		user.setId(4);
		
		
		Transaction tx=null;
		
		try {
			tx=session.beginTransaction();
			
			session.save(user);
			//evit()�޳�sesion��������Ķ���
//			session.evict(user);
			//������Ϻ��������µ�����ֵ����������
//			session.flush();//�������¶���״̬ û���ύ����
			
			
			
			
			tx.commit();//��ʽ����ˢ�·���
			System.out.println("����ɹ�");
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally{
			HibernateSessionFactory.closeSession();
		}
		
		
		
		
		
		
		
		
		
		
	}

}
