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
			// ������·���µ�file.txt�ļ��Ķ���������
			InputStream in = new FileInputStream(new File("C:/Users/wen/Desktop/123.txt"));
			byte[] byteArray = new byte[in.available()];
			in.read(byteArray);
			in.close();
			
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			Bigobject_1 bigObj = new Bigobject_1(32);
			bigObj.setTclob("���Դ��ı�");
			bigObj.setTblob(byteArray);
			session.save(bigObj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		} finally {
			// �ر�session
			HibernateSessionFactory.closeSession();
		}
		
	}
	
	
	public void demo2(){
			Session session = null;
			Transaction tx = null;
			try {
				// ������·���µ�file.txt�ļ��Ķ���������
				InputStream in = new FileInputStream(new File("C:/Users/wen/Desktop/GitȨ��ָ��.pdf"));
				
				
				
//				byte[] byteArray = new byte[in.available()];
//				in.read(byteArray);
//				in.close();
				
				session = HibernateSessionFactory.getSession();
				tx = session.beginTransaction();
				Bigobject_2 obj = new Bigobject_2(30);
				obj.setTblob(Hibernate.createBlob(in));//���ݶ��������ݴ���һ��Blob����
				obj.setTclob(Hibernate.createClob("���Դ��ı�"));//�����ַ������󴴽�һ��Clob����
				session.save(obj);
				tx.commit();
			} catch (Exception e) {
				e.printStackTrace();
				if (tx != null)
					tx.rollback();
			} finally {
				// �ر�session
				HibernateSessionFactory.closeSession();
			}
	}
	public static void main(String[] args) {
		
		  TestBigObject test1=new TestBigObject();
		  test1.demo2();
		
	}

}
