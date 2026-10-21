/*
4. Chaining Constructors

Write a Java program to create a class called Student with instance variables studentId, studentName, and grade. Implement a default constructor and a parameterized constructor that takes all three instance variables. Use constructor chaining to initialize the variables. Print the values of the variables
*/

public class Student{

    private int studentId;
    private String studentName;
    private String grade;

    //Default Constructor
    public Student(){

        this(0,"Unknown","Unknown");
        
    }
    
    //Parameterized Constructor
    public Student(int studentId, String studentName, String grade){

        this.studentId = studentId;
        this.studentName = studentName;
        this.grade = grade;
        
    }

    public int getStudentId(){

        return this.studentId;
    }

    public String getStudentName(){

        return this.studentName;
    }

    public String getGrade(){

        return this.grade;
    }
    
    public static void main(String[] args) {

        Student myStudent = new Student(12345,"Grey","A");
        
        System.out.println("Name: "+myStudent.getStudentId());
        System.out.println("Color: "+myStudent.getStudentName());
        System.out.println("Color: "+myStudent.getGrade());

        Student myStudent2 = new Student();
        
        System.out.println("Name: "+myStudent2.getStudentId());
        System.out.println("Color: "+myStudent2.getStudentName()); 
        System.out.println("Color: "+myStudent2.getGrade());
        
    }

    
}

