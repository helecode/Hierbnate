package S1118Criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;

import S1115HibernateCURD.S1Message;

public class S1Criteria {
		public static void main(String[] args) {
			Configuration cf=new Configuration().configure();
			SessionFactory sessionFactory=cf.buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction t=session.beginTransaction();
			//1.������ѯ
			Criteria criteria=session.createCriteria(S1Message.class);
			criteria.add(Restrictions.like("name", "%��%"));
			criteria.add(Restrictions.eq("age", 22));
			criteria.add(Restrictions.or(Restrictions.like("sex", "��"), Restrictions.like("sex", "Ů")));
			List<S1Message> messageList=criteria.list();	
			for(S1Message m:messageList){
				System.out.println(m);
			}
			//2.������װ��ѯ
			S1Message messageP=new S1Message();
			messageP.setAge(23);
			messageP.setSex("��");
			messageP.setName("%��%");
			Criteria criteriaF=session.createCriteria(S1Message.class);
			criteriaF.add(Example.create(messageP));
			List<S1Message> messageFList=criteriaF.list();	
			for(S1Message m:messageFList){
				System.out.println(m);
			}
			
			//4.��ҳ����
			int pageNO=2;
			int pageSize=5;
			Criteria criteriaY=session.createCriteria(S1Message.class);
			criteriaY.setFirstResult((pageNO-1)*pageSize);
			criteriaY.setMaxResults(pageSize);
			List<S1Message> messageYList=criteriaY.list();	
			for(S1Message m:messageYList){
				System.out.println(m);
			}
			
		}
}
