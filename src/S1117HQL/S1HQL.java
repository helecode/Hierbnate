package S1117HQL;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import S1115HibernateCURD.S1Message;



public class S1HQL {
	public static void main(String[] args) {
		Configuration c=new Configuration().configure();
		SessionFactory sf=c.buildSessionFactory();
		Session session=sf.openSession();
		Transaction ts=session.beginTransaction();
		//1.��ѯ���м�¼
		String sql="from S1Message";
		Query q=session.createQuery(sql);
		List<S1Message> messageList=q.list();
			//ʹ��foreach����
		for(S1Message m:messageList){
			System.out.println(m);
		}
			//ʹ�õ�������
//		Iterator it=messageList.iterator();
//		if(it.hasNext()){
//			System.out.println("iterator:"+it.next());
//		}
		//2.��ѯָ������
			//1.����ʵ�������
		String hqlnew="select new S1Message (m.id,m.name,m.age) from S1Message m where m.id>2";
		Query qnew=session.createQuery(hqlnew);
		List<S1Message> allnew=qnew.list();
//		for(S1Message m:allnew){
//			System.out.println(m);
//		}
		Iterator itnew=allnew.iterator();
		while(itnew.hasNext()){
			System.out.println(itnew.next());
		}
			//2.����Object����
		String hql="select m.id,m.name,m.age from S1Message m where m.id>2";
		Query qs=session.createQuery(hql);
		List all=qs.list();
		Iterator it=all.iterator();
		while(it.hasNext()){
		Object obj[]=(Object[])it.next();
		System.out.println(obj[0]+"\t"+obj[1]+"\t"+obj[2]);
		}
		
		//3.������
			//1 ?  ռλ�� ��ͨ��ռλ����index��
		String sqlz="from S1Message where name=? and age >= ?";
		Query qa=session.createQuery(sqlz);
		qa.setString(0, "��ĳ��");
		qa.setInteger(1, 22);
		List<S1Message> messageaList=qa.list();
		for(S1Message m:messageaList){
			System.out.println("lista:"+m);
		}
			//2 :name �������� ��ͨ��ռλ����name��
		String sqln="from S1Message where name=:name and age >= :age";
		Query qn=session.createQuery(sqln);
		qn.setString("name", "��ĳ��");
		qn.setInteger("age", 22);
		List<S1Message> messagenList=qn.list();
		for(S1Message m:messagenList){
			System.out.println("listn:"+m);
		}
			//3.��װ����
		StringBuffer queryString=new StringBuffer("from S1Message where 1=1 ");
		queryString.append(" and name=:name ");
		queryString.append(" and age>=:age ");
		S2MessageProperties mp=new S2MessageProperties();
		mp.setAge(22);
		mp.setName("�����");
		Query qF=session.createQuery(queryString.toString());
		qF.setProperties(mp);
		List<S1Message> messageFList=qF.list();
		for(S1Message m:messageFList){
			System.out.println("listF:"+m);
		}
		//4.�ۺϺ���
		String sqlC="select count(distinct name),max(age),min(age),sum(age),avg(age) from S1Message ";
		//��������ֻ�Ƕ��ֵ�����Ƕ���ɴ洢��Object������
		Query qC=session.createQuery(sqlC);
		List<Object[]> Clist=qC.list();
		for(Object[] m:Clist){
			System.out.println("juhe---"+m[0]+"--"+m[1]+"--"+m[2]+"--"+m[3]+"--"+m[4]);
		}
		//5.�������
		String sql0="from S1Message order by age";
		Query qO=session.createQuery(sql0);
		List<S1Message> messageOList=qO.list();
		for(S1Message m:messageOList){
			System.out.println(m);
		}
		//6.�������
		String sqlG="select count(*) from S1Message group by age";
		Query qG=session.createQuery(sqlG);
		List OList=qG.list();
		for(Object m:OList){
			System.out.println(m);
		}
		//7.��ҳ����
		int pageNo=2;
		int pageSize=2;
		String sqlY="from S1Message";
		Query qY=session.createQuery(sqlY);
		int pageAllRecords=qY.list().size();
		qY.setFirstResult((pageNo-1)*pageSize);//���ø�ҳ��һ����¼��������
		qY.setMaxResults(pageSize);//����ÿҳ��ʾ�����ҳ��
		List<S1Message> messageYList=qY.list();
		for(S1Message m:messageYList){
			System.out.println("messageYList:"+m);
		}

	}
}
