/*
->Write a Java program to create a class called Shape with methods called getPerimeter() and getArea(). Create a subclass called Circle that overrides the getPerimeter() and getArea() methods to calculate the area and perimeter of a circle.

*/

public class Main{

    public static void main(){

        
    }
    
}

class Shape{

    private double perimeter;
    private double area;
    private double length;
    private double width;
    private double height;

    public shape(double length, double width){

        this.length = length;
        this.width = width;
    }

    public shape(double length, double width, double height){

        this.shape(double length, double width);
        this.height = height;
    }

    public double getArea(){

        return this.area;  
    }

    public double getPerimeter(){

        return this.perimeter;
    }
}

class Circle{

    private double radius;
    private static final double PI = 3.14159;
    
    public Circle(double radius){

        this.radius = radius;    
    }

    public double getRadius(){

        return this.radius;
    }

    @Override
    public double getArea(){

        double totalArea = 
    }
    
}
