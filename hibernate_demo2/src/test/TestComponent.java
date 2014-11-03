package test;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import util.HibernateSessionFactory;
import bean.Address;
import bean.StudentMain;
import bean.Teacher;

public class TestComponent {
	public static void main(String[] args) {
		
		add();
	}

	private static void add() {
		
		
	     StudentMain main=new StudentMain("����");
	     
	     Address home=new Address("�������","020-888833333","mayun@yahoo.com");
	     
	     main.setAddress(home);
	     home.setStudentMain(main);
	     
	     Session session = HibernateSessionFactory.getSession();
			
			
			
			Transaction tx = null;

			try {
				tx = session.beginTransaction();
				
				session.save(main);
//				session.save(home);

			

				tx.commit();
				System.out.println("����ɹ�");
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				tx.rollback();
			} finally {
				HibernateSessionFactory.closeSession();
			}
	     
	     
	     
	     
		
		
		
		
		
		
		
	}

}
