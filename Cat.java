// Online Java Compiler (Editor)
// Write and run Java online using this editor.

public class Cat {

    private String name;
    private int age;
    
    public Cat(){

        this.name = "Unknown";
        this.age = 0;
        
    }

    public String getName(){

        return this.name;
    }

    public int getAge(){

        return this.age;
    }

    public static void main(String[] args) {

        Cat myCat = new Cat();
        System.out.println("Name: "+myCat.getName());
        System.out.println("Age: "+myCat.getAge());
    }
}
