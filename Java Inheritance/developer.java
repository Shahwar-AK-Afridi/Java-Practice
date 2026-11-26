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

        System.out.println(m1.generatePerformanceReport());
        m1.setPerformancePoints(5);
        System.out.println(m1.generatePerformanceReport());

        System.out.println(p1.manageProject("Main"));
        System.out.println(p1.manageProject("Car"));
        System.out.println(p1.manageProject("House"));
        System.out.println(p1.manageProject("CLOCK"));
        System.out.println(p1.manageProject("Bike"));
        System.out.println(p1.manageProject("Yoyo"));
        
    }
}

abstract class Employee{

    private String name;
    private String address;
    private String jobTitle;
    private double salary;
    private double performancePoints;
    private int activeProjects;
    
    public Employee(String name, String address, String jobTitle, double salary){

        this.name = name;
        this.address = address;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.performancePoints = 0.0;
        this.activeProjects = 0;
    }

    public abstract double calculateBonus();
    public abstract String manageProject(String project);
    
    public Employee(Employee other){

        this(other.name, other.address, other.jobTitle, other.salary);
        this.performancePoints = other.performancePoints;
        this.activeProjects = other.activeProjects;
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

    public double getPerformancePoints(){

        return this.performancePoints;
    }

    public void setPerformancePoints(double score){

        if(score < 0 || score > 5){

            System.out.println("Invalid Score");
            return;
        
        }else{
        
            this.performancePoints = score;

        }
    }

    public int getActiveProjects(){

        return this.activeProjects;
    
    }

    public void setActiveProjects(){

        this.activeProjects += 1;    
    } 
    
    public String generatePerformanceReport(){

        if(this.performancePoints > 4.5 && this.performancePoints <= 5.0){

            return "Excellent";
            
        }else if(this.performancePoints > 3.0 && this.performancePoints <= 4.5){

            return "Good";
        
        }else if(this.performancePoints >2.5 && this.performancePoints <= 3.0){

            return "Satisfactory";
        
        }else{

            return "Bad";
        }
        
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
        
        if(this.salary == other.salary && this.performancePoints == other.performancePoints && this.activeProjects == other.activeProjects && this.name.equals(other.name) && this.address.equals(other.address) && this.jobTitle.equals(other.jobTitle)){

            return true;
            
        }else{

            return false;
        }
    }

    @Override
    public int hashCode(){

        int uniqueCode = Objects.hash(this.name,this.address,this.jobTitle,this.salary,this.performancePoints, this.activeProjects);
        return uniqueCode;
    }

    @Override
    public String toString(){

        String representation = "Name: %s, Address: %s, Job Title: %s, Salary: %.2f, Active Projects: %d".formatted(this.name, this.address, this.jobTitle, this.salary, this.activeProjects);

        return representation;
    }
}

class Manager extends Employee{

    private static final int maxProjects;

    static{
        
        maxProjects = 5;
        
    }

    public Manager(String name, String address, String jobTitle, double salary){

        super(name, address, jobTitle, salary);      
        
    }

    public Manager(Manager other){

        super(other);
    }

    @Override
    public String manageProject(String project){

        String message;
        if(this.getActiveProjects() >= Manager.maxProjects){

            message = "Cannot assign %s to Manager: %s, as maximum projects are already assigned %d/%d".formatted(project, this.getName(), this.getActiveProjects(), Manager.maxProjects);
        
        }else{
        
            setActiveProjects();
            message = "Project %s is assigned to Manager: %s, now total assigned projects are %d/%d".formatted(project, this.getName(), this.getActiveProjects(), Manager.maxProjects);
        }
        return message;
    }

    @Override
    public double calculateBonus(){

        double bonus = this.getSalary() * 0.2;
        return bonus;
        
    }
}

class Developer extends Employee{

    private static final int maxProjects;

    static{
        
        maxProjects = 3;
        
    }

    public Developer(String name, String address, String jobTitle, double salary){

        super(name, address, jobTitle, salary);
        
    }

    public Developer(Developer other){

        super(other);
    }
    
    @Override
    public String manageProject(String project){

        String message;
        if(this.getActiveProjects() >= Developer.maxProjects){

            message = "Cannot assign %s to Developer: %s, as maximum projects are already assigned %d/%d".formatted(project, this.getName(), this.getActiveProjects(), Developer.maxProjects);
        
        }else{
        
            setActiveProjects();
            message = "Project %s is assigned to Developer: %s, now total assigned projects are %d/%d".formatted(project, this.getName(), this.getActiveProjects(), Developer.maxProjects);
        }
        return message;
    }
    
    @Override
    public double calculateBonus(){

        double bonus = this.getSalary() * 0.15;
        return bonus;
        
    }
}

class Programmer extends Employee{

    private static final int maxProjects;

    static{
        
        maxProjects = 2;
        
    }
    
    public Programmer(String name, String address, String jobTitle, double salary){

        super(name, address, jobTitle, salary);
        
    }

    public Programmer(Programmer other){

        super(other);
    }

    @Override
    public String manageProject(String project){

        String message;
        if(this.getActiveProjects() >= Programmer.maxProjects){

            message = "Cannot assign %s to Programmer: %s, as maximum projects are already assigned %d/%d".formatted(project, this.getName(), this.getActiveProjects(), Programmer.maxProjects);
        
        }else{
        
            setActiveProjects();
            message = "Project %s is assigned to Programmer: %s, now total assigned projects are %d/%d".formatted(project, this.getName(), this.getActiveProjects(), Programmer.maxProjects);
        }
        return message;
    }
    
    @Override
    public double calculateBonus(){

        double bonus = this.getSalary() * 0.1;
        return bonus;
        
    }
}
