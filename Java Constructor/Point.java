/*
8. Overloading Constructors with Different Data Types

Write a Java program to create a class called Point with instance variables x and y. Implement overloaded constructors:

One constructor takes int parameters.
Another constructor takes double parameters.
Print the values of the variables for each constructor.
*/
public class Point{

    private double x;
    private double y;

    public Point(int x, int y){

        this.x = x;
        this.y = y;
        
    }

    public Point(double x, double y){

        this.x = x;
        this.y = y;
        
    }

    public double getX(){

        return this.x;
    }
    
    public double getY(){

        return this.y;
    }
    
    public static void main(String[] args) {
        
        Point myPoint1 = new Point(5,5);
        System.out.println(myPoint1.getX());
        System.out.println(myPoint1.getY());

        Point myPoint2 = new Point(5.52,5.56);
        System.out.println(myPoint2.getX());
        System.out.println(myPoint2.getY());

        Point myPoint3 = new Point(8.56,5);
        System.out.println(myPoint3.getX());
        System.out.println(myPoint3.getY());


       
    }
}
