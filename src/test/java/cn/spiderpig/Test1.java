package cn.spiderpig;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test1 {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration().configure();	//加载Hibernate的配置，即：hibernate.cfg.xml
		SessionFactory sf = cfg.buildSessionFactory();			//获取Session代理工厂
		Session session = sf.openSession();
		
		//已下测试确保数据库里的User、Product、Order表里有值
//		try {
//			Query query = session.createQuery(" FROM User u ");
//			List<User> list = query.list();
//			for(User u:list){
//				System.out.println(u.getName());
//				System.out.println("=========================");
//				for(Order o:u.getOrder()){
//					System.out.println(o.getId());
//					System.out.println(o.getUser().getName());//查过User了，就不用再查了
//					System.out.println(o.getProduct().getName());
//				}
//				System.out.println("++++++++++++++++++++++++");
//			}
//		} catch (HibernateException e) {
//			e.printStackTrace();
//			session.getTransaction().rollback();	//若报错则回滚事物
//		} finally {
//			session.close();		//关闭当前session
//			sf.close();				//关闭session工厂
//		}

		
		/**
		 * User user1 = (User) session.get(User.class, "1");
		   User user2 = (User) session.load(User.class, "1");
		   
		   Query query = session.createQuery(" FROM User u WHERE u.age = ? ");
		   query.setParameter(0, 32);
			List<User> list = query.list();
			for(User u:list){
				System.out.println(u.getName());
			}
			
			Query query = session.createQuery(" SELECT MAX(u.age) FROM User u ");
			List list = query.list();
			Object o = query.uniqueResult();
		   
		 */
		
		
		/**
		 * String hql = " UPDATE User u SET u.name = ?,u.age = ? WHERE u.id = ? ";
			
			Query query = session.createQuery(hql);
			query.setParameter(0, "小明");
			query.setParameter(1, 250);
			query.setParameter(2, "1");
			query.executeUpdate();
		 */
		
		
		/*String hql = " DELETE FROM User u WHERE u.id = '2c90b2935a169ea1015a169ea20f0000' ";
		Query query = session.createQuery(hql);
		query.executeUpdate();
		
		String hql = " DELETE FROM User u WHERE u.id = ? AND u.name = ? ";
		Query query = session.createQuery(hql);
		query.setParameter(0, "1");
		query.setParameter(1, "2123");
		query.executeUpdate();
		*/
		
	}

}
