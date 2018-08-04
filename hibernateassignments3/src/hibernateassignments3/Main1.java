package hibernateassignments3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main1 {
public static void main(String args[])
{
	SessionFactory s1=new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();
	Session s2=s1.openSession();
	try
	{
		s2.beginTransaction();
	   Employee e2=new Employee();
	   Employee e1=new Employee();
	  e2.setDesignation("teacher");
	  e2.setSalary(1000);
	  e1.setDesignation("student");
	  e1.setSalary(10000);
	  s2.save(e2);
	  s2.save(e1);
		s2.getTransaction().commit();
		System.out.println("inserted");
	}
	catch(Exception e)
	{
		s1.close();
		s2.close();
	}
	
}
}
