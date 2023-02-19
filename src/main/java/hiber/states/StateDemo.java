package hiber.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hiber.tut.Certificate;
import hiber.tut.Student;

public class StateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Practcal of Hibernate Object States
//		Transient
//		Persistent
//		Detached
//		Removed
		
		System.out.println("Example :");
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		
		//create student object
		//Transient State
		Student student = new Student();
		student.setId(1414);
		student.setName("Peter");
		student.setCity("New York");
		student.setCerti(new Certificate("Java Hibernate Course","2 Months"));
		
		//Persistent State
		Transaction trans = session.beginTransaction();
//		session.delete(student);//if already present
		session.save(student);
		
		student.setName("John");

		trans.commit();
		session.close();
		
		//Detached State
		
		student.setName("Sachin");
		
		factory.close();
		
		
	}

}
