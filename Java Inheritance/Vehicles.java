/*
->Write a Java program to create a vehicle class hierarchy. The base class should be Vehicle, with subclasses Truck, Car and Motorcycle. Each subclass should have properties such as make, model, year, and fuel type. Implement methods for calculating fuel efficiency, distance traveled, and maximum speed.

->Write a Java program where the "Truck" subclass calculates load capacity based on cargo weight.

->Write a Java program where the "Car" subclass implements a method to estimate travel time for long trips.

->Write a Java program where the "Motorcycle" subclass includes a method to check tire pressure before a ride.

->Write a Java program where the "Vehicle" class introduces a method for maintenance scheduling.
*/
import java.util.*;

public class Main{

    public static void main(String args[]){

        Car car1 = new Car("Honda", "Civic", 2023, "Petrol");
        Car car2 = new Car(car1);
    
        Truck truck1 = new Truck("Ford", "F-150", 2024, "Diesel");
        Motorcycle bike1 = new Motorcycle("Yamaha", "R1", 2022, "Petrol");
    
        // Uses your overridden toString() automatically!
        System.out.println("Original Car: " + car1);
        System.out.println("Copied Car:   " + car2);
        System.out.println("Truck:        " + truck1);
        System.out.println("Motorcycle:   " + bike1);
    
        // Tests equals() and hashCode()
        System.out.println("\ncar1.equals(car2)? " + car1.equals(car2));       // true
        System.out.println("car1 == car2?      " + (car1 == car2));            // false
        System.out.println("Same hashCode?     " + (car1.hashCode() == car2.hashCode())); // true
        
    }
}

abstract class Vehicle{

    private String make;
    private String model;
    private int year;
    private String fuelType;
    
    public Vehicle(String make, String model, int year, String fuelType){

        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelType = fuelType;
        
    }

    public Vehicle(Vehicle other){

        this(other.make, other.model, other.year, other.fuelType);
        
    }

    public String getMake(){

        return this.make;
    }

    public String getModel(){

        return this.model;
    }

    public int getYear(){

        return this.year;
    }

    public String getFuelType(){

        return this.fuelType;
    }

    public abstract double calculateFuelEfficiency(double distance, double fuelConsumed);

    public abstract double getMaximumSpeed();
    
    public double distanceTravelled(double speed, double time){

        double distance = speed * time;
        
        return distance;
    }

    @Override
    public boolean equals(Object obj){

        if(this == obj){

            return true;
        }

        if(obj == null || obj.getClass() != this.getClass()){

            return false;
        }

        Vehicle other = (Vehicle) obj;
        if(this.year == other.year && this.make.equals(other.make) && this.model.equals(other.model) && this.fuelType.equals(other.fuelType)){

            return true;
        
        }else{

            return false;
        }
        
    }

    @Override
    public int hashCode(){

        int uniqueNumber = Objects.hash(this.make, this.model, this.year, this.fuelType);
        return uniqueNumber;
        
    }

    @Override
    public String toString(){

        String representation = "Make: %s, Model: %s, Year: %d, fuelType: %s".formatted(this.make, this.model, this.year, this.fuelType);

        return representation;
    }
}

class Truck extends Vehicle{

     public Truck(String make, String model, int year, String fuelType){

        //Constructor Chaining 
        super(make, model, year, fuelType);
         
     }   

    public Truck(Truck other){

        // Calls Vehicle(Vehicle other) safely
        super(other); 
    }

    @Override
    public double calculateFuelEfficiency(double distance, double fuelConsumed){

        double fuelEfficiency =  (distance / fuelConsumed) * 0.9; // Lower efficiency due to heavy load
        
        return fuelEfficiency;
        
    }

    @Override
    public double getMaximumSpeed(){

        return 210.0;
    }
}

class Car extends Vehicle{

    public Car(String make, String model, int year, String fuelType){

        //Constructor Chaining
        super(make, model, year, fuelType);
        
    }

    public Car(Car other){

        super(other);
    }

    @Override
    public double calculateFuelEfficiency(double distance, double fuelConsumed){

        double fuelEfficiency = distance / fuelConsumed;
        
        return fuelEfficiency;
        
    }

    @Override
    public double getMaximumSpeed(){

        return 250.0;
    }
}

class Motorcycle extends Vehicle{

    public Motorcycle(String make, String model, int year, String fuelType){

        //Constructor Chaining
        super(make, model, year, fuelType);
        
    }

    public Motorcycle(Motorcycle other){

        super(other);
    }

    @Override
    public double calculateFuelEfficiency(double distance, double fuelConsumed) {
        return (distance / fuelConsumed) * 1.15; // Higher efficiency due to lighter weight
    }

    @Override
    public double getMaximumSpeed(){

        return 300.0;
    }
    
}
