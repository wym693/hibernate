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
		 * ������ϵ ������ϵ
		 * 
		 * �����Ƕȿ��Է�
		 * 
		 * Teacher Student վ��1 ------�� n 1 ��--- վ��1 һ�Զ���߶��һ ��ʦ��ѧ�����ڵ����һ�Զ��ϵ
		 * ����������˳���λ�� ��ϵ������ʦ ѧ������ʦ���ڵ���Ķ��һ��ϵ ����������˳���λ�� ��ϵ����ѧ��
		 * 
		 * Subject java sql html Student ��Զ� id name
		 * 
		 * 
		 * ���� ��Ʒ������ NOT ��Ʒ��id 1---------��n n ---------1
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
//		setOrderbyName3();//����ɾ��
		
//		setLazyAttribute();
		
//		classLazyAttribute();
	
		manyToOneLazyAttribute();

	}
	//ManyToOne�ӳټ���
	private static void manyToOneLazyAttribute() {
		
		Session session = HibernateSessionFactory.getSession();
		
		
		Student zhangsan=(Student) session.get(Student.class, new Integer(1));
		System.out.println("�������");
		
		System.out.println(zhangsan);
		
		System.out.println("��ӡ������ʦ����");
		System.out.println(zhangsan.getTeacher().getName());
	    
		
		
		
		
		
		
	}
	//�༶���ӳټ��� load
	private static void classLazyAttribute() {
		
		Session session = HibernateSessionFactory.getSession();
		
		//Ŀ�����Ĵ��� ���� 
		Teacher teacher=(Teacher) session.load(Teacher.class, new Integer(13));
		System.out.println("�������");
		
		
		
		System.out.println(teacher.getName());
		
		
		
		
		
	}

	private static void setLazyAttribute() {
		
		
		Session session = HibernateSessionFactory.getSession();
		
		
		Teacher teacher=(Teacher) session.get(Teacher.class, new Integer(11));
		
		teacher.getStudents().size();
		//ע��۲���־�����������û�в���Student����
		
		
		
		
	}

	//����ɾ��
	private static void setOrderbyName3(){
		
		//�ҳ�����ʦ���е�ѧ�������������
		
		Session session = HibernateSessionFactory.getSession();
		
		Teacher teacher=(Teacher) session.get(Teacher.class, new Integer(2));
		
		
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			session.delete(teacher);

			tx.commit();
			System.out.println("����ɹ�");
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
		} finally {
			HibernateSessionFactory.closeSession();
		}

		
		
		
		
		
		
		
		
	}
	
	private static void setOrderbyName2(){
		
		//�ҳ�����ʦ���е�ѧ�������������
		
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

		Teacher teacher = new Teacher("����ʦ");

		// �������ԣ�Java��Ӻù�ϵ
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
			System.out.println("����ɹ�");
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
		} finally {
			HibernateSessionFactory.closeSession();
		}

	}

	private static void oneToOneSharedPrimaryKey() {
		Student2 student2 = new Student2("����");

		StudentCard2 card2 = new StudentCard2("2013001");
		
		
		//���ù�ϵ
		student2.setCard2(card2);
		
		card2.setStudent2(student2);
		
		
		
		
		Session session = HibernateSessionFactory.getSession();

		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			session.save(student2);
			session.save(card2);

			tx.commit();
			System.out.println("����ɹ�");
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			HibernateSessionFactory.closeSession();
		}

		
		
		
		
	}

	private static void oneToOneForeignKey() {

		Student student = new Student("����");

		StudentCard card = new StudentCard("2013001");
		
		
		

//		 ���ù�ϵ
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
			System.out.println("����ɹ�");
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			HibernateSessionFactory.closeSession();
		}

	}

	private static void manyToManyTwoWay() {
		Student student1 = new Student("����");

		Student student2 = new Student("����");

		Subject java = new Subject("java");

		// ѧ�����й�ϵ
		student1.getSubjects().add(java);
		student2.getSubjects().add(java);

		// Ŀǰ˫���й�ϵ
		java.getStudents().add(student1);
		java.getStudents().add(student2);

		// ��ϵ��ͻ ������һ������ά���м�������

		Session session = HibernateSessionFactory.getSession();

		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			session.save(student1);
			session.save(student2);
			session.save(java);

			tx.commit();
			System.out.println("����ɹ�");
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			HibernateSessionFactory.closeSession();
		}

	}

	private static void manyToMany() {

		Student student1 = new Student("����");

		Student student2 = new Student("����");

		Subject java = new Subject("java");

		// �������ԣ�Java��Ӻù�ϵ
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
			System.out.println("����ɹ�");
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
		} finally {
			HibernateSessionFactory.closeSession();
		}

	}

	private static void oneToMany() {
		Student student1 = new Student("����");

		Student student2 = new Student("����");

		Teacher teacher = new Teacher("����ʦ");

		// �������ԣ�Java��Ӻù�ϵ
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
			System.out.println("����ɹ�");
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
		} finally {
			HibernateSessionFactory.closeSession();
		}

	}

	private static void manyToOne() {

		Student student1 = new Student("����");

		Student student2 = new Student("����");

		Teacher teacher = new Teacher("����ʦ");

		// �������ԣ�Java��Ӻù�ϵ
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
			System.out.println("����ɹ�");
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
		} finally {
			HibernateSessionFactory.closeSession();
		}

	}

}
