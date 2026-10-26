/*
Write a Java program to create a class called Animal with a method called makeSound(). Create a subclass called Cat that overrides the makeSound() method to bark.

->Write a Java program where the "Cat" subclass adds a new method called scratch() that prints a message when called.

->Write a Java program where the "Animal" class includes an attribute for habitat, and subclasses define specific habitats.

->Write a Java program where the "Animal" class has a lifespan attribute, and subclasses override it based on species.
*/

public class Main{

    public static void main(String args[]){

        Animal animal = new Animal("Jungle","20");
        animal.makeSound();
        System.out.println(animal.getHabitat());
        System.out.println(animal.getLifespan());

        Cat cat = new Cat();
        cat.makeSound();
        System.out.println(cat.getHabitat());
        System.out.println(cat.getLifespan());
        
    }
}

class Animal{

    private String habitat;
    private String lifespan;
    
    public Animal(String habitat, String lifespan){

        this.habitat = habitat;
        this.lifespan = lifespan;
    }

    public String getHabitat(){

        return this.habitat;
    }

    public void setHabitat(String newhabitat){

        this.habitat = newhabitat;
    }

    public String getLifespan(){

        return this.lifespan;
    }

    public void setLifespan(String newLifeSpan){

        this.lifespan = newLifeSpan;
        
    }
    
    public void makeSound(){

        System.out.println("Ohh yeah");
    }
}

class Cat extends Animal{

    public Cat(){

        super("Domestic","15 Years");
        
    }

    public void makeSound(){

        System.out.println("Meow");
    }

    public void scratch(){

        System.out.println("Cat is scratching");
    }
}
