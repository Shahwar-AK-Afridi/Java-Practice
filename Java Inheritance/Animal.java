/*
Write a Java program to create a class called Animal with a method called makeSound(). Create a subclass called Cat that overrides the makeSound() method to bark.
*/

public class Main{

    public static void main(String args[]){

        Animal animal = new Animal();
        animal.makeSound();

        Cat cat = new Cat();
        cat.makeSound();
        
    }
}

class Animal{

    public Animal(){

        
    }

    public void makeSound(){

        System.out.println("Ohh yeah");
    }
}

class Cat extends Animal{

    public Cat(){

        
    }

    public void makeSound(){

        System.out.println("Bark");
    }
}


