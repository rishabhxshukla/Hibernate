package com;
import jakarta.persistence.*;

@Entity
@Table
public class Employee
{
    @Id
    @Column(name = "EmpId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Salary")
    private int salary;

    /* Getters & Setters */
    public int getEmpId() {
        return empId;
    }
    public void setEmpId(int empId) {
        this.empId = empId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /* Constructors */
    public Employee()
    {

    }
    public Employee(int empId, String name, int salary)
    {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }

    /* toString */
    @Override
    public String toString()
    {
        return "[ " +
                "EmpID: " + empId +
                ", Name: " + name +
                ", Salary: " + salary +
                " ]";
    }
}