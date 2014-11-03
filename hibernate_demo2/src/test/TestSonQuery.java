package test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.classic.Session;

import bean.Dept;
import bean.Emp;

import util.HibernateSessionFactory;

public class TestSonQuery {
	public static void main(String[] args) {
		
		
//		queryByAbove5000();
		
//		querySqlQuery();
		
		//命名查询
//		HQLNamedQurery();
		
		SQLNamedQuery();
		
		
		
	}

	private static void SQLNamedQuery() {
		
		Session session=HibernateSessionFactory.getSession();
		 
		 Query query= session.getNamedQuery("selectEmpByEmpNo");
		
		 query.setInteger("empno", 1);
		 
		 Emp emp=(Emp) query.uniqueResult();
		 
		 System.out.println(emp.getEmpNo()+" "+emp.getSalary());
			
		
		
	}

	private static void HQLNamedQurery() {
		
		 Session session=HibernateSessionFactory.getSession();
		 
		 Query query= session.getNamedQuery("findEmpByEmpNo");
		
		 query.setInteger("empno", 1);
		 
		 Emp emp=(Emp) query.uniqueResult();
		 
		 System.out.println(emp.getEmpNo()+" "+emp.getSalary());
		
		
		
	}

	private static void querySqlQuery() {
		 Session session=HibernateSessionFactory.getSession();
		 Query query=session.createSQLQuery("select * from EMP where empno=1");
		 
//		 Object object=query.uniqueResult();
//		 Emp emp=(Emp)object;
//		 System.out.println(object);
//		 System.out.println(emp.getEmpNo()+" "+emp.getSalary());
		 Object[] objects= (Object[]) query.uniqueResult();
		 for (Object objects2 : objects) {
			System.out.println(objects2);
		}
		 
		 
		
		
		
	}

	//from Dept d where 5000>all(select e.salary from d.emps e) and d.emps.size>0
	private static void queryByAboveAvg() {
		
		
		 Session session=HibernateSessionFactory.getSession();
		 
		 Query query=session.createQuery("from Emp e where e.salary>(select avg(salary) from Emp)");
		 
		 List<Emp> emps=query.list();
		 
		 for (Emp emp : emps) {
			System.out.println(emp.getEmpNo()+" "+emp.getSalary());
		}
		
		 
		 
		 
		 
		
		
		
		
		
		
		
		
		
		
	}
	
	private static void queryByAbove5000() {
		
		
		 Session session=HibernateSessionFactory.getSession();
		 
		 Query query=session.createQuery("from Dept d where 5000>all(select e.salary from d.emps e) and d.emps.size>0");
		 
		 List<Dept> depts=query.list();
		 
		 for (Dept dept : depts) {
			System.out.println(dept.getDeptName());
		}
		
		 
		 
		 
		 
		
		
		
		
		
		
		
		
		
		
	}

}
