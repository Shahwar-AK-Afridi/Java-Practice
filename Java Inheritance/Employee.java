/*
->Write a Java program to create a class called Employee with methods called work() and getSalary(). Create a subclass called HRManager that overrides the work() method and adds a new method called addEmployee().

->Write a Java program where the "HRManager" subclass includes a method to schedule interviews for candidates.

->Write a Java program where the "Employee" class tracks overtime hours and subclasses calculate additional pay.

->Write a Java program where the "HRManager" subclass allows employees to request salary increments.

->Write a Java program where the "Employee" class includes a method to display employee hierarchy within the company.

->An HR Manager needs to know which specific employees report to them.
*/
import java.util.List;
import java.util.ArrayList;

public class Main{

    public static void main(String args[]){

        Employee e1 = new Employee(50);
        System.out.println("E1 Salary Before Increment:"+e1.getSalary());

        HRManager hm1 = new HRManager(100000);
        System.out.println(hm1.getSalary());

        double overTimePay = hm1.calculateOverTime(9);
        System.out.println(overTimePay);

        hm1.incrementSalary(e1,10);
        System.out.println("E1 Salary After Increment:"+e1.getSalary());
        hm1.displayHierarchy();

        Employee e2 = new Employee(80);
        System.out.println("Rank: "+e2.getRank());
        e2.setRank();
        e2.setRank();
        System.out.println("Rank: "+e2.getRank());
        e2.displayHierarchy();

        hm1.addEmployee(e1);
        hm1.addEmployee(e2);
        hm1.listTeam();
    }
}

class Employee{

    private int salary;
    private double overTime;
    private double rate;
    private int rank;

    public Employee(int salary){

        this.salary = salary;
        this.overTime = 0.0;
        this.rate = 10;
        this.rank = 0;
        
        
    }

    public void work(){

        System.out.println("Working");
    }

    public int getSalary(){


        return this.salary;
    }

    public void setSalary(int newSalary){

        this.salary = newSalary;
    }
    
    public double getRate(){

        return this.rate;
    }

    public int getRank(){

        return this.rank;
    }

    public void setRank(){

        this.rank += 1;
    }

    public void displayHierarchy(){

        if(this.rank == 0){

            System.out.println("Junior");
        
        }else if(this.rank == 1){

            System.out.println("Mid-Level");    
        
        }else if(this.rank == 2){

            System.out.println("Senior");
        
        }else{

            System.out.println("Executive");
        }
    }
    public double calculateOverTime(double hours){

        
        return hours * this.rate;
    }
}

class HRManager extends Employee{

    private ArrayList<Employee> managedEmployees;

    public HRManager(int salary){

        super(salary);
        managedEmployees = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            this.setRank(); 
        }
    }

    @Override
    public void work(){

        
    }

    public void addEmployee(Employee emp){

        managedEmployees.add(emp);
    }

    public void listTeam(){

        for(Employee emp: managedEmployees){

            System.out.println(emp);
        }
    }
    public void scheduleInterview(){

            System.out.println("Scheduling Interviews");        
    }

    @Override
    public double calculateOverTime(double hours){

        double overTimePay = hours * this.getRate();
        return overTimePay;
    }

    public void incrementSalary(Employee targetEmployee, double percentage){

        if(percentage > 0 && percentage <= 50){

            double raiseAmount = targetEmployee.getSalary() * (percentage/100.0);
            int newSalary = targetEmployee.getSalary() + (int)raiseAmount;
            System.out.println("Raise Amount: "+raiseAmount);
            System.out.println("New Salary: "+newSalary);
            targetEmployee.setSalary(newSalary);

            System.out.println("HR Notice: Increment of " + percentage + "% approved.");
        
        }else{

            System.out.println("HR Notice: Increment request of " + percentage + "% rejected. Exceeds max policy limits.");
            
        }
        
    }
}
