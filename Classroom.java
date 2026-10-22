/*
9. Constructor with Array Initialization

Write a Java program to create a class called Classroom with instance variables className and students (an array of strings). Implement a parameterized constructor that initializes these variables. Print the values of the variables.
*/
public class Classroom{

    private String className;
    private String[] students;

    public Classroom(String className, String[] students){

        this.className = className;
        this.students =  students;
        
    }

    public String getClassName(){

        return this.className;
    }

    public void getStudents(){

        for(String student :this.students){

            System.out.println(student);
        }
    }
    
    public static void main(String[] args) {

       String myclass = "Software";
       String[] students = {"John","Smith","Steve"};
        
       Classroom myClassRoom = new Classroom(myclass,students);
       System.out.println(myClassRoom.getClassName());
       myClassRoom.getStudents();
           
    }
}
