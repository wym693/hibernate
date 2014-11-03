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
		
		//����ʽ�ı�׼����DetachedCriteria
		detachedCriteriaSearch();

	}

	private static void detachedCriteriaSearch() {
		
		
		DetachedCriteria dc=DetachedCriteria.forClass(Emp.class);
		//ģ�⹹������5����
		try {
			System.out.println("�˴�ģ��ͣ��3����");
			dc.add(Restrictions.eq("empNo", new Integer(1)));
			dc.add(Restrictions.eq("empName", "����"));
			
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("�������Ұ�ť");
		//ʵ��ռ��session�����￪ʼ
		Criteria critera=dc.getExecutableCriteria(HibernateSessionFactory.getSession());
		
		List<Emp> emps = critera.list();

		for (Emp emp : emps) {
			System.out.println(emp.getEmpNo() + "\t" + emp.getEmpName());
		}
	    
		
		
		
		
		
	}

	private static void dynamicSearch() {
		
		EmpCondition condition=new EmpCondition();
		condition.setEmpNo(new Integer(1));
		condition.setEmpName("����");
		
		Session session = HibernateSessionFactory.getSession();
		// ��׼���ҽӿ�
		Criteria criteria = session.createCriteria(Emp.class);
		
		//�˴�����ռ��5����
		
		//��̬������
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
		// ��׼���ҽӿ�
		Criteria criteria = session.createCriteria(Emp.class);
		//��ҳ����
		criteria.setMaxResults(2);
		criteria.setFirstResult(2);

		List<Emp> emps = criteria.list();

		for (Emp emp : emps) {
			System.out.println(emp.getEmpNo() + "\t" + emp.getEmpName());
		}

	}
	

	private static void demo1() {

		Session session = HibernateSessionFactory.getSession();
		// ��׼���ҽӿ�
//		Criteria criteria = session.createCriteria(Emp.class);
//		//�������
//		criteria.add(Restrictions.eq("empNo", new Integer(1)));
//		//�������2
//		criteria.add(Restrictions.eq("empName", "����"));
		//�������3ģ��
//		criteria.add(Restrictions.like("empName", "��%"));
		
		//����4 ����
//		criteria.add(Restrictions.gt("salary", new Double(5000)));
		
		//֧����ʽ���
		Criteria criteria=session.createCriteria(Emp.class)
		.addOrder(Order.asc("empName"));
		
//		.add(Restrictions.eq("empNo", new Integer(1)))
//		.add(Restrictions.eq("empName", "����"));
		
		
		List<Emp> emps = criteria.list();

		for (Emp emp : emps) {
			System.out.println(emp.getEmpNo() + "\t" + emp.getEmpName());
		}

	}
	
	private static void comlicat() {

		Session session = HibernateSessionFactory.getSession();
		Criteria criteria=session.createCriteria(Emp.class);
		Criteria criteria2=criteria.createCriteria("dept");
		         criteria2.add(Restrictions.eq("deptName", "����"));
		         
		
		
		List<Emp> emps = criteria.list();

		for (Emp emp : emps) {
			System.out.println(emp.getEmpNo() + "\t" + emp.getEmpName()+" "+emp.getDept().getDeptName());
		}

	}


}
