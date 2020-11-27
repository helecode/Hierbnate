package S1115HibernateCURD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class S2HibernateTool {
	public static Configuration c=null;
	public static SessionFactory sf=null;
	public static Session session=null;
	public static Transaction transaction=null;
	static {
		System.out.print("优于主方法前执行");
		c=new Configuration().configure();
		sf=c.buildSessionFactory();
		session=sf.openSession();
	}
	public static Session getSession(){	
		return session;
	}
	public static Transaction getTransaction(){	
		transaction=getSession().beginTransaction();
		return transaction;
	}
	public static void close(){
		if(session!=null)session.close();
		if(sf!=null)sf.close();
	}
}
