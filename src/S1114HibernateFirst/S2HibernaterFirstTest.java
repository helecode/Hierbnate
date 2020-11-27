package S1114HibernateFirst;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class S2HibernaterFirstTest {

	public static void main(String[] args) {
		//1.读取配置文件hibernate.cfg.xml
		Configuration cf=new Configuration().configure();
		//2.读取并解析映射信息，得到sessionFactory对象
		SessionFactory sf=cf.buildSessionFactory();
		//3.创建Session对象
		Session session=sf.openSession();
		//4.开启事务
		Transaction ts=session.beginTransaction();
		//5.执行操作
		session.save(new S1HibernaterFirstMessage(5,"左某人",22,"男","18279441494"));
		//6.提交事务
		ts.commit();
		//7.关闭对象
		session.close();
		sf.close();
	}

}
