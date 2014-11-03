package test;

import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import util.HibernateSessionFactory;
import bean.Student;
import bean.Student2;
import bean.StudentCard;
import bean.StudentCard2;
import bean.Subject;
import bean.Teacher;

public class TestAssosiation {

	public static void main(String[] args) {

		/*
		 * 关联关系 数量关系
		 * 
		 * 互换角度看对方
		 * 
		 * Teacher Student 站在1 ------》 n 1 《--- 站在1 一对多或者多对一 老师和学生存在单向的一对多关系
		 * 代表了配置顺序和位置 关系放在老师 学生和老师存在单向的多对一关系 代表了配置顺序和位置 关系放在学生
		 * 
		 * Subject java sql html Student 多对多 id name
		 * 
		 * 
		 * 订单 商品的种类 NOT 商品的id 1---------》n n ---------1
		 * 
		 * Student studentCard 1 1
		 */

		// manyToOne();

//		 oneToMany();

		// manyToMany();

		// manyToManyTwoWay();

//		oneToOneForeignKey();
		
//		oneToOneSharedPrimaryKey();
		
//		setOrderbyName();
//		setOrderbyName3();//级联删除
		
//		setLazyAttribute();
		
//		classLazyAttribute();
	
		manyToOneLazyAttribute();

	}
	//ManyToOne延迟加载
	private static void manyToOneLazyAttribute() {
		
		Session session = HibernateSessionFactory.getSession();
		
		
		Student zhangsan=(Student) session.get(Student.class, new Integer(1));
		System.out.println("查找完毕");
		
		System.out.println(zhangsan);
		
		System.out.println("打印关联老师资料");
		System.out.println(zhangsan.getTeacher().getName());
	    
		
		
		
		
		
		
	}
	//类级别延迟加载 load
	private static void classLazyAttribute() {
		
		Session session = HibernateSessionFactory.getSession();
		
		//目标对象的代理 引用 
		Teacher teacher=(Teacher) session.load(Teacher.class, new Integer(13));
		System.out.println("查找完毕");
		
		
		
		System.out.println(teacher.getName());
		
		
		
		
		
	}

	private static void setLazyAttribute() {
		
		
		Session session = HibernateSessionFactory.getSession();
		
		
		Teacher teacher=(Teacher) session.get(Teacher.class, new Integer(11));
		
		teacher.getStudents().size();
		//注意观察日志输出，看看有没有查找Student对象
		
		
		
		
	}

	//级联删除
	private static void setOrderbyName3(){
		
		//找出李老师所有的学生并且排序输出
		
		Session session = HibernateSessionFactory.getSession();
		
		Teacher teacher=(Teacher) session.get(Teacher.class, new Integer(2));
		
		
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			session.delete(teacher);

			tx.commit();
			System.out.println("保存成功");
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
		} finally {
			HibernateSessionFactory.closeSession();
		}

		
		
		
		
		
		
		
		
	}
	
	private static void setOrderbyName2(){
		
		//找出李老师所有的学生并且排序输出
		
		Session session = HibernateSessionFactory.getSession();
		
		Teacher teacher=(Teacher) session.get(Teacher.class, new Integer(2));
		
		Set<Student>students=teacher.getStudents();
		for (Student student : students) {
			System.out.println(student.getName());
		}
		
		
		
		
		
	}
	
	private static void setOrderbyName() {
		Student student1 = new Student("A");

		Student student2 = new Student("B");
		Student student3 = new Student("C");

		Student student4 = new Student("D");
		Student student5 = new Student("E");

		Student student6 = new Student("F");

		Teacher teacher = new Teacher("李老师");

		// 设置属性，Java添加好关系
		teacher.getStudents().add(student1);
		teacher.getStudents().add(student2);
		teacher.getStudents().add(student3);
		teacher.getStudents().add(student4);
		teacher.getStudents().add(student5);
		teacher.getStudents().add(student6);
		

		Session session = HibernateSessionFactory.getSession();

		Transaction tx = null;

		try {
			tx = session.beginTransaction();

//			session.save(student1);
//			session.save(student2);
//			session.save(student3);
//			session.save(student4);
//			session.save(student5);
//			session.save(student6);
			
			session.save(teacher);

			tx.commit();
			System.out.println("保存成功");
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
		} finally {
			HibernateSessionFactory.closeSession();
		}

	}

	private static void oneToOneSharedPrimaryKey() {
		Student2 student2 = new Student2("李四");

		StudentCard2 card2 = new StudentCard2("2013001");
		
		
		//设置关系
		student2.setCard2(card2);
		
		card2.setStudent2(student2);
		
		
		
		
		Session session = HibernateSessionFactory.getSession();

		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			session.save(student2);
			session.save(card2);

			tx.commit();
			System.out.println("保存成功");
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			HibernateSessionFactory.closeSession();
		}

		
		
		
		
	}

	private static void oneToOneForeignKey() {

		Student student = new Student("李四");

		StudentCard card = new StudentCard("2013001");
		
		
		

//		 设置关系
		student.setCard(card);
//		
		card.setStudent(student);

		Session session = HibernateSessionFactory.getSession();

		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			session.save(student);
			session.save(card);

			tx.commit();
			System.out.println("保存成功");
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			HibernateSessionFactory.closeSession();
		}

	}

	private static void manyToManyTwoWay() {
		Student student1 = new Student("张三");

		Student student2 = new Student("李四");

		Subject java = new Subject("java");

		// 学生上有关系
		student1.getSubjects().add(java);
		student2.getSubjects().add(java);

		// 目前双向都有关系
		java.getStudents().add(student1);
		java.getStudents().add(student2);

		// 关系冲突 让其中一方放弃维护中间表的义务

		Session session = HibernateSessionFactory.getSession();

		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			session.save(student1);
			session.save(student2);
			session.save(java);

			tx.commit();
			System.out.println("保存成功");
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			HibernateSessionFactory.closeSession();
		}

	}

	private static void manyToMany() {

		Student student1 = new Student("张三");

		Student student2 = new Student("李四");

		Subject java = new Subject("java");

		// 设置属性，Java添加好关系
		Subject php = new Subject("php");
		java.getStudents().add(student1);
		java.getStudents().add(student2);

		Session session = HibernateSessionFactory.getSession();

		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			session.save(student1);
			session.save(student2);
			session.save(java);
			session.save(php);

			tx.commit();
			System.out.println("保存成功");
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
		} finally {
			HibernateSessionFactory.closeSession();
		}

	}

	private static void oneToMany() {
		Student student1 = new Student("张三");

		Student student2 = new Student("李四");

		Teacher teacher = new Teacher("李老师");

		// 设置属性，Java添加好关系
		teacher.getStudents().add(student1);
		teacher.getStudents().add(student2);

		Session session = HibernateSessionFactory.getSession();

		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			session.save(student1);
			session.save(student2);
			session.save(teacher);

			tx.commit();
			System.out.println("保存成功");
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
		} finally {
			HibernateSessionFactory.closeSession();
		}

	}

	private static void manyToOne() {

		Student student1 = new Student("张三");

		Student student2 = new Student("李四");

		Teacher teacher = new Teacher("李老师");

		// 设置属性，Java添加好关系
		student1.setTeacher(teacher);
		student2.setTeacher(teacher);

		Session session = HibernateSessionFactory.getSession();

		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			session.save(student1);
			session.save(student2);
			session.save(teacher);

			tx.commit();
			System.out.println("保存成功");
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
		} finally {
			HibernateSessionFactory.closeSession();
		}

	}

}
