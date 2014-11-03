package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.hibernate.Hibernate;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import bean.Bigobject_1;
import bean.Bigobject_2;

import util.HibernateSessionFactory;

public class TestBigObject {
	
	public void demo1(){
		

		Session session = null;
		Transaction tx = null;
		try {
			// 读入类路径下的file.txt文件的二进制数据
			InputStream in = new FileInputStream(new File("C:/Users/wen/Desktop/123.txt"));
			byte[] byteArray = new byte[in.available()];
			in.read(byteArray);
			in.close();
			
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			Bigobject_1 bigObj = new Bigobject_1(32);
			bigObj.setTclob("测试大文本");
			bigObj.setTblob(byteArray);
			session.save(bigObj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		} finally {
			// 关闭session
			HibernateSessionFactory.closeSession();
		}
		
	}
	
	
	public void demo2(){
			Session session = null;
			Transaction tx = null;
			try {
				// 读入类路径下的file.txt文件的二进制数据
				InputStream in = new FileInputStream(new File("C:/Users/wen/Desktop/Git权威指南.pdf"));
				
				
				
//				byte[] byteArray = new byte[in.available()];
//				in.read(byteArray);
//				in.close();
				
				session = HibernateSessionFactory.getSession();
				tx = session.beginTransaction();
				Bigobject_2 obj = new Bigobject_2(30);
				obj.setTblob(Hibernate.createBlob(in));//依据二进制数据创建一个Blob对象
				obj.setTclob(Hibernate.createClob("测试大文本"));//依据字符串对象创建一个Clob对象
				session.save(obj);
				tx.commit();
			} catch (Exception e) {
				e.printStackTrace();
				if (tx != null)
					tx.rollback();
			} finally {
				// 关闭session
				HibernateSessionFactory.closeSession();
			}
	}
	public static void main(String[] args) {
		
		  TestBigObject test1=new TestBigObject();
		  test1.demo2();
		
	}

}
