/*
7. Static Block for Complex Initialization

Write a Java program to create a class called "ComplexInitializer" with a static block that initializes multiple static variables (x, y, z) using complex logic. Print the values of these variables in the main method.
*/

public class ComplexInitializer{

    private static int x;
    private static int y;
    private static int z;

    static{
        
        x = 5*10;
        
        if (x > 100) {
            y = x * 2;
        } else {
            y = x / 2;
        }
        
        z = 0;
        for (int i = 1; i <= 5; i++) {
            z += i; // Sums 1 + 2 + 3 + 4 + 5
        }
        
        System.out.println("--- Initialization Complete ---\n"); 
    }
    public ComplexInitializer(){

        
        
    }

    public static void main(String[] args){

        ComplexInitializer ci = new ComplexInitializer();
        System.out.println("Value of x: "+ComplexInitializer.x);
        System.out.println("Value of y: "+ComplexInitializer.y);
        System.out.println("Value of z: "+ComplexInitializer.z);
    }
}    
    
    
}
