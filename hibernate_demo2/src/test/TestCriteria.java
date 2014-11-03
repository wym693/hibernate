package test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import util.HibernateSessionFactory;
import bean.Emp;
import bean.EmpCondition;

public class TestCriteria {

	public static void main(String[] args) {

//		simpleDemo();
//		demo1();
//		comlicat();
		
//		dynamicSearch();
		
		//分离式的标准查找DetachedCriteria
		detachedCriteriaSearch();

	}

	private static void detachedCriteriaSearch() {
		
		
		DetachedCriteria dc=DetachedCriteria.forClass(Emp.class);
		//模拟构造条件5分钟
		try {
			System.out.println("此处模拟停顿3秒钟");
			dc.add(Restrictions.eq("empNo", new Integer(1)));
			dc.add(Restrictions.eq("empName", "李四"));
			
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("单击查找按钮");
		//实际占用session从这里开始
		Criteria critera=dc.getExecutableCriteria(HibernateSessionFactory.getSession());
		
		List<Emp> emps = critera.list();

		for (Emp emp : emps) {
			System.out.println(emp.getEmpNo() + "\t" + emp.getEmpName());
		}
	    
		
		
		
		
		
	}

	private static void dynamicSearch() {
		
		EmpCondition condition=new EmpCondition();
		condition.setEmpNo(new Integer(1));
		condition.setEmpName("李四");
		
		Session session = HibernateSessionFactory.getSession();
		// 标准查找接口
		Criteria criteria = session.createCriteria(Emp.class);
		
		//此处构造占用5分钟
		
		//动态加条件
		if(null!=condition.getEmpNo()){
			criteria.add(Restrictions.eq("empNo", condition.getEmpNo()));
		}
		if(null!=condition.getEmpName()){
			criteria.add(Restrictions.eq("empName", condition.getEmpName()));
		}
		
		List<Emp> emps = criteria.list();

		for (Emp emp : emps) {
			System.out.println(emp.getEmpNo() + "\t" + emp.getEmpName());
		}
	    
		
		
		
		
		HibernateSessionFactory.closeSession();
		
		
		
	}

	private static void simpleDemo() {

		Session session = HibernateSessionFactory.getSession();
		// 标准查找接口
		Criteria criteria = session.createCriteria(Emp.class);
		//分页查找
		criteria.setMaxResults(2);
		criteria.setFirstResult(2);

		List<Emp> emps = criteria.list();

		for (Emp emp : emps) {
			System.out.println(emp.getEmpNo() + "\t" + emp.getEmpName());
		}

	}
	

	private static void demo1() {

		Session session = HibernateSessionFactory.getSession();
		// 标准查找接口
//		Criteria criteria = session.createCriteria(Emp.class);
//		//添加条件
//		criteria.add(Restrictions.eq("empNo", new Integer(1)));
//		//添加条件2
//		criteria.add(Restrictions.eq("empName", "张三"));
		//添加条件3模糊
//		criteria.add(Restrictions.like("empName", "李%"));
		
		//条件4 大于
//		criteria.add(Restrictions.gt("salary", new Double(5000)));
		
		//支持链式风格
		Criteria criteria=session.createCriteria(Emp.class)
		.addOrder(Order.asc("empName"));
		
//		.add(Restrictions.eq("empNo", new Integer(1)))
//		.add(Restrictions.eq("empName", "张三"));
		
		
		List<Emp> emps = criteria.list();

		for (Emp emp : emps) {
			System.out.println(emp.getEmpNo() + "\t" + emp.getEmpName());
		}

	}
	
	private static void comlicat() {

		Session session = HibernateSessionFactory.getSession();
		Criteria criteria=session.createCriteria(Emp.class);
		Criteria criteria2=criteria.createCriteria("dept");
		         criteria2.add(Restrictions.eq("deptName", "财务部"));
		         
		
		
		List<Emp> emps = criteria.list();

		for (Emp emp : emps) {
			System.out.println(emp.getEmpNo() + "\t" + emp.getEmpName()+" "+emp.getDept().getDeptName());
		}

	}


}
