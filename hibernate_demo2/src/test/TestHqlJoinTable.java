package test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import util.HibernateSessionFactory;
import bean.Student;
import bean.Teacher;

public class TestHqlJoinTable {
	
	public static void main(String[] args) {
		
		
//		innerjoin();
		
//		innerjoinfetch();
		
		leftjoin();
	}

	private static void leftjoin() {
		//学生和教师的左外连接
		String hql="from Student s left join s.teacher";
		Session session=HibernateSessionFactory.getSession();
		
		Query query=session.createQuery(hql);
		
		
		List<Object[]> rows=query.list();
		
		for (Object[] row : rows) {
			
			if(row[0] instanceof Student){
				Student student=(Student) row[0];
				System.out.print(student.getId()+" "+student.getName());
				
			}
			if(row[1] instanceof Teacher){
				Teacher teacher=(Teacher) row[1];
				System.out.println(teacher.getId()+" "+teacher.getName()+" ");
				
			}
			
			
		}
		
		
		
		
		
		
	}

	private static void innerjoinfetch() {
	Session session=HibernateSessionFactory.getSession();
		
		String hql="from Teacher t inner join fetch t.students";
		Query query=session.createQuery(hql);
		
		
		
		List<Teacher> teachers=query.list();
//		
		for (Teacher teacher : teachers) {
			System.out.println(teacher.getId()+" "+teacher.getName());
		}
		
		
		
		
	}

	private static void innerjoin() {
		
		Session session=HibernateSessionFactory.getSession();
		
		String hql="from Student s inner join s.teacher";
		Query query=session.createQuery(hql);
		
		
		List<Object[]> rows=query.list();
		
		for (Object[] row : rows) {
			
			if(row[0] instanceof Student){
				Student student=(Student) row[0];
				System.out.print(student.getId()+" "+student.getName());
				
			}
			if(row[1] instanceof Teacher){
				Teacher teacher=(Teacher) row[1];
				System.out.println(teacher.getId()+" "+teacher.getName()+" ");
				
			}
			
			
		}
		
//		for (Student student : students) {
//			System.out.println(student.getId()+" "+student.getName());
//		}
		
		
		
		
		
	}

}
