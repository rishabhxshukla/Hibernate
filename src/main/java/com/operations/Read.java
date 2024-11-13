package com.operations;
import java.util.*;
import com.Employee;
import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.query.*;

public class Read
{
    public static void main(String[] args)
    {
        try
        {
            Employee e = new Employee();

            //Configuration
            Configuration config = new Configuration();
            config.configure("hibernate.cfg.xml");

            //Session
            SessionFactory sf = config.buildSessionFactory();
            Session session = sf.openSession();

            //Fetch all employees
            Query<Employee> query = session.createQuery("FROM Employee");

            //Read records
            List<Employee> employees = query.getResultList();
            System.out.println("\nEmployee Table :");
            for (Employee employee : employees)
            {
                System.out.println(employee);
            }
        }
        catch (Exception e)
        {
            System.out.println("ERROR : " + e.getMessage());
            System.out.println("STACK TRACE : ");
            e.printStackTrace();
        }
    }
}