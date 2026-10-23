/*
3. Static Block

Write a Java program to create a class called "Initializer" with a static block that initializes a static variable 'initialValue' to 1000. Print the value of 'initialValue' before and after creating an instance of "Initializer".
*/

public class Initializer{

    public static int initialValue;

    static{

        initialValue = 1000;
        
    }

    public Initializer(){

        
    }
    public static void main(String args[]){

        System.out.println(Initializer.initialValue);  
        Initializer init = new Initializer();
        System.out.println(Initializer.initialValue);
    }
    
}
