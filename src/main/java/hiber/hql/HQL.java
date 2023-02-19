package hiber.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
		
		System.out.println("__________________ Delete Queries______________________________________");
//		Transaction tx = s.beginTransaction();
//		Query q2 = s.createQuery("delete from Student as s where s.city= :c");
//		q2.setParameter("c", "Gwalior");
//		int r  = q2.executeUpdate();
//		System.out.println("Delete: " + r);
//		tx.commit();
		
		System.out.println("_______________________Update Queries_________________________________________________");
//		Transaction tx = s.beginTransaction();
//		Query  q3 = s.createQuery("update Student set city=:c where name=:n");
//		q3.setParameter("c", "Mumbai");
//		q3.setParameter("n", "Sumit");
//		System.out.println(q3.executeUpdate());
//		tx.commit();
//		
		System.out.println("____________________Join_____________________________________");
		//how to use INNER JOIN
		Query q3 = s.createQuery("select q.question, q.questionId, a.answer from Question as q INNER JOIN q.answer as a");
		
		List<Object[]> list2 = q3.getResultList();
		for(Object[] arr : list2) {
			System.out.println(Arrays.toString(arr));
		}
		s.close();
		factory.close();
	}

}
