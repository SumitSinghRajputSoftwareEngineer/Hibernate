package hiber.tut;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	Configuration cfg = new Configuration();
    	cfg.configure("hibernate.cfg.xml");
    	SessionFactory factory = cfg.buildSessionFactory();
    	System.out.println(factory);
    	System.out.println(factory.isClosed());
    	
    	//creating object of Student class
    	Student st = new Student();
    	st.setId(101);
    	st.setName("Sumit");
    	st.setCity("Gwalior");
    	System.out.println(st.toString());
    	
    	//creating object of Address class
    	Address ad = new Address();
    	ad.setStreet("street1");
    	ad.setCity("Delhi");
    	ad.setOpen(true);
    	ad.setAddedDate(new Date());
    	ad.setX(1234.123);
    	//Reading image
    	FileInputStream fs = new FileInputStream("src/main/java/image.jpg");
    	byte[] data = new byte[fs.available()];
    	fs.read(data);
    	ad.setImage(data);
    	///
    	Session session = factory.openSession();
    	Transaction tx =  session.beginTransaction();
    	session.save(st);
    	session.save(ad);
    	tx.commit();
    	session.close();
    	System.out.println("Done....");
    }
}
