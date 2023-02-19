package hiber.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import hiber.tut.Student;

public class HQL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session s = factory.openSession();
		
		String query = "from Student as s where s.city=:x and s.name=:n";
		Query q = s.createQuery(query);
		q.setParameter("x", "Gwalior");
		q.setParameter("n", "Sumit");
		//single- Unique
		//Multiple - list
		List<Student> list = q.list();
		
		for(Student student : list) {
			System.out.println(student.getName());
		}
		
		s.close();
		factory.close();
	}

}
