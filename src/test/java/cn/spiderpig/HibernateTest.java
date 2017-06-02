package cn.spiderpig;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;


public class HibernateTest {
    
    @Test
    public void add(){
        // 以下是固定写法
        Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        
     // 新建User，然后插入数据库
//        User user = new User();
//        user.setId(1);
//        user.setUsername("小明");
//        user.setPassword("123");
//        session.save(user);

        // 删除ID为402890eb5a37af0f015a37af11b00000的用户
        // String hql = " DELETE FROM User u WHERE u.id = ? ";
        // Query q = session.createQuery(hql);
        // q.setParameter(0, "402890eb5a37af0f015a37af11b00000");
        // q.executeUpdate();

        // 更新用户数据，将ID为402890eb5a37b4de015a37b4e0d30000的用的名字改为"小明"
        // String hql = " UPDATE User u SET u.name = ? WHERE u.id = ? ";
        // Query q = session.createQuery(hql);
        // q.setParameter(0, "小明");
        // q.setParameter(1, "402890eb5a37b4de015a37b4e0d30000");
        // q.executeUpdate();

        // 查询所有的用户的名字
        /*
         * String hql = " FROM User u "; Query qurey = session.createQuery(hql);
         * List<User> list = qurey.list(); for (User u : list) {
         * System.out.println(u.getName()); }
         */

        session.getTransaction().commit();
        session.close();
        sf.close();
    }

}
