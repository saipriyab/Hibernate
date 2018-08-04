package com.example1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

public static void main(String args[])throws Exception
{
	
	SessionFactory sf=new Configuration().configure().addAnnotatedClass(Flower.class).buildSessionFactory();
	Session s=sf.openSession();
	try
	{
		s.beginTransaction();
		Flower f=new Flower();
		f.setFid("xyz7");
		f.setColor("red");
		f.setFname("rose");
		f.setPrice(12);
		s.save(f);
		s.getTransaction().commit();
		System.out.println("inserted");
	}
	catch(Exception e)
	{
		sf.close();
		s.close();
	
	}
}
}
