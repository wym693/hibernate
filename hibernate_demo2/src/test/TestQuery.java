package test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.classic.Session;

import util.HibernateSessionFactory;
import bean.User;
import bean.UserCondition;

public class TestQuery {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		simple();

	}

	private static void simple() {
		
		
		Session session=HibernateSessionFactory.getSession();
		
		String sql="selecT * From t_user_new";
		
//		String hql="from User where name=:name and age=:age and height=:height order by id asc";
	  
	
	   StringBuffer sb=new StringBuffer();
	   sb.append("select new User(name ,age) from User where 1=1");
//	   UserCondition condition =new UserCondition();
//	   condition.setAge(25);
//	   condition.setName("����");
//	   
//	   if(null!=condition.getAge()){
//		   sb.append(" and age=:age ");
//	   }
//	   if(null!=condition.getName()){
//		   sb.append(" and name=:name ");
//	   }
//	   if(null!=condition.getHeight()){
//		   sb.append(" and height=:height");
//	   }
	   
	   
	  
	  
		
		Query query=session.createQuery(sb.toString());
		//����
//		query.setProperties(condition);

		//��ҳ����ʾ�ڶ�ҳ
//		query.setMaxResults(3);
//		query.setFirstResult(0);
		
		
		
		List<User> users=query.list();
//		
//		
//		
//		
//		//1
//		System.out.println("��һ�ַ�ʽ");
		for (User user : users) {
			System.out.println(user.getName()+"\t"+user.getId()+"\t"+user.getAge());
		}
		
//		User user=(User) query.uniqueResult();
//		
//		System.out.println(user.getName()+"\t"+user.getId()+"\t"+user.getAge());
//
//		List<Object[]> result=query.list();
//		
//		for (Object[] objects : result) {
//			
//			for (Object object : objects) {
//				System.out.print(object+" "); 
//			}
//			System.out.println();
//			
//		}
		
		
		
		
		
		
		
		
		
	}

}
