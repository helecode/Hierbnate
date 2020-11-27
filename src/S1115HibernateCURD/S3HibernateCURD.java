package S1115HibernateCURD;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class S3HibernateCURD {

	public static void main(String[] args) {
		Session session=S2HibernateTool.getSession();
		Transaction ts=S2HibernateTool.getTransaction();
		//数据添加
		S1Message messageAdd=new S1Message(11,"左某人",22,"男","18279441494");
		session.save(messageAdd);
		
		//查找，get()和load只能首列单条件查询单个对象，按第一列的值进行匹配
		S1Message messageUpdate =(S1Message) session.get(S1Message.class,1);//没找到出现空指针异常
//		T02Message messageUpdate =(T02Message) session.load(T02Message.class, "nameTest");//没找到结果为null
		System.out.println("messageUpdateGet:"+messageUpdate.toString());
		//修改
		messageUpdate.setAge(38);
		session.update(messageUpdate);
		//删除 需要先查找再删除
		S1Message messageDelete=(S1Message) session.load(S1Message.class, 10);
		session.delete(messageDelete);
//		//多列多条件查询多个对象
		Query q=session.createQuery("from S1Message where age=23");
		List<S1Message> messageList=q.list();
		for(S1Message m:messageList){
			System.out.println(m);
		}
	
//		//以及缓存
		System.out.println("黎1:"+session.get(S1Message.class, 11));
		System.out.println("黎2:"+session.get(S1Message.class, 11));
		ts.commit();
		S2HibernateTool.close();
		
		

	}

}
