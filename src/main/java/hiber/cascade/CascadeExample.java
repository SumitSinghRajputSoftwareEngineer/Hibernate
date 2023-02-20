package hiber.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hiber.map.Answer;
import hiber.map.Question;

public class CascadeExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s = factory.openSession();
		
		Question q = new Question();
		q.setQuestionId(2357);
		q.setQuestion("Whast is Cascading..?");
		
		Answer a1 = new Answer(265, "In hibernate, it is an important concept..");
		Answer a2 = new Answer(267, "second answer");
		Answer a3 = new Answer(786, "third answer");
		
		List<Answer> list = new ArrayList<Answer>();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		
		q.setAnswer(list);
		
		Transaction tx = s.beginTransaction();
		s.save(q);
		tx.commit();
		
		s.close();
		factory.close();

	}

}
