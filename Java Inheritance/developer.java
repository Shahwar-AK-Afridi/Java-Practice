/*
Write a Java program that creates a class hierarchy for employees of a company. The base class should be Employee, with subclasses Manager, Developer, and Programmer. Each subclass should have properties such as name, address, salary, and job title. Implement methods for calculating bonuses, generating performance reports, and managing projects.+
*/
import java.util.*;
public class Main{

    public static void main(String args[]){

        Manager m1 = new Manager("Smith", "bca", "Salas Manager",1000);
        Developer d1 = new Developer("Jasd", "ABC", "Developer",1000);
        Programmer p1 = new Programmer("Jasd", "ABC", "Programmer",1000);
        
        System.out.println(m1.calculateBonus());
        System.out.println(d1.calculateBonus());
        System.out.println(p1.calculateBonus());
        
    }
}

abstract class Employee{

    private String name;
    private String address;
    private String jobTitle;
    private double salary;
    
    public Employee(String name, String address, String jobTitle, double salary){

        this.name = name;
        this.address = address;
        this.jobTitle = jobTitle;
        this.salary = salary;
    }

    public abstract double calculateBonus();
    
    public Employee(Employee other){

        this(other.name, other.address, other.jobTitle, other.salary);
    }

    public String getName(){

        return this.name;
    
    }

    public String getAddress(){

        return this.address;
    }

    public String getJobTitle(){

        return this.jobTitle;
    }

    public double getSalary(){

        return this.salary;
    }

    @Override
    public boolean equals(Object obj){

        if(this == obj){

            return true;
        }

        if(obj == null || this.getClass() != obj.getClass()){

            return false;
        }
        Employee other = (Employee) obj;
        
        if(this.salary == other.salary && this.name.equals(other.name) && this.address.equals(other.address) && this.jobTitle.equals(other.jobTitle)){

            return true;
            
        }else{

            return false;
        }
    }

    @Override
    public int hashCode(){

        int uniqueCode = Objects.hash(this.name,this.address,this.jobTitle,this.salary);
        return uniqueCode;
    }

    @Override
    public String toString(){

        String representation = "Name: %s, Address: %s, Job Title: %s, Salary: %.2f".formatted(this.name, this.address, this.jobTitle, this.salary);

        return representation;
    }
}

class Manager extends Employee{

    public Manager(String name, String address, String jobTitle, double salary){

        super(name, address, jobTitle, salary);        
    }

    public Manager(Manager other){

        super(other);
    }

    @Override
    public double calculateBonus(){

        double bonus = this.getSalary() * 0.2;
        return bonus;
        
    }
}

class Developer extends Employee{

    public Developer(String name, String address, String jobTitle, double salary){

        super(name, address, jobTitle, salary);
        
    }

    public Developer(Developer other){

        super(other);
    }
    
    @Override
    public double calculateBonus(){

        double bonus = this.getSalary() * 0.15;
        return bonus;
        
    }
}

class Programmer extends Employee{

    public Programmer(String name, String address, String jobTitle, double salary){

        super(name, address, jobTitle, salary);
        
    }

    public Programmer(Programmer other){

        super(other);
    }

    
    @Override
    public double calculateBonus(){

        double bonus = this.getSalary() * 0.1;
        return bonus;
        
    }
}
