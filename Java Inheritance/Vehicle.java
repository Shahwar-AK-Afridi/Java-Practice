/*
Write a Java program to create a class called Vehicle with a method called drive(). Create a subclass called Car that overrides the drive() method to print "Repairing a car".

-> Write a Java program where the "Car" subclass includes a method to check fuel level and alert when low.

-> Write a Java program where the "Vehicle" class has a method to check engine status, and subclasses override it.

-> Write a Java program where the "Car" subclass adds a feature to calculate trip cost based on fuel consumption.

-> Write a Java program where the "Vehicle" class includes an attribute for speed, and subclasses modify speed based on type.
*/

public class Main{

    public static void main(String args[]){

        Vehicle v1 = new Vehicle(20,200);
        Car c1 = new Car(10,200);
        c1.drive();
        c1.checkFuel();
        c1.checkEngineStatus();
        c1.modifySpeed("sports");
        System.out.println(c1.calculateFuelCost(500,15));
    }
    
}
class Vehicle{

    private static double fuelCostPerLitre;
    private int fuelLevel;
    private int speed;

    static{

        fuelCostPerLitre = 377.57;
        
    }
    
    public Vehicle(int fuelLevel, int speed){

        this.fuelLevel = fuelLevel;
        this.speed = speed;
        
    }

    public void drive(){

        
    }

    public void checkEngineStatus(){

        System.out.println("Vehicle is working fine");
    }
    
    public int getFuelLevel(){

        return this.fuelLevel;
    }

    public void setFuelLevel(int newFuelLevel){

        this.fuelLevel = newFuelLevel;
    }

    public static double getFuelCostPerLitre(){

        return Vehicle.fuelCostPerLitre;
    }

    public static void setFuelCostPerLitre(double newFuelCostPerLitre){

        Vehicle.fuelCostPerLitre = newFuelCostPerLitre;
    }

    public int getSpeed(){

        return this.speed;
    }

    public void setSpeed(int newSpeed){

        this.speed = newSpeed;
    }
}

class Car extends Vehicle{

    public Car(int fuelLevel, int speed){

        super(fuelLevel,speed);
        
    }

    public void drive(){

        System.out.println("Repairing a car");
    }

    @Override
    public void checkEngineStatus(){

         System.out.println("Car is working fine");   
        
    }
    public void checkFuel(){

        if(this.getFuelLevel() < 5){

            System.out.println("Low Fuel");
        
        }else{

            System.out.println("Sufficent Fuel");
        }
        
    }

    public double calculateFuelCost(double distance, double carAverage){

        double totalFuelCost = (distance/carAverage) * Vehicle.getFuelCostPerLitre();
        
        return totalFuelCost;
    }
 
    public void modifySpeed(String typeOfVehicle){

        if(typeOfVehicle.equals("sports")){

            this.setSpeed(200);
            System.out.println("200 is good "+"Speed: "+ this.getSpeed());
            
        }else if(typeOfVehicle.equals("bike")){

            this.setSpeed(70);
            System.out.println("70 is good"+"Speed: "+this.getSpeed());
        }    
    
    }
}
