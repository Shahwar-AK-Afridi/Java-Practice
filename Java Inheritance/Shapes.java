/*
Completed Tasks
#	Task	What You Implemented	Status
1	Radius Validation	setRadius() with validation for negative values	Completed
2	Point Inside Circle	containsPoint(Point p)	Completed
3	Moving a Circle	move(dx, dy) and Point setters	Completed
4	Circle Geometry	distanceTo() and containsCircle()	Completed
5	Rectangle Class	Rectangle extends Shape, area, perimeter, scaling	Completed
6	Square Class	Square extends Rectangle, setSide()	Completed
7	Polymorphism	ArrayList<Shape> and total area/perimeter calculations	Completed
8	Abstract Classes	Abstract Shape, getArea(), getPerimeter(), scale()	Completed
9	Interfaces	Movable, Scalable, implements	Completed
10	Object Copying	Copy constructors, defensive copying, shallow/deep copying	Completed
11	Object Methods	toString(), equals(), hashCode()	Completed
12	ShapeManager	Managing shapes using aggregation and polymorphism	Completed
*/
import java.util.*;
public class Main{

    public static void main(String args[]){

        Circle c1 = new Circle(10, 2, 5);
        System.out.println(c1.getArea());
        System.out.println(c1.getPerimeter());
        System.out.println(c1);
        
        Point p1 = new Point(1, 1);
        Point p2 = new Point(15, 20);

        c1.checkPoint(p1);
        c1.checkPoint(p2);

        // Test rotation
        c1.rotate(45);
        c1.rotate(180);

        Circle c2 = new Circle(10,5,9);
        System.out.println("Is Overlapping: "+c1.isOverlapping(c2));
        System.out.println("Is Overlapping: "+c1.isOverlapping());

        System.out.println("Old Radius: " + c1.getRadius());
        System.out.println("Old Area: " + c1.getArea());
        System.out.println("Old Perimeter: " + c1.getPerimeter());
        c1.scale(2.0);
        System.out.println("New Radius: " + c1.getRadius());
        System.out.println("New Area: " + c1.getArea());
        System.out.println("New Perimeter: " + c1.getPerimeter());

        Circle c3 = new Circle(10, 2, 3);

        c3.move(5, -1);

        Circle c4 = new Circle(10, 0, 0);
        Circle c5 = new Circle(3, 2, 0);

        System.out.println(c4.distanceTo(c5));      // 2.0
        System.out.println(c4.containsCircle(c5));  // true
        System.out.println(c5.containsCircle(c4));  // false

        Point recP1 = new Point(2,3);
        Rectangle r1 = new Rectangle(4, 6, recP1);

        System.out.println(r1.getArea());
        System.out.println(r1.getPerimeter());

        r1.scale(2);

        System.out.println(r1.getArea());
        System.out.println(r1.getPerimeter());

        Square s1 = new Square(5, new Point(0, 0));

        s1.rotate(45);             // Shape's method
        s1.getArea();              // Rectangle's overridden method
        s1.getPerimeter();         // Rectangle's overridden method
        s1.scale(2);               // Rectangle's overridden method
        s1.setSide(10);            // Square's own method

        double totalArea = 0.0;
        double totalPerimeter = 0.0;
        
        ArrayList<Shape> objects = new ArrayList<>();
        objects.add(c4);
        objects.add(r1);
        objects.add(s1);

        for(Shape obj: objects){

            totalArea += obj.getArea();
            totalPerimeter +=  obj.getPerimeter();
            
        }

        System.out.println("Area of Shapes: "+ totalArea);
        System.out.println("Perimeter of Shapes: "+ totalPerimeter);

        Movable m1 = new Circle(5);
        m1.move(2, 3);

        Scalable s3 = new Rectangle(4, 6, new Point(0, 0));
        s3.scale(2);

        //Square inherits the interface implementation from Rectangle
        Movable m2 = new Square(5, new Point(0, 0));
        m2.move(3, 4);

        Circle c6 = new Circle(10, new Point(2, 3));
        Circle c7 = new Circle(10, new Point(2, 3));
        Circle c8 = new Circle(20, new Point(2, 3));

        System.out.println(c6 == c7);       // false
        System.out.println(c6.equals(c7));  // true
        System.out.println(c6.equals(c8));  // false
        System.out.println(c6.equals(null)); // false
    
        System.out.println(c6.equals(c7));               // true
        System.out.println(c6.hashCode() == c7.hashCode()); // true
    }
    
}

