package hiber.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		//creating question object
		Question question1 = new Question();
		question1.setQuestionId(1212);
		question1.setQuestion("What is Java ?");
		//creating answer object
		Answer answer1 = new Answer();
		answer1.setAnswerId(343);
		answer1.setAnswer("Java is a programming language.");
		answer1.setQuestion(question1);
		
		Answer answer2 = new Answer();
		answer2.setAnswerId(344);
		answer2.setAnswer("Java is part of Oracle");
		answer2.setQuestion(question1);
		
		Answer answer3 = new Answer();
		answer3.setAnswerId(345);
		answer3.setAnswer("With the help of Java web development is possible.");
		answer3.setQuestion(question1);
		
		
		Session session = factory.openSession();
		Transaction tx =  session.beginTransaction();
		session.save(question1);
		session.save(answer1);
		session.save(answer2);
		session.save(answer3);
		tx.commit();
//		session.getTransaction().commit();
		
		session.close();
		factory.close();
		
	}

}
