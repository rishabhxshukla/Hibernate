package com.operations;
import java.util.*;
import com.Employee;
import org.hibernate.*;
import org.hibernate.cfg.*;

class Update
{
    public static void main(String[] args)
    {
        try
        {
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
            System.out.print("Enter employee id : ");
            int id = Integer.parseInt(sc.next());
            System.out.print("Enter new salary : ");
            int salary = Integer.parseInt(sc.next());
            System.out.println();

            //Fetch the employee object using the ID
            Employee e = session.get(Employee.class, id);

            //Update the salary
            e.setSalary(salary);

            //Update record
            session.save(e);
            transaction.commit();

            System.out.println("\nData successfully updated!");
        }
        catch (Exception e)
        {
            System.out.println("ERROR : " + e.getMessage());
            System.out.println("STACK TRACE : ");
            e.printStackTrace();
        }
    }
}