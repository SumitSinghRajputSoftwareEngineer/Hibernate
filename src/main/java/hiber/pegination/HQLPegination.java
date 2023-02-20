package hiber.pegination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import hiber.tut.Student;

public class HQLPegination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s = factory.openSession();
		
		Query<Student> q = s.createQuery("from Student",Student.class);
		//implementation pegination using hibernate
		
		q.setFirstResult(0);
		q.setMaxResults(5);
		
		List<Student> list = q.list();
		
		for(Student std : list) {
			System.out.println(std.getId()+" : "+std.getName()+" : "+ std.getCity());
		}
		
		s.close();
		
		factory.close();
	}

}
