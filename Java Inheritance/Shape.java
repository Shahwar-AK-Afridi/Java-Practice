/*
Write a Java program to create a class called Shape with a method called getArea(). Create a subclass called Rectangle that overrides the getArea() method to calculate the area of a rectangle.

->Write a Java program where the "Rectangle" subclass checks if the shape is a square.

->Write a Java program where the "Shape" class has an attribute for color, and subclasses modify the color dynamically.

->Write a Java program where the "Rectangle" subclass adds a method to resize the shape.

->Write a Java program where the "Shape" class includes a method to determine if the shape is 2D or 3D.
*/
public class Main{

    public static void main(String args[]){

        Rectangle r1 = new Rectangle(10,10,"3D");
        System.out.println(r1.getArea());
        System.out.println(r1.checkSquare());
        System.out.println("Is Shape 3D: "+r1.is3D());

        Rectangle s1 = new Rectangle(10,10,"2D");
        s1.changeColor();
        System.out.println(s1.getColor());
        System.out.println("Is Shape 3D: "+s1.is3D());

        Rectangle s2 = new Rectangle(5,10,"3D");
        s2.changeColor();
        System.out.println(s2.getColor());

        Rectangle r3 = new Rectangle(2,5,"3D");
        System.out.println(r3.getHeight());
        System.out.println(r3.getWidth());
        r3.resizeShape(100,200);
        System.out.println(r3.getHeight());
        System.out.println(r3.getWidth());

        Box b1 = new Box(5,5,2);
        System.out.println("Volume: "+b1.calculateVolume());
    }
    
}
class Shape{

    private double height;
    private double width;
    private String color;
    private String dimensionType;
    
    public Shape(double height, double width){

        this.height = height;
        this.width = width;
        this.color = "Default";
    }

    public Shape(double height, double width, String dimensionType){

        this.height = height;
        this.width = width;
        this.dimensionType = dimensionType;
        this.color = "Default";
        
    }

    public boolean is3D(){

        if(this.dimensionType.equals("3D")){

            return true;
            
        }else{

            return false;
        }
                
    }

    public double getArea(){


       return 0.0; 
    }

    public void resizeShape(double newHeight, double newWidth){

        
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

    public String getColor(){

        return this.color;    
    }

    public void setColor(String newColor){

        this.color = newColor;
    }
}

class Rectangle extends Shape{

    public Rectangle(double height, double width, String dimensionType){

        super(height,width,dimensionType);
        
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

    public void changeColor(){

        if(this.checkSquare()){

            this.setColor("Pink");
        
        }else{

            this.setColor("Blue");
            
        }
    }

    @Override
    public void resizeShape(double newHeight, double newWidth){

        this.setHeight(newHeight);
        this.setWidth(newWidth);
        
    }
}

class Box extends Shape{

    private double depth;

    public Box(double height, double width, double depth){

        super(height,width,"3D");
        this.depth = depth;
    }

    public double calculateVolume(){

        double volume = this.getHeight() * this.getWidth() * this.depth;
        
        return volume;
    }

    
}
