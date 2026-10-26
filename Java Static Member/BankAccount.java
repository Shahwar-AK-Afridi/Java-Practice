/*
8. Static Members in Different Contexts

Write a Java program to create a class called "BankAccount" with instance variables 'accountNumber' and balance, and static variables 'bankName' and 'interestRate'. Provide static methods to get and set the static variables. Create several 'BankAccount' objects and print their details along with the static variables.
*/

public class BankAccount{

    private int accountNumber;
    private int balance;
    private static String bankName;
    private static int interestRate;

    static{

        bankName = "Alfalah";
        interestRate = 3;
        
    }

    public BankAccount(int accountNumber, int balance){

        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public static String getBankName(){

        return BankAccount.bankName;
    }

    public static int getInterestRate(){

        return BankAccount.interestRate;
    }

    public static void setBankName(String newBankName){

        BankAccount.bankName = newBankName;
    }

    public static void setInterestRate(int newInterestRate){

        BankAccount.interestRate = newInterestRate;
    }

    public void printDetails(){


        System.out.println("Account Number: "+this.accountNumber);
        System.out.println("Account Balance: "+this.balance);
        
    }

    public static void main(String args[]){

        

        System.out.println("Initial Bank Name: "+BankAccount.getBankName());
        BankAccount.setBankName("Bank Alfalah");
        System.out.println("New Bank Name: "+BankAccount.getBankName());

        BankAccount a1 = new BankAccount(42201,4000);
        BankAccount a2 = new BankAccount(32201,3000);
        BankAccount a3 = new BankAccount(52201,5000);
        BankAccount a4 = new BankAccount(62201,6000);
        
    }
    
}
