/*
4. Static Final Variables

Write a Java program to create a class called Constants with a static final variable 'PI' initialized to 3.14159. Create a method to calculate the area of a circle given its radius, using the 'PI' constant. Demonstrate the method in the main method.
*/

public class Constants{

    public static final double PI;
    public double radius;
    
    static{

        PI = 3.14159;
    }

    public Constants(double radius){

        this.radius = radius;
        
    }

    public double calculateArea(){

        double area = (Constants.PI * (this.radius * this.radius));
        return area;
    }
    
    public static void main(String args[]){

        Constants cc = new Constants(5.0);
        System.out.println(cc.calculateArea());
        
    }
    
}
