package hiber.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbedDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Student student1 = new Student();
		student1.setId(104);
		student1.setName("Amit");
		student1.setCity("Kota");
		Certificate certificate1 = new Certificate();
		certificate1.setCourse("MMBS");
		certificate1.setDuration("6 years");
		student1.setCerti(certificate1);
		
		Student student2 = new Student();
		student2.setId(105);
		student2.setName("Shreya");
		student2.setCity("Seoul");
		Certificate certificate2 = new Certificate();
		certificate2.setCourse("Ms");
		certificate2.setDuration("2.5 years");
		student2.setCerti(certificate2);
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(student1);
		session.save(student2);
		tx.commit();
		
		session.close();
		factory.close();
	}

}
