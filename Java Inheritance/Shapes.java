/*
->Write a Java program to create a class called Shape with methods called getPerimeter() and getArea(). Create a subclass called Circle that overrides the getPerimeter() and getArea() methods to calculate the area and perimeter of a circle.

->Write a Java program where the "Circle" subclass checks if a point lies inside the circle.

->Write a Java program where the "Shape" class introduces a method to rotate shapes, and subclasses implement it.

->Write a Java program where the "Circle" subclass adds a method to determine if two circles overlap.

->Write a Java program where the "Shape" class allows dynamic scaling, and subclasses override it based on dimensions.
*/

public class Main{

    public static void main(String args[]){

        Circle c1 = new Circle(10, 2, 5);
        System.out.println(c1.getArea());
        System.out.println(c1.getPerimeter());

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
    }
    
}

class Shape{

    private double perimeter;
    private double area;
    private double rotateAngle;

    public Shape(){

    }

    public double getArea(){

        return this.area;  
    }

    public double getPerimeter(){

        return this.perimeter;
    }

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

    public void scale(double factor){

        if(factor > 0.0){

            System.out.println("Shape is scaled by factor: "+ factor);
        
        }else{

            System.out.println("Warning! Scale must be greator than 0");
        }
        
    }

}

class Circle extends Shape{

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

            this.center = center;   
        
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

    public void move(double dx, double dy){

        double oldDx = this.center.getX();
        this.center.setX(oldDx+dx);

        double oldDy = this.center.getY();
        this.center.setY(oldDy+dy);
        
    }
}

class Rectangle extends Shape{

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
