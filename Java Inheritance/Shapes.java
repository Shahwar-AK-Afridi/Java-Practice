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

    @Override
    public void rotate(double angle) {
    
        super.setRotateAngle(super.getRotateAngle() + angle);
        System.out.println("Circle rotated by " + angle + " degrees (Total: " + super.getRotateAngle() + "°). Appearance stays the same due to symmetry.");
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

    public double getY(){

        return this.y;
    }
}
