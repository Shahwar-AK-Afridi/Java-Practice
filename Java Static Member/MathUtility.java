/*
2. Static Methods

Write a Java program to create a class called "MathUtility" with a static method add that takes two integers and returns their sum. Demonstrate the usage of this static method in the main method without creating an instance of "MathUtility".
*/

public class MathUtility{

    public static int add(int num1, int num2){

        int addition = num1 + num2;
        return addition;
    }
    
    public static void main(String[] args) {

        int num1 = 5;
        int num2 = 5;

        int answer = MathUtility.add(num1,num2);
        System.out.println(answer);
        
           
    }
}
