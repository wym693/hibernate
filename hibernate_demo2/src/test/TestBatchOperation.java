package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.jdbc.Work;

import util.HibernateSessionFactory;

public class TestBatchOperation {

	public static void main(String[] args) {
		
		
//		batchInsert();
		
		jdbcApi();
		
		
		
		
		
		
		

	}

	private static void jdbcApi() {
		Session session=HibernateSessionFactory.getSession();
			//һ���
		Work work=new Work() {
			
			public void execute(Connection conn) throws SQLException {
				//jdbc��ʵ��
				String sql="update STUDENT s set s.name='����jdbc'  where s.id=12";
				
				PreparedStatement prst=conn.prepareStatement(sql);
				int count=prst.executeUpdate();
				System.out.println("ִ������"+count);
				
			}
		};
		Transaction tx=null;
		
		try {
			tx=session.beginTransaction();
		
		//��sessionִ�й���
		session.doWork(work);
		System.out.println("���");
		
			tx.commit();//��ʽ����ˢ�·���
			System.out.println("����ɹ�");
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally{
			HibernateSessionFactory.closeSession();
		}
		
		
		
		
		
		
		
	}

	private static void batchInsert() {
		
		String hql="insert  into Subject (name) select s.id||s.name from Subject s where s.id>99";
		Session session=HibernateSessionFactory.getSession();
		Transaction tx=null;
		
		try {
			tx=session.beginTransaction();
			
			session.createQuery(hql).executeUpdate();
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
