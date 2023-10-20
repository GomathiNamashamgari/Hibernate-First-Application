package com.anpfrnds;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anpfrnds.model.Employee;
import com.anpfrnds.model.Address;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        Session session=factory.openSession();
        try 
        {
        	Employee e1=new Employee();
        	e1.setName("Ram");
        	e1.setSalary(12000);
        	
        	Address a1=new Address();
        	a1.setStreet("ameerpet");
        	
        	e1.setAddress(a1);
        	a1.setEmployee(e1);
        	
        	session.beginTransaction();
        	session.save(e1);
        	session.getTransaction().commit();
        	
    Employee r1=session.get(Employee.class, e1.getId());
    Address r2=r1.getAddress();
    System.out.println("Employee: "+r1.getName());
    System.out.println("Address: "+r2.getStreet());
    
        	
        	/*
        	Employee e2=new Employee();
        	e2.setName("Arjun");
        	e2.setSalary(15000);
        	session.beginTransaction();
        	session.save(e2);
        	session.getTransaction().commit();
        	*/

        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        finally 
        {
        	session.close();
        	factory.close();
        }
    }
}
