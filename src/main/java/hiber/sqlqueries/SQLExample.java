package hiber.sqlqueries;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import hiber.tut.Student;

public class SQLExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s = factory.openSession();
		
		//SQL Query
		
		String query = "select * from student";
		NativeQuery nq = s.createSQLQuery(query);
		
		List<Object[]> list = nq.list();
		
		for(Object[] std : list) {
			System.out.println(Arrays.toString(std));
		}
		
		
		s.close();
		factory.close();
	}

}
