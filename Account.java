/*
6. Constructor with Validation

Write a Java program to create a class called Account with instance variables accountNumber and balance. Implement a parameterized constructor that initializes these variables with validation:

->accountNumber should be non-null and non-empty.
->balance should be non-negative.
->Print an error message if the validation fails.
*/

public class Account{

    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double balance){

        if(accountNumber == null || accountNumber.isEmpty()){

            System.err.println("Account Number is not correct");
            throw new IllegalArgumentException("Invalid Account Number provided.");
            
        }

        if(balance < 0){

            System.err.println("Balance is not correct");
            throw new IllegalArgumentException("Invalid Balance provided.");
            
        }
        
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber(){

        return this.accountNumber;
    }

    public double getBalance(){

        return this.balance;
    }
    
    public static void main(String[] args) {

        Account acc = new Account("111244622",150000000);
        
        System.out.println("Account: "+acc.getAccountNumber());
        System.out.println("Balance: "+acc.getBalance());

        Account acc2 = new Account("", 400.00);

        Account acc3 = new Account("1230000873", -200.00);
        
    }

    
}

