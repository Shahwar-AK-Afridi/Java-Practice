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
    
        Truck truck1 = new Truck("Ford", "F-150", 2024, "Diesel",100.0);
        Motorcycle bike1 = new Motorcycle("Yamaha", "R1", 2022, "Petrol");

        System.out.println(bike1.isTyreGood());
        bike1.inflateTyre();
        System.out.println(bike1.isTyreGood());
        bike1.inflateTyre();
        bike1.inflateTyre();
        bike1.inflateTyre();
        System.out.println(bike1.isTyreGood());
        
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

    public abstract String maintenanceScheduling(double distanceTravelled);
    
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

     private double maxLoadCapacity;

     public Truck(String make, String model, int year, String fuelType, double loadCapacity){

        //Constructor Chaining 
        super(make, model, year, fuelType);
        this.maxLoadCapacity  = loadCapacity ;
         
     }   

    public Truck(Truck other){

        // Calls Vehicle(Vehicle other) safely
        super(other); 
        this.maxLoadCapacity = other.maxLoadCapacity;
    }

    public double calculateRemainingCapacity(double cargoWeight){

        if(cargoWeight >= 0 && cargoWeight <= this.maxLoadCapacity){

            double remainingWeight = this.maxLoadCapacity - cargoWeight;
            return remainingWeight;
        
        }else{

            return 0.0;
        }
        
    }

    @Override
    public boolean equals(Object obj){

        if(!(super.equals(obj))){

            return false;
        
        }else{

            Truck other = (Truck) obj;
            if(this.maxLoadCapacity == other.maxLoadCapacity){

                return true;
                
            }

            return false;
        }
    }

    @Override
    public int hashCode(){

        int uniqueCode = Objects.hash(super.hashCode(),this.maxLoadCapacity);
        return uniqueCode;
    }

    @Override
    public String toString(){

        String representation = super.toString() + ", Max Load Capacity:"+ this.maxLoadCapacity;
        return representation;
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

    @Override
    public String maintenanceScheduling(double distanceTravelled){

        
        
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

    public double estimateTimeTravel(double distance, double speed){

        if(distance <= 0 || speed <= 0){

            System.out.println("Invalid distance or speed.");
            return 0.0;
        }
        double time = distance/speed;

        int restStops = (int)(distance/300);

        double totalRestTime = restStops * 0.5;

        return time + totalRestTime;
 
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

    private double tyrePressure;

    public Motorcycle(String make, String model, int year, String fuelType){

        //Constructor Chaining
        super(make, model, year, fuelType);
        this.tyrePressure = 25;
        
    }

    public Motorcycle(Motorcycle other){

        super(other);
        this.tyrePressure = other.tyrePressure;
    }

    public double getTyrePressure(){

        return this.tyrePressure;
    }

    public void inflateTyre(){

        this.tyrePressure += 5;
    }

    public String isTyreGood(){

        if(this.tyrePressure < 30){

            return "Low Tyre Pressure";
        
        }else if(this.tyrePressure >=30 && this.tyrePressure <= 40){

            return "All Good";
        
        }else{

            return "Overinflated Tyre";
        }
        
    }

    @Override
    public boolean equals(Object obj){

        if(!(super.equals(obj))){

            return false;
        
        }else{

            Motorcycle other = (Motorcycle) obj;
            if(this.tyrePressure == other.tyrePressure){

                return true;
            
            }else{

                return false;
            }
            
        }
    }

    @Override
    public int hashCode(){

        int uniqueCode = Objects.hash(super.hashCode(), this.tyrePressure);
        return uniqueCode;
        
    }

    @Override
    public String toString(){

        String representation = super.toString() + ", Tyre Pressure:" + this.tyrePressure;

        return representation;
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
