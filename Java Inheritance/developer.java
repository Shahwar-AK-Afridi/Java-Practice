/*
Write a Java program that creates a class hierarchy for employees of a company. The base class should be Employee, with subclasses Manager, Developer, and Programmer. Each subclass should have properties such as name, address, salary, and job title. Implement methods for calculating bonuses, generating performance reports, and managing projects.+
*/
import java.util.*;
public class Main{

    public static void main(String args[]){

        Employee e1 = new Employee("John", "ABC", "Sales",50000.45);

        Employee e2 = new Employee(e1);

        System.out.println(e2==e1);
        System.out.println(e2.equals(e1));

        Manager m1 = new Manager("Smith", "bca", "Salas Manager",502452);

        Manager m2 = new Manager(m1);

        System.out.println(m2==m1);
        System.out.println(m2.equals(m1));

        System.out.println(m2);
        
    }
}

class Employee{

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

    public Employee(Employee other){

        this(other.name, other.address, other.jobTitle, other.salary);
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
}

class Developer extends Employee{

    public Developer(String name, String address, String jobTitle, double salary){

        super(name, address, jobTitle, salary);
        
    }

    public Developer(Developer other){

        super(other);
    }
    
}

class Programmer extends Employee{

    public Programmer(String name, String address, String jobTitle, double salary){

        super(name, address, jobTitle, salary);
        
    }

    public Programmer(Programmer other){

        super(other);
    }
}
