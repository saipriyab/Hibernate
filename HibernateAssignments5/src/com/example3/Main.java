package com.example3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
public static void main(String args[])
{
	SessionFactory s2=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Flower.class).buildSessionFactory();
	Session s3=s2.openSession();
	try
	{
		s3.beginTransaction();
		Flower f2=(Flower)s3.get(Flower.class,1);
		System.out.println(f2.getColor()+" "+f2.getFlowername()+" "+f2.getFlowerid()+" "+f2.getPrice());
	
		s3.delete(f2);
		System.out.println("deleted");
		s3.getTransaction().commit();
	}
	catch(Exception e)
	{
		s2.close();
		s3.close();
	}
}
}
