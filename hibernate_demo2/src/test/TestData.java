package test;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import util.HibernateSessionFactory;
import bean.Dept;
import bean.Emp;

public class TestData {
	public static void main(String[] args) {
		
		
	     Emp emp1=new Emp( "����");
	     emp1.setSalary(new Double(4999));
	     
	     Emp emp2=new Emp( "����");
	     
	     emp2.setSalary(new Double(4998));
	     Emp emp3=new Emp( "����");
	     emp3.setSalary(new Double(5001));
	     
	     Emp emp4=new Emp( "����");
	     emp4.setSalary(new Double(5001));
	     
	     Emp emp5=new Emp( "Ǯ��");
	     emp5.setSalary(new Double(5000));
	     
	     Emp emp6=new Emp( "����");
	     emp6.setSalary(new Double(5000));
	     
	     Dept shichang=new Dept("�г���","����");
	     Dept caiwu=new Dept("����","�в�");
	     Dept resource=new Dept("���²�","����");
	     
	     shichang.getEmps().add(emp1);
	     shichang.getEmps().add(emp2);
	     caiwu.getEmps().add(emp3);
	     caiwu.getEmps().add(emp4);
	     resource.getEmps().add(emp5);
	     resource.getEmps().add(emp6);
	     
	     //��������
	     
	    Session session=HibernateSessionFactory.getSession();
	 	Transaction tx = null;

		try {
			tx = session.beginTransaction();
			
			session.save(shichang);
			session.save(caiwu);
			session.save(resource);
			tx.commit();
			System.out.println("����ɹ�");
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			HibernateSessionFactory.closeSession();
		}
	     
	     
	     
	     
		
	}

}

