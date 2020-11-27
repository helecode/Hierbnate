package S1114HibernateFirst;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class S2HibernaterFirstTest {

	public static void main(String[] args) {
		//1.��ȡ�����ļ�hibernate.cfg.xml
		Configuration cf=new Configuration().configure();
		//2.��ȡ������ӳ����Ϣ���õ�sessionFactory����
		SessionFactory sf=cf.buildSessionFactory();
		//3.����Session����
		Session session=sf.openSession();
		//4.��������
		Transaction ts=session.beginTransaction();
		//5.ִ�в���
		session.save(new S1HibernaterFirstMessage(5,"��ĳ��",22,"��","18279441494"));
		//6.�ύ����
		ts.commit();
		//7.�رն���
		session.close();
		sf.close();
	}

}
