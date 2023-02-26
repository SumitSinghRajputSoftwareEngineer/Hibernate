package hiber.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import hiber.tut.Student;

public class CriteriaExample {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		
		Criteria c = session.createCriteria(Student.class);
		
		//restricting or filtering list
//		c.add(Restrictions.eq("certi.course", "Ms"));
		c.add(Restrictions.gt("id", 101));
		
		List<Student> students = c.list();
		
		for(Student s: students) {
			System.out.println(s);
		}
		session.close();
		factory.close();
	}
}
