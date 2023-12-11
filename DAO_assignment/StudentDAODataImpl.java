package mypack;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentDAODataImpl implements StudentDAO {

	SessionFactory factory;
	Session session;
	//Transaction tr=session.beginTransaction();
	
	
	//private SessionFactory sf;
	//private Session session;
	
	public StudentDAODataImpl()
	{
		Configuration cfg=new Configuration();		
		cfg.configure("Hibernate.cfg.xml");
		factory=cfg.buildSessionFactory();
	}
	
	
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		session=factory.openSession();
		Transaction transaction = session.beginTransaction();
		   session.persist(student);
		   transaction.commit();
		   session.close();
		   System.out.println("Done with commit");
		
		
	}

	

}
