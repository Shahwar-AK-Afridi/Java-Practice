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
        System.out.println(p1.getEducationHistory());
        

        System.out.println("---");

        Employee e1 = new Employee("Saka", "Afridi");
        System.out.println("ID: " + e1.getEmployeeId());
        System.out.println("Name: " + e1.getFirstName() + " " +e1.getLastName());
        System.out.println("Email: " + e1.getEmail());
        e1.setEducationHistory("Bachelors");
        System.out.println("Education: " + e1.getEducationHistory());
        System.out.println("Email: " + e1.getEmail());
    
        Employee e2 = new Employee("Ali", "Khan", "Software Engineer");
        System.out.println("ID: " + e2.getEmployeeId());
        System.out.println("Name: " + e2.getFirstName() + " " +e2.getLastName());
        System.out.println("Email: " + e2.getEmail());

        Employee e3 = new Employee("Ahmed", "Raza", "Developer");

        e3.setLeavesTaken(12);

        System.out.println("Employee ID: " + e3.getEmployeeId());
        System.out.println("Annual Leave Balance: " + e3.annualLeaveBalance());
    }
            
}

class Person{

    private String firstName;
    private String lastName;
    private ArrayList<String> educationHistory;
    
    public Person(String firstName, String lastName){

        this.firstName = firstName;
        this.lastName = lastName;
        this.educationHistory = new ArrayList<String>();
    }

    public ArrayList<String> getEducationHistory(){

        
         return new ArrayList<String>(this.educationHistory); //defensive copy
    }

    public void setEducationHistory(String newEducation){

        if(newEducation != null && !newEducation.trim().isEmpty())
        {
            this.educationHistory.add(newEducation.trim());
        }
    }
    public String getFirstName(){

        return this.firstName;
    }

    public void setFirstName(String newName){

        if(newName != null && !newName.trim().isEmpty()){
            
            this.firstName = newName.trim();
        }
    }

    public String getLastName(){

        return this.lastName;
    }
    
    public void setLastName(String newName){

        if(newName != null && !newName.trim().isEmpty()){

            this.lastName = newName.trim();
        }
        
    }
    
}

class Employee extends Person{

    private static int idCounter;
    private String jobTitle;
    private String email;
    private int employeeId;
    private int totalAnnualLeaves;
    private int leavesTaken;

    static{

        Employee.idCounter = 0;
        
    }
    
    public Employee(String firstName, String lastName){

        super(firstName,lastName);
        Employee.idCounter += 1;
        this.employeeId = Employee.idCounter;
        this.jobTitle = "Unassigned";
        this.totalAnnualLeaves = 30;
    }

    public Employee(String firstName, String lastName, String jobTitle){

        this(firstName, lastName);
        this.jobTitle = jobTitle;
    }

    public void setLeavesTaken(int leavesDone){

        if(leavesDone >= 0 && leavesDone <= this.totalAnnualLeaves){
            
            this.leavesTaken = leavesDone; 
        }
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
    
    public int annualLeaveBalance(){

        int leavesLeft = this.totalAnnualLeaves - this.leavesTaken;
        if(leavesLeft >= 0){

            return leavesLeft;
        
        }else{

            return 0;
        }
        
    }
} 
