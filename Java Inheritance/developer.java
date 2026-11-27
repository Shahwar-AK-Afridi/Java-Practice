/*
Write a Java program that creates a class hierarchy for employees of a company. The base class should be Employee, with subclasses Manager, Developer, and Programmer. Each subclass should have properties such as name, address, salary, and job title. Implement methods for calculating bonuses, generating performance reports, and managing projects.+

->Write a Java program where the "Manager" subclass calculates employee bonuses based on performance ratings.

->Write a Java program where the "Developer" subclass tracks completed projects and pending deadlines.

->Write a Java program where the "Programmer" subclass implements a method to log daily coding hours.

->Write a Java program where the "Employee" class introduces a mentorship program for new hires.
*/
import java.util.*;
public class Main{

    public static void main(String args[]){

        Manager m1 = new Manager("Smith", "bca", "Salas Manager",1000);
        Developer d1 = new Developer("Jasd", "ABC", "Developer",1000,"Java");
        Programmer p1 = new Programmer("Jasd", "ABC", "Programmer",1000,"Python");
        
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
    
    public Employee(Employee other){

        this(other.name, other.address, other.jobTitle, other.salary);
        this.performancePoints = other.performancePoints;
        this.activeProjects = other.activeProjects;
    }

    public abstract double calculateBonus();
    public abstract String manageProject(String project);

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

    private static final int MAX_PROJECTS;

    static{
        
        MAX_PROJECTS = 5;
        
    }

    public Manager(String name, String address, String jobTitle, double salary){

        super(name, address, jobTitle, salary);      
        
    }

    public Manager(Manager other){

        super(other);
    }

    public double calculateBonus(Employee other){

        if(other == null){

            return;
        }

        String rating = other.generatePerformanceReport();

        if(rating != null && rating.equals("Excellent")){
            
            
            
        }else if(rating != null && rating.equals("Good")){


            
        }else if(rating != null && rating.equals("Satisfactory")){


            
        }else if(rating != null && rating.equals("Bad")){


            
        }else{
            
            
            
        }
    }

    @Override
    public String manageProject(String project){

        String message;
        if(this.getActiveProjects() >= Manager.MAX_PROJECTS){

            message = "Cannot assign %s to Manager: %s, as maximum projects are already assigned %d/%d".formatted(project, this.getName(), this.getActiveProjects(), Manager.MAX_PROJECTS);
        
        }else{
        
            setActiveProjects();
            message = "Project %s is assigned to Manager: %s, now total assigned projects are %d/%d".formatted(project, this.getName(), this.getActiveProjects(), Manager.MAX_PROJECTS);
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

    private static final int MAX_PROJECTS;

    static{
        
        MAX_PROJECTS = 3;
        
    }

    private String programmingLanguage;
    
    public Developer(String name, String address, String jobTitle, double salary, String programmingLanguage){

        super(name, address, jobTitle, salary);
        this.programmingLanguage = programmingLanguage;
    }

    public Developer(Developer other){

        super(other);
        this.programmingLanguage = other.programmingLanguage;
    }
    
    @Override
    public String manageProject(String project){

        String message;
        if(this.getActiveProjects() >= Developer.MAX_PROJECTS){

            message = "Cannot assign %s to Developer: %s, as maximum projects are already assigned %d/%d".formatted(project, this.getName(), this.getActiveProjects(), Developer.MAX_PROJECTS);
        
        }else{
        
            setActiveProjects();
            message = "Project %s is assigned to Developer: %s, now total assigned projects are %d/%d".formatted(project, this.getName(), this.getActiveProjects(), Developer.MAX_PROJECTS);
        }
        return message;
    }
    
    @Override
    public double calculateBonus(){

        double bonus = this.getSalary() * 0.15;
        return bonus;
        
    }

      @Override
    public boolean equals(Object obj){

        if(!(super.equals(obj))){

            return false;
        
        }else{
            Developer other = (Developer) obj;
            if(this.programmingLanguage.equals(other.programmingLanguage)){

                return true;
            
            }else{

                return false;
            }
        }
    }

    @Override
    public int hashCode(){
            
        int uniqueCode = super.hashCode() + Objects.hash(this.programmingLanguage);
        return uniqueCode;
     
    }

    @Override
    public String toString(){

        String representation = super.toString() + ", Programming Language: %s".formatted(this.programmingLanguage);

        return representation;
    }
}

class Programmer extends Developer{

    private static final int MAX_PROJECTS;

    static{
        
        MAX_PROJECTS = 2;
        
    }
    
    public Programmer(String name, String address, String jobTitle, double salary, String programmingLanguage){

        super(name, address, jobTitle, salary, programmingLanguage);
        
    }

    public Programmer(Programmer other){

        super(other);
    }

    @Override
    public String manageProject(String project){

        String message;
        if(this.getActiveProjects() >= Programmer.MAX_PROJECTS){

            message = "Cannot assign %s to Programmer: %s, as maximum projects are already assigned %d/%d".formatted(project, this.getName(), this.getActiveProjects(), Programmer.MAX_PROJECTS);
        
        }else{
        
            setActiveProjects();
            message = "Project %s is assigned to Programmer: %s, now total assigned projects are %d/%d".formatted(project, this.getName(), this.getActiveProjects(), Programmer.MAX_PROJECTS);
        }
        return message;
    }
    
    @Override
    public double calculateBonus(){

        double bonus = this.getSalary() * 0.1;
        return bonus;
        
    }
}
