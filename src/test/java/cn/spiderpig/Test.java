package cn.spiderpig;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test {

	public static void main(String[] args) {
		
		Configuration cfg = null;
		SessionFactory sf = null;
		Session session = null;
		
//		User user = new User();
//		user.setName("小明");
//		user.setAge(19);

		/*
		 * org.hibernate.cfg.Configuration类的作用:
		 * 读取hibernate配置文件(hibernate.cfg.xml或hiberante.properties)。
		 * new Configuration()默认是读取hibernate.properties; 
		 * 所以使用new Configuration().configure()来读取hibernate.cfg.xml配置文件。
		 */
		cfg = new Configuration().configure();

		/*
		 * 创建SessionFactory，一个数据库对应一个SessionFactory
		 * 并且SessionFactory是线线程安全的,因为它是工厂模式，每次都都生成一个新的副本对象
		 */
		sf = cfg.buildSessionFactory();

		try {
			// 创建session
			// 此处的session并不是web中的session
			// session只有在用时，才建立concation,session还管理缓存。
			// session用完后，必须关闭。
			// session是非线程安全，一般是一个请求一个session.
			/* getHiberanteTemplate 、getCurrentSession和OpenSession的区别
			 * 采用getCurrentSession()创建的Session会绑定到当前的线程中去、而采用OpenSession()则不会。
			 * 采用getCurrentSession()创建的Session在commit或rollback后会自动关闭，采用OpenSession()必须手动关闭。
			 * 采用getCurrentSession()需要在Hibernate.cfg.xml配置文件中加入如下配置：
			 * 如果是本地事物，及JDBC一个数据库：
			 * <propety name=”Hibernate.current_session_context_class”>thread</propety>
			 * 如果是全局事物，及jta事物、多个数据库资源或事物资源：
			 * <propety name=”Hibernate.current_session_context_class”>jta</propety>
			 * 使用spring的getHiberanteTemplate 就不需要考虑事务管理和session关闭的问题
			 */
			session = sf.openSession();
			//session = sf.getCurrentSession();

			// 手动开启事务(可以在hibernate.cfg.xml配置文件中配置自动开启事务)
			session.beginTransaction();
			/*
			 * 保存数据，此处的数据是保存对象，这就是hibernate操作对象的好处，
			 * 我们不用写那么多的JDBC代码，只要利用session操作对象，至于hibernat如何存在对象，这不需要我们去关心它，
			 * 这些都有hibernate来完成。我们只要将对象创建完后，交给hibernate就可以了。
			 */
//			session.save(user);
			
			SQLQuery sqlQuery = session.createSQLQuery("SELECT c_name FROM t_user u ");
			System.out.println(sqlQuery.list());
			
			Query query = session.createQuery(" SELECT name FROM User u ");
			System.out.println(query.list());
			
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			// 回滚事务
			session.getTransaction().rollback();
		} finally {
			// 关闭session
			session.close();
			sf.close();
		}
	}

}
