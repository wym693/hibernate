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
			//一项工作
		Work work=new Work() {
			
			public void execute(Connection conn) throws SQLException {
				//jdbc来实现
				String sql="update STUDENT s set s.name='张三jdbc'  where s.id=12";
				
				PreparedStatement prst=conn.prepareStatement(sql);
				int count=prst.executeUpdate();
				System.out.println("执行数量"+count);
				
			}
		};
		Transaction tx=null;
		
		try {
			tx=session.beginTransaction();
		
		//由session执行工作
		session.doWork(work);
		System.out.println("完毕");
		
			tx.commit();//隐式调用刷新方法
			System.out.println("保存成功");
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
			tx.commit();//隐式调用刷新方法
			System.out.println("保存成功");
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally{
			HibernateSessionFactory.closeSession();
		}
		
		
		
		
		
	}

}
