/*
5. Copy Constructor=>

Write a Java program to create a class called Rectangle with instance variables length and width. Implement a parameterized constructor and a copy constructor that initializes a new object using the values of an existing object. Print the values of the variables.
*/

public class Rectangle{

    private double length;
    private double width;

    //Parameterized Constructor
    public Rectangle(double length, double width){

        this.length = length;
        this.width = width;
        
    }
    
    public Rectangle(Rectangle otherObj){

        this.length = otherObj.length;
        this.width = otherObj.width;
        
    }

    public double getLength(){

        return this.length;
    } 

    public double getWidth(){

        return this.width;
    }
    
    public static void main(String[] args) {

        Rectangle rect = new Rectangle(10,15);
        
        System.out.println("Length: "+rect.getLength());
        System.out.println("Width: "+rect.getWidth());

        Rectangle rect2 = new Rectangle(rect);
        
        System.out.println("Copy Length: "+rect2.getLength());
        System.out.println("Copy Width: "+rect2.getWidth());
        
    }  
}
