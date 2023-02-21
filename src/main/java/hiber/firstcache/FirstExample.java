package hiber.firstcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hiber.tut.Student;

public class FirstExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s = factory.openSession();
		
		//by default enabled
		Student std1 = s.get(Student.class, 1414);
		System.out.println(std1);
		
		System.out.println("working something............");
		
		Student std2 = s.get(Student.class, 1414);
		System.out.println(std2);
		
		
		//return true if object is present in your session cache memory
		System.out.println(s.contains(std2));
		
		s.close();
		factory.close();
	}

}
