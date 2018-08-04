package com.example1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class Main {
public static void main(String args[]) throws ParseException
{
	Scanner s=new Scanner(System.in);
	System.out.println("select the below option");
	System.out.println("1.insert"+" "+"2.delete"+" "+"3.update"+" "+"4.displayall"+" "+"5.printsalaryslip");
	int p=s.nextInt();;
	switch(p)
	{
	case 1:System.out.println("enter enployee name");
	       String empname=s.next();
	       System.out.println("enter employee designation");
	       String empdesignation=s.next();
	       System.out.println("enter date of birth in the format of DD/MM/YYYY");
	       String empdob=s.next();
	    		   System.out.println("enter date of joining in the format of DD/MM/YYYY");
	       String empjod=s.next();
	       System.out.println("enter age");
	       int empage=s.nextInt();
	       System.out.println("enter basic pay");
	       float empbasic_pay=s.nextFloat();
	       int flag=0;
	       Employee e2=new Employee();
	       if(empname.length()<=20)
	       {
	    	   if(empdesignation.equals("SE")||empdesignation.equals("SSE")||empdesignation.equals("SS")||empdesignation.equals("SSS"))
	    	   {
	    		   if(empage>=18&&empage<=60)
	    		   {
	    			   System.out.println("hello");
	    			   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
	    			   LocalDate l1 = LocalDate.parse(empdob, formatter);
	    			   LocalDate l2 = LocalDate.parse(empjod, formatter);
	    			   Period period = Period.between(l1,l2);
	    			   if(period.getYears()>18)
	    			   {
	    				   if(empbasic_pay>60000)
	    				   {
	    					flag=1;   
	    				   }
	    				}
	    			   
	    		   }
	    	   }
	       }
	       if(flag==1)
	       {
	    	   SessionFactory s2=new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();
	    	   Session s3=s2.openSession();
	    	   try
	    	   {
	    		   s3.beginTransaction();
	    		   e2.setEmpname(empname);
	    		   e2.setEmpdesignation(empdesignation);
	    		   e2.setEmpage(empage);
	    		   e2.setEmpbasic_pay(empbasic_pay);
	    		   java.util.Date d1=new SimpleDateFormat("d-MM-yyyy").parse(empdob);
	    		   e2.setEmpdob(d1);
	    		   java.util.Date d2=new SimpleDateFormat("d-MM-yyyy").parse(empjod);
	    		   e2.setEmpjod(d2);
	    		   s3.save(e2);
	    		   System.out.println("inserted");
	    		   s3.getTransaction().commit();
	    	   }
	    	   catch(Exception e)
	    	   {
	    		   s2.close();
	    		   s3.close();
	    		   System.out.println(e);
	    	   }
	       }
	       break;
	case 2:System.out.println("enter employee code to delete");
	       long p5=s.nextLong();
	       SessionFactory s5=new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Employee2.class).buildSessionFactory();
	       Session se1=s5.openSession();
	       try
	       {
	    	  se1.beginTransaction();
	    	  Employee e7=(Employee)se1.get(Employee.class, p5);
	    	  Employee2 em2=new Employee2();
	    	  em2.setDesignation(e7.getEmpdesignation());
	    	  em2.setEcode(e7.getEmpcode());
	    	  em2.setEname(e7.getEmpname());
	    	  float hra=e7.getEmpbasic_pay()*0.1f;
    		  float da=e7.getEmpbasic_pay()*0.2f;
    		  float sal=hra+da+e7.getEmpbasic_pay();
    		  em2.setSalary(sal);
    		  em2.setMdate(new Date());
    		  se1.delete(e7);
    		  se1.save(em2);
    		  se1.getTransaction().commit();
    		  System.out.println("Deleted and updated in tables");
	       }
	       catch(Exception e5)
	       {
	    	   s5.close();
	    	   se1.close();
	       }
		   break;
	case 3:System.out.println("Select option to modify");
	       System.out.println("1.Designation"+" "+"2.Basicpay");
	       int p3=s.nextInt();
	       SessionFactory s7=new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Employee1.class).buildSessionFactory();
	       Session s8=s7.openSession();
	       if(p3==1)
	       {
	    	   System.out.println("enter employee id");
	    	   long j=s.nextLong();
	    	   System.out.println("enter designation");
	    	   String p7=s.next();
	    	   try
	    	   {
	    	   s8.beginTransaction();
	    	   Employee e5=(Employee)s8.get(Employee.class,j);
	    	   e5.setEmpdesignation(p7);
	    	   s8.update(e5);
	    	   Employee1 e=new Employee1();
	    	   e.setBasicpay(e5.getEmpbasic_pay());
	    	   e.setDate_of_modification(new Date());
	    	   e.setDesignation(p7);
	    	   e.setModification_id(e5.getEmpcode());
	    	   s8.save(e);
	    	   s8.getTransaction().commit();
	    	   System.out.println("updated in both tables");
	    	   }
	    	   catch(Exception e5)
	    	   {
                  s7.close();
	    		   s8.close();
	    		  System.out.println(e5);
	    	   }
	       }
	       if(p3==2)
	       {
	    	   System.out.println("enter employee id");
	    	   long j=s.nextLong();
	    	   System.out.println("enter basic pay");
	    	   float p7=s.nextFloat();
	    	   try
	    	   {
	    	   s8.beginTransaction();
	    	   Employee e5=(Employee)s8.get(Employee.class,j);
	    	   e5.setEmpbasic_pay(p7);;
	    	   s8.update(e5);
	    	   Employee1 e=new Employee1();
	    	   e.setBasicpay(p7);
	    	   e.setDate_of_modification(new Date());
	    	   e.setDesignation(e5.getEmpdesignation());
	    	   e.setModification_id(e5.getEmpcode());
	    	   s8.save(e);
	    	   s8.getTransaction().commit();
	    	   System.out.println("updated in both tables");
	    	   }
	    	   catch(Exception e5)
	    	   {
                  s7.close();
	    		   s8.close();
	    		  System.out.println(e5);
	    	   }
	    	   
	       }
		   break;
	case 4:SessionFactory s51=new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();
	       Session s6=s51.openSession();
	       try
	       {
	    	s6.beginTransaction();
	    	Query q=s6.createQuery("select e4 from Employee e4");
	    	List<Employee> s1=q.list();
	    	System.out.println("size"+s1.size());
            for(Employee e8:s1)
            {
            
          System.out.print(e8.getEmpcode()+" "+e8.getEmpname()+" "+e8.getEmpdesignation()+" "+e8.getEmpage()+" "+e8.getEmpbasic_pay());
          System.out.print(" "+new SimpleDateFormat("dd/MM/yyyy").format(e8.getEmpdob())+" "+new SimpleDateFormat("dd/MM/yyyy").format(e8.getEmpjod()));
           System.out.println();
            }
	    	s6.getTransaction().commit();
	       }
	       catch(Exception e)
	       {
	    	   
	       }
		   break;
	case 5:System.out.println("enter employee id");
	       long e3=s.nextLong();
	       SessionFactory s2=new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();
    	   Session s3=s2.openSession();
    	   try
    	   {
    		   s3.beginTransaction();
    		   Employee e5=(Employee)s3.get(Employee.class,e3);
    		   System.out.println("                        "+"ABC Limited");
    		   Date p1=new Date();
    		   SimpleDateFormat s9=new SimpleDateFormat("dd/MM/yyyy");
    		   System.out.println("                                                               "+s9.format(p1));
    		   System.out.println("Employee code:"+"    "+e5.getEmpcode());
    		   System.out.println("Employee name"+"  "+e5.getEmpname());
    		   System.out.println("Employee Designation"+" "+e5.getEmpdesignation());
    		   System.out.println("EMPDOB  :"+new SimpleDateFormat("dd/MM/yyyy").format(e5.getEmpdob()));
    		   System.out.println("EMPJOD  :"+new SimpleDateFormat("dd/MM/yyyy").format(e5.getEmpjod()));
    		   System.out.println();
    		   System.out.println("BASIC:"+e5.getEmpbasic_pay());
    		  float hra=e5.getEmpbasic_pay()*0.1f;
    		  float da=e5.getEmpbasic_pay()*0.2f;
    		  System.out.println("HRA:"+hra);
    		  System.out.println("DA:"+da);
    		 float f=e5.getEmpbasic_pay()+hra+da;
    		  System.out.println("salary="+""+f);
    		   s3.getTransaction().commit();
    	   }
    	   catch(Exception e)
    	   {
    		   s2.close();
    		   s3.close();
    		   System.out.println(e);
    	   }
    	   break;
	       
	       
	}
}
}
