/*
Write a Java program to create a class called Shape with a method called getArea(). Create a subclass called Rectangle that overrides the getArea() method to calculate the area of a rectangle.

->Write a Java program where the "Rectangle" subclass checks if the shape is a square.

->Write a Java program where the "Shape" class has an attribute for color, and subclasses modify the color dynamically.

->Write a Java program where the "Rectangle" subclass adds a method to resize the shape.

->Write a Java program where the "Shape" class includes a method to determine if the shape is 2D or 3D.
*/
public class Main{

    public static void main(String args[]){

        Rectangle r1 = new Rectangle(10,10);
        System.out.println(r1.getArea());
        System.out.println(r1.checkSquare());
    }
    
}
class Shape{

    private double height;
    private double width;
    private String color;
    
    public Shape(double height, double width, String color){

        this.height = height;
        this.width = width;
        this.color = color;
        
    }

    public double getArea(){


       return 0.0; 
    }

    public double getHeight(){

        return this.height;
    }

    public void setHeight(double newHeight){

        this.height = newHeight;
    }

    public double getWidth(){
    
        return this.width;    
    }

    public void setWidth(double newWidth){

        this.width = newWidth;
    }
}

class Rectangle extends Shape{

    public Rectangle(double height, double width){

        super(height,width);
        
    }

    @Override
    public double getArea(){

        double area = this.getHeight() * this.getWidth();
        return area;
    }

    public boolean checkSquare(){

        if(this.getHeight() == this.getWidth()){

            return true;
            
        }else{

            return false;
        }
        
    }
    
}
