package com.example1;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
public static void main(String args[])
{
	SessionFactory sf=new Configuration().configure().addAnnotatedClass(Car.class).buildSessionFactory();
	Session s2=sf.openSession();
	try
	{
		s2.beginTransaction();
		
		Query q1=s2.createQuery("select c.Manfacturer from Car c where c.Manfacturer LIKE 'p%'");
		List<String> c7=q1.list();
		for(String c6:c7)
		{
			System.out.print(c6);
			System.out.println();
		}
		s2.getTransaction().commit();
	}
	catch(Exception e)
	{
		
	}
}
}
