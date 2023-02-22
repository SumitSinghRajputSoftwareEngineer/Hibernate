package hiber.secondcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.cache.ehcache.internal.EhcacheRegionFactory;
import org.hibernate.cfg.Configuration;

import hiber.tut.Student;

//import net.sf.ehcache.hibernate.EhCacheRegionFactory;

public class SecondCacheExample {
	public static void main(String[] args) {
		
//		EhcacheRegionFactory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session session1 = factory.openSession();
		Student std1 = session1.get(Student.class, 1414);
		System.out.println(std1);
		session1.close();
		
		Session session2 = factory.openSession();
		Student std2 = session2.get(Student.class, 1414);		
		System.out.println(std2);
		session2.close();
		
		factory.close();
	}
}
