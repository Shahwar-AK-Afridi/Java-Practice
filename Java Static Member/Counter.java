/*
1. Static Variables

Write a Java program to create a class called "Counter" with a static variable count. Implement a constructor that increments count every time an object is created. Print the value of count after creating several objects.
*/

public class Counter(){

    public static int count = 0;

    public Counter(){

        count = count + 1;

    }

    public static void main(String[] args) {

        Counter a = new Counter();
        Counter b = new Counter();
        Counter c = new Counter();
        System.out.println(Counter.count);
           
    }
}