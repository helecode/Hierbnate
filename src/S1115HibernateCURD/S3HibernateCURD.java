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
		//�������
		S1Message messageAdd=new S1Message(11,"��ĳ��",22,"��","18279441494");
		session.save(messageAdd);
		
		//���ң�get()��loadֻ�����е�������ѯ�������󣬰���һ�е�ֵ����ƥ��
		S1Message messageUpdate =(S1Message) session.get(S1Message.class,1);//û�ҵ����ֿ�ָ���쳣
//		T02Message messageUpdate =(T02Message) session.load(T02Message.class, "nameTest");//û�ҵ����Ϊnull
		System.out.println("messageUpdateGet:"+messageUpdate.toString());
		//�޸�
		messageUpdate.setAge(38);
		session.update(messageUpdate);
		//ɾ�� ��Ҫ�Ȳ�����ɾ��
		S1Message messageDelete=(S1Message) session.load(S1Message.class, 10);
		session.delete(messageDelete);
//		//���ж�������ѯ�������
		Query q=session.createQuery("from S1Message where age=23");
		List<S1Message> messageList=q.list();
		for(S1Message m:messageList){
			System.out.println(m);
		}
	
//		//�Լ�����
		System.out.println("��1:"+session.get(S1Message.class, 11));
		System.out.println("��2:"+session.get(S1Message.class, 11));
		ts.commit();
		S2HibernateTool.close();
		
		

	}

}
