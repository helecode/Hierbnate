package S1116RelationMapping;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class S3RelationMappingTest {

	public static void main(String[] args) {
		Configuration c=new Configuration().configure();
		SessionFactory sf=c.buildSessionFactory();
		Session session=sf.openSession();
		Transaction transaction=session.beginTransaction();

	}

}
