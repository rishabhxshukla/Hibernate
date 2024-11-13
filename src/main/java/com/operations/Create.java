package com.operations;
import com.Employee;
import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;

class Create
{
    public static void main(String[] args)
    {
        try
        {
            Employee e = new Employee();
            Scanner sc = new Scanner(System.in);

            //Configuration
            Configuration config = new Configuration();
            config.configure("hibernate.cfg.xml");

            //Session
            SessionFactory sf = config.buildSessionFactory();
            Session session = sf.openSession();

            //Transaction
            Transaction transaction = session.beginTransaction();

            //Taking user input
            System.out.print("Enter name : ");
            String name = sc.nextLine();
            System.out.print("Enter salary : ");
            int salary = Integer.parseInt(sc.next());
            System.out.println();

            //Set values
            e.setName(name);
            e.setSalary(salary);

            //Create record
            session.save(e);
            transaction.commit();

            System.out.println("\nData successfully inserted!");
        }
        catch (Exception e)
        {
            System.out.println("ERROR : " + e.getMessage());
            System.out.println("STACK TRACE : ");
            e.printStackTrace();
        }
    }
}