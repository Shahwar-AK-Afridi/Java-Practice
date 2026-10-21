/*
2. Parameterized Constructor

Write a Java program to create a class called Dog with instance variables name and color. Implement a parameterized constructor that takes name and color as parameters and initializes the instance variables. Print the values of the variables.
*/

public class Dog{

    private String name;
    private String color;

    public Dog(){

        this.name = "Unknown";
        this.color = "Unknown";
    }
    
    public Dog(String name, String color){

        this.name = name;
        this.color = color;
        
    }

    public String getName(){

        return this.name;
    }

    public String getColor(){

        return this.color;
    }
    
    public static void main(String[] args) {

        Dog myDog = new Dog("Tom","Grey");
        
        System.out.println("Name: "+myDog.getName());
        System.out.println("Color: "+myDog.getColor());

        Dog myDog2 = new Dog();
        
        System.out.println("Name: "+myDog2.getName());
        System.out.println("Color: "+myDog2.getColor());    
        
    }

    
}

