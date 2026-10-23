/*
6. Static Method with Static Variable

Write a Java program to create a class called "IDGenerator" with a static variable 'nextID' and a static method "generateID()" that returns the next ID and increments 'nextID'. Demonstrate the usage of generateID in the main method.
*/

public class IDGenerator{

    public static int nextID;

    public IDGenerator(){

        
    }

    public int generateID(){

        IDGenerator.nextID += 1;
        
        return IDGenerator.nextID;
    }

    public static void main(String args[]){

        IDGenerator id = new IDGenerator();
        System.out.println(id.generateID());
        System.out.println(id.generateID());
        System.out.println(id.generateID());
        System.out.println(id.generateID());
        System.out.println(id.generateID());
        
    }
}
