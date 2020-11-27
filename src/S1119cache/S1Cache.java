package S1119cache;

import org.hibernate.Session;
import org.hibernate.Transaction;

import S1115HibernateCURD.S1Message;
import S1115HibernateCURD.S2HibernateTool;

public class S1Cache {
	public static void main(String[] args) {
		Session session1=S2HibernateTool.getSession();

		System.out.println("¿Ë1:"+session1.get(S1Message.class, 1));
		System.out.println("¿Ë2:"+session1.get(S1Message.class, 1));

	}
}
