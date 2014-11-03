package test;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateSessionFactory;
import bean.User;

public class TestUser {

	
	public static void main(String[] args) {
		
		add();
		
		
		
		
	}

	private static void add() {
		
		
		Session session= HibernateSessionFactory.getSession();
		
		User user=new User("李四2014",25,1.73);
//		user.setId(4);
		
		
		Transaction tx=null;
		
		try {
			tx=session.beginTransaction();
			
			session.save(user);
			//evit()剔除sesion缓存里面的对象
//			session.evict(user);
			//保存完毕后，再设置新的属性值，变成脏对象
//			session.flush();//发出更新对象状态 没有提交功能
			
			
			
			
			tx.commit();//隐式调用刷新方法
			System.out.println("保存成功");
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally{
			HibernateSessionFactory.closeSession();
		}
		
		
		
		
		
		
		
		
		
		
	}

}
