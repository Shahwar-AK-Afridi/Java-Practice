/*
->Write a Java program to create a class known as Person with methods called getFirstName() and getLastName(). Create a subclass called Employee that adds a new method named getEmployeeId() and overrides the getLastName() method to include the employee's job title.

->Write a Java program where the "Employee" subclass generates an email ID based on name and job title.

->Write a Java program where the "Person" class allows name changes under certain conditions.

->Write a Java program where the "Employee" subclass includes a method to calculate annual leave balance.

->Write a Java program where the "Person" class tracks education history, and subclasses extend it.
*/

import java.util.*;

public class Main{

    public static void main(String args[]){

        Person p1 = new Person("Saka", "Afridi");
        System.out.println(p1.getFirstName());
        System.out.println(p1.getLastName());

        System.out.println("---");

        Employee e1 = new Employee("Saka", "Afridi");
        System.out.println("ID: " + e1.getEmployeeId());
        System.out.println("Name: " + e1.getFirstName() + " " +e1.getLastName());
        System.out.println("Email: " + e1.getEmail());

        Employee e2 = new Employee("Ali", "Khan", "Software Engineer");
        System.out.println("ID: " + e2.getEmployeeId());
        System.out.println("Name: " + e2.getFirstName() + " " +e2.getLastName());
        System.out.println("Email: " + e2.getEmail());
    }
            
}

class Person{

    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName){

        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName(){

        return this.firstName;
    }

    public String getLastName(){

        return this.lastName;
    }
    
}

class Employee extends Person{

    private static int idCounter;
    private String jobTitle;
    private String email;
    private int employeeId;

    static{

        Employee.idCounter = 0;
        
    }
    
    public Employee(String firstName, String lastName){

        super(firstName,lastName);
        Employee.idCounter += 1;
        this.employeeId = Employee.idCounter;
        this.jobTitle = "Employed";
        
    }

    public Employee(String firstName, String lastName, String jobTitle){

        this(firstName, lastName);
        this.jobTitle = jobTitle;
    }

    public int getEmployeeId(){

        return this.employeeId;
    }
    
    @Override
    public String getLastName(){
        
        return super.getLastName()+" "+ this.jobTitle; 
    }

    public String getEmail(){

        String firstName = super.getFirstName().toLowerCase().replaceAll("\\s+","");
        String lastName = super.getLastName().toLowerCase().replaceAll("\\s+","");
        String title = this.jobTitle.toLowerCase().replaceAll("\\s","");
        
        this.email = firstName+"."+lastName+"."+title+"@gmail.com"; 
        return this.email;
    }
}
