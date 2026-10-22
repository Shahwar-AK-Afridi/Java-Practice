/*
3. Constructor Overloading

Write a Java program to create a class called "Book" with instance variables title, author, and price. Implement a default constructor and two parameterized constructors:

One constructor takes title and author as parameters.
The other constructor takes title, author, and price as parameters.
Print the values of the variables for each constructor.
*/

public class Book{

    private String title;
    private String author;
    private double price;

    public Book(){

        this.title = "Uknown";
        this.author = "Unknown";
        this.price = 0.0;
        
    }
    public Book(String title, String author){

        this.title = title;
        this.author = author;
        this.price = 0.0;
        
    }
    
    public Book(String title, String author, double price){

        this.title = title;
        this.author = author;
        this.price = price;
        
    }

    public String getTitle(){

        return this.title;
    }

    public String getAuthor(){

        return this.author;
    }

    public double getPrice(){

        return this.price;
    }
    
    public static void main(String[] args) {

        Book myBook = new Book("Atomic Habits","John");
        
        System.out.println("Title: "+myBook.getTitle());
        System.out.println("Author: "+myBook.getAuthor());
        System.out.println("Age: "+myBook.getPrice());

        Book myBook2 = new Book("Java For Everyone","Charles",25.56);

        System.out.println("Title: "+myBook2.getTitle());
        System.out.println("Author: "+myBook2.getAuthor());
        System.out.println("Age: "+myBook2.getPrice());
        
    }

    
}

