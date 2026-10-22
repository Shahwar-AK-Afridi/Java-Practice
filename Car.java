/*
7. Constructor with Default Values

Write a Java program to create a class called Car with instance variables make, model, and year. Implement a parameterized constructor that initializes these variables and assigns default values if not provided. Print the values of the variables.
*/
public class Car {

    private String make;
    private String model;
    private int year;

    public Car(){

        this("","",0);
    }

    public Car(String make, String model ,int year){

        if(make == null || make.isEmpty()){

            this.make = "Unknown";
        
        }else{

            this.make = make;
        }
        if(model == null || model.isEmpty()){

            this.model = "Unknown";
        
        }else{

            this.model = model;
        }
        if(year <= 0){

            this.year = 2000;
        
        }else{

            this.year = year;
        }
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
    
    public static void main(String[] args) {
        
        Car myCar = new Car();
        System.out.println(myCar.getMake());
        System.out.println(myCar.getModel());
        System.out.println(myCar.getYear());
    }
}