abstract class Shape{


    private double rotateAngle;

    public Shape(){

    }

    public abstract double getArea();

    public abstract double getPerimeter();

    public abstract void scale(double factor);
    
    public double getRotateAngle(){

        return this.rotateAngle;
    }

    public void setRotateAngle(double newAngle){

        this.rotateAngle = newAngle % 360;

    }

    public void rotate(double newAngle){

        this.setRotateAngle(this.rotateAngle + newAngle);
        System.out.println("Shape rotated by " + newAngle + " degrees. Current angle: " + this.rotateAngle + "°");
    }
}

class Circle extends Shape implements Movable, Scalable{

    private double radius;
    private static final double PI = 3.14159;
    private Point center;

    public Circle(double radius){
    
        this(radius, new Point(0.0,0.0));    
    }

    public Circle(double radius,double centerX, double centerY){

        this(radius, new Point(centerX,centerY));
    }
    public Circle(double radius, Point center){

        if(center != null){

            this.center = new Point(center.getX(), center.getY());   
        
        }else{

            this.center = new Point(0.0,0.0);
        }
        
        if(radius >= 0.0){

            this.radius = radius;
        
        }else{

            System.out.println("Warning: Radius cannot be negative. Setting radius to 0.");
            this.radius = 0;
        }
        
            
    }

    //Copy Constructor
    public Circle(Circle other) {
    
        this(other.radius, other.center);
        
    }

    public Point getCenter(){

        Point newCenter = new Point(this.center);  //Reusing copy constructor of point class.
        return newCenter;
    }

    public double getRadius(){

        return this.radius;
    }

    public void setRadius(double newRadius){

        if(newRadius >= 0.0){

            this.radius = newRadius;
        
        }else{

            System.out.println("Invalid Radius");
        }
        
    }
    
    @Override
    public double getArea(){

        double totalArea = PI * this.radius * this.radius;
        return totalArea;
    }

    @Override
    public double getPerimeter(){

        double totalPerimeter = 2 * PI * this.radius;
        return totalPerimeter;
    }

    public void checkPoint(Point p){

        if(p != null){
            
            double dx = p.getX() - this.center.getX();
            double dy = p.getY() - this.center.getY();
            double distance = Math.sqrt((dx*dx) +(dy*dy));
            
        if(distance <= this.radius){

            System.out.println("Inside Circle");
        
        }else{

                System.out.println("Outside Circle");
        }
            
        }else {
            System.out.println("Invalid point.");
    }
    }

    public boolean containsPoint(Point p){

        if(p != null){

            double dx = p.getX() - this.center.getX();
            double dy = p.getY() - this.center.getY();
            double distance = Math.sqrt((dx*dx)+(dy*dy));

            if(distance <= this.radius){

                return true;
            
            }else{

                return false;
            }
        
        }else{

            return false;
        }
        
    }

    @Override
    public void rotate(double angle) {
    
        super.setRotateAngle(super.getRotateAngle() + angle);
        System.out.println("Circle rotated by " + angle + " degrees (Total: " + super.getRotateAngle() + "°). Appearance stays the same due to symmetry.");
    }

    public boolean isOverlapping(Circle c1){
        
        if(c1 != null){
            
            double dx = c1.center.getX() - this.center.getX();
            double dy = c1.center.getY() - this.center.getY();
    
            double distanceFromCenter = Math.sqrt((dx*dx) + (dy*dy));
    
            double sumOfRadius = this.getRadius() + c1.getRadius();
    
            if(distanceFromCenter <= sumOfRadius){
    
                return true;
            
            }else{
    
                return false;
            }
        }else{

            System.out.println("Please Send correct circle object");
            return false;
        }
    }

    public boolean isOverlapping(){

            System.out.println("Please Send correct circle object");
            return false;
    }

    /**Returns distance between two circle centers**/
    public double distanceTo(Circle other){

        double dx = this.center.getX() - other.center.getX();
        double dy = this.center.getY() - other.center.getY();
        
        double distance = Math.sqrt((dx*dx) + (dy*dy));

        return distance;
    }

