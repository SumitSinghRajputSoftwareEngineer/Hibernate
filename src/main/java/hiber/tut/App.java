package hiber.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Configuration cfg = new Configuration();
    	cfg.configure("hibernate.cfg.xml");
    	SessionFactory factory = cfg.buildSessionFactory();
    	System.out.println(factory);
    	System.out.println(factory.isClosed());
    	
    	//creating student
    	Student st = new Student();
    	st.setId(101);
    	st.setName("Sumit");
    	st.setCity("Gwalior");
    	System.out.println(st.toString());
    	
    	///
    	Session session = factory.openSession();
    	session.beginTransaction();
    	session.save(st);
    	session.getTransaction().commit();
    	session.close();
    }
}
