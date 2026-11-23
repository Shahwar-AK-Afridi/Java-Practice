/*
Write a Java program to create a vehicle class hierarchy. The base class should be Vehicle, with subclasses Truck, Car and Motorcycle. Each subclass should have properties such as make, model, year, and fuel type. Implement methods for calculating fuel efficiency, distance traveled, and maximum speed.
*/
import java.util.*;

public class Main{

    public static void main(String args[]){

        Car car1 = new Car("Honda", "Civic", 2023, "Petrol");
        Car car2 = new Car(car1);
    
        Truck truck1 = new Truck("Ford", "F-150", 2024, "Diesel");
        Motorcycle bike1 = new Motorcycle("Yamaha", "R1", 2022, "Petrol");
    
        System.out.println("Original Car: " + car1.getMake() + " " + car1.getModel());
        System.out.println("Copied Car:   " + car2.getMake() + " " + car2.getModel());
        System.out.println("Truck:        " + truck1.getMake() + " " + truck1.getModel());
        System.out.println("Motorcycle:   " + bike1.getMake() + " " + bike1.getModel());
        
    }
}

class Vehicle{

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
}

class Car extends Vehicle{

    public Car(String make, String model, int year, String fuelType){

        //Constructor Chaining
        super(make, model, year, fuelType);
        
    }

    public Car(Car other){

        super(other);
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
}
