package test;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import util.HibernateSessionFactory;
import bean.Dept;
import bean.Emp;

public class TestData {
	public static void main(String[] args) {
		
		
	     Emp emp1=new Emp( "张三");
	     emp1.setSalary(new Double(4999));
	     
	     Emp emp2=new Emp( "李四");
	     
	     emp2.setSalary(new Double(4998));
	     Emp emp3=new Emp( "王五");
	     emp3.setSalary(new Double(5001));
	     
	     Emp emp4=new Emp( "赵六");
	     emp4.setSalary(new Double(5001));
	     
	     Emp emp5=new Emp( "钱七");
	     emp5.setSalary(new Double(5000));
	     
	     Emp emp6=new Emp( "王八");
	     emp6.setSalary(new Double(5000));
	     
	     Dept shichang=new Dept("市场部","东边");
	     Dept caiwu=new Dept("财务部","中部");
	     Dept resource=new Dept("人事部","西边");
	     
	     shichang.getEmps().add(emp1);
	     shichang.getEmps().add(emp2);
	     caiwu.getEmps().add(emp3);
	     caiwu.getEmps().add(emp4);
	     resource.getEmps().add(emp5);
	     resource.getEmps().add(emp6);
	     
	     //保存数据
	     
	    Session session=HibernateSessionFactory.getSession();
	 	Transaction tx = null;

		try {
			tx = session.beginTransaction();
			
			session.save(shichang);
			session.save(caiwu);
			session.save(resource);
			tx.commit();
			System.out.println("保存成功");
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			HibernateSessionFactory.closeSession();
		}
	     
	     
	     
	     
		
	}

}