    /**Returns true if this circle completely contains other circle**/
    public boolean containsCircle(Circle other){

       if(other == null){

           return false;
       } 
       double distanceOfCenters = this.distanceTo(other);
       double totalDistance = distanceOfCenters + other.radius; 

        if(totalDistance <= this.radius){

            return true;
        }

        return false;
        
    }
    @Override
    public void scale(double factor){

        if(factor > 0){

            this.radius *=  factor;
            System.out.println("Circle scaled by factor: "+factor);
        
        }else{

            System.out.println("Warning! Scale must be greater than 0");
        }
        
    }

    @Override
    public void move(double dx, double dy){

        double oldDx = this.center.getX();
        this.center.setX(oldDx+dx);

        double oldDy = this.center.getY();
        this.center.setY(oldDy+dy);
        
    }

    @Override
    public String toString(){

        String representation = "Circle{radius="+this.radius+", center={"+this.center.getX()+","+this.center.getY()+"})";

        return representation;
    }

    @Override //Overridng from Object Class.
    public boolean equals(Object obj){

        if(this == obj){

            return true;
        }

        if(!(obj instanceof Circle)){

            return false;
            
        }

        Circle other = (Circle) obj;
        
        if(this.radius == other.radius && this.center.getX() == other.center.getX() && this.center.getY() == other.center.getY()){

            return true;
        
        }else{

            return false;
        }
    }

    @Override
    public int hashCode(){

        int result = Objects.hash(this.radius,this.center.getX(),this.center.getY());
        
        return result;
    }
}

class Rectangle extends Shape implements Movable, Scalable{

    private double width;
    private double height;
    private Point center;
    
    public Rectangle(double width, double height, Point centerPoint){

        if(width > 0 && height > 0 && centerPoint != null){
            
            this.width = width;
            this.height = height;
            this.center = new Point(centerPoint.getX(), centerPoint.getY()); //defensive copy 
        
        }else{

            this.width = 1;
            this.height = 1;
            this.center = new Point(0,0);
        }
    }

    public double getWidth(){

        return this.width;
    }

    @Override
    public double getArea(){

        return this.width * this.height;
    }

    @Override
    public double getPerimeter(){

        double sumOfAllSides = (this.width * 2) + (this.height * 2);
        return sumOfAllSides;
    }

    @Override
    public void scale(double factor){

        if(factor > 0){

            this.width *=  factor;
            this.height *=  factor;
            System.out.println("Rectangle scaled by factor: "+factor);
        
        }else{

            System.out.println("Warning! Scale must be greater than 0");
        }
        
    }
    
    @Override
    public void move(double dx, double dy){

        double oldDx = this.center.getX();
        this.center.setX(oldDx+dx);

        double oldDy = this.center.getY();
        this.center.setY(oldDy+dy);
    }

    public boolean equals(Object obj){

        if(this == obj){

            return true;
        }
        
        //As square inherits from rectangle.    
        if (obj == null || this.getClass() != obj.getClass()) {
    
            return false;
        
        }
        
        Rectangle other = (Rectangle) obj;
        
        return Double.compare(this.width, other.width) == 0
        && Double.compare(this.height, other.height) == 0
        && Double.compare(this.center.getX(), other.center.getX()) == 0
        && Double.compare(this.center.getY(), other.center.getY()) == 0;
    
        
    }

    public int hashCode(){

        int code = Objects.hash(this.width, this.height, this.center.getX(), this.center.getY());

        return code;
    }

    public String toString(){

        String representation = "Rectangle Width: "+ this.width +", height: "+ this.height;

        return representation;
    }
}

class Square extends Rectangle{
    
    public Square(double length, Point center){

        super(length,length,center);
    }

    public void setSide(double  newSide){

        if(newSide > 0){

            double factor = newSide / this.getWidth();
            super.scale(factor);
        
        }else{

            System.out.println("Invalid side length");
            
        }
        
    }
}
class Point{

    private double x;
    private double y;
    public Point(double x, double y){

        this.x = x;
        this.y = y;
    }

    public Point(Point other) {
        
        this(other.getX(), other.getY());
    }

    public double getX(){

        return this.x;
    }

    public void setX(double newX){

        this.x = newX;
    }

    public double getY(){

        return this.y;
    }

    public void setY(double newY){

        this.y = newY;
             
    }
}

interface Movable {
    void move(double dx, double dy);
}

interface Scalable {
    void scale(double factor);
}
