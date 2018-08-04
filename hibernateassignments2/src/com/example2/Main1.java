package com.example2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main1 {
public static void main(String args[])
{
	SessionFactory s1=new Configuration().configure().addAnnotatedClass(Flower1.class).buildSessionFactory();
	Session s2=s1.openSession();
	try
	{
		s2.beginTransaction();
	    Flower1 f=new Flower1();
	    f.setC("blue");
	    f.setFid("xyz2");
	    f.setP(10);
	    f.setFname("rose");
	    s2.save(f);
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
