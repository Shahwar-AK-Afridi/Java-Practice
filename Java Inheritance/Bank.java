/*
->Write a Java program to create a class known as "BankAccount" with methods called deposit() and withdraw(). Create a subclass called SavingsAccount that overrides the withdraw() method to prevent withdrawals if the account balance falls below one hundred.

->Write a Java program where the "SavingsAccount" subclass automatically transfers excess funds to a fixed deposit.

->Write a Java program where the "BankAccount" class prevents duplicate account numbers.

->Write a Java program where the "SavingsAccount" subclass adds a method to calculate yearly interest.

->Write a Java program where the "BankAccount" class includes fraud detection for unusual transactions.

->Create a new class called CurrentAccount that extends BankAccount.

->
*/

public class Main{

    public static void main(String args[]){

        SavingsAccount acc1 = new SavingsAccount(1500);
        System.out.println(acc1.getAccountBalance());
        acc1.withdraw(500);
        System.out.println(acc1.getAccountBalance());

        SavingsAccount acc2 = new SavingsAccount(8000);
        System.out.println("Account Balance: "+acc2.getAccountBalance());
        System.out.println("Fixed Deposit Balance: "+acc2.getfixedDepositBalance());
        acc2.deposit(5000);
        System.out.println("Account Balance: "+acc2.getAccountBalance());
        System.out.println("Fixed Deposit Balance: "+acc2.getfixedDepositBalance());
        acc2.deposit(6000);
        System.out.println("Account Balance: "+acc2.getAccountBalance());
        System.out.println("Fixed Deposit Balance: "+acc2.getfixedDepositBalance());
        acc2.deposit(3000);
        System.out.println("Account Balance: "+acc2.getAccountBalance());
        System.out.println("Fixed Deposit Balance: "+acc2.getfixedDepositBalance());
        acc2.deposit(5000);
        System.out.println("Account Balance: "+acc2.getAccountBalance());
        System.out.println("Fixed Deposit Balance: "+acc2.getfixedDepositBalance());

        //Task 6 
        CurrentAccount acc = new CurrentAccount(3000);

        acc.withdraw(4000);
        acc.withdraw(2000);
        acc.withdraw(1000);
        
    }
}

class BankAccount{

    private double accountBalance;
    private int accountNumber;
    private double fixedDepositBalance;
    
    private static int customerID;

    static{

        customerID = 10000;
    }
    
    public BankAccount(double accountBalance){

        this.accountBalance = accountBalance;
        this.fixedDepositBalance = 0.0;
        
        customerID += 1;
        this.accountNumber = customerID; 
         
    }

    public void deposit(double depositAmount){

        if(depositAmount <= 0){

            System.out.println("Invalid Deposit Amount");
            return;
        }

        if(suspiciousTransaction("Deposit",depositAmount)){
            
            return;
        }
        
        //this.setAccountBalance(this.getAccountBalance() + depositAmount);
        this.accountBalance += depositAmount;
    }

    public void withdraw(double deductAmount){
        
        if(deductAmount <= 0){

            System.out.println("Invalid Withdrawal Amount");
            return;
        }

        if (deductAmount > this.accountBalance) {
            System.out.println("Insufficient Balance");
            return;
        }

        if(suspiciousTransaction("Withdraw",deductAmount)){

            return;
        }
        
        //double netAmount = this.getAccountBalance() - deductAmount;
        //this.setAccountBalance(netAmount);
        this.accountBalance -= deductAmount;
    }

    public boolean suspiciousTransaction(String transactionType, double transactionAmount){

        if(transactionType.equals("Deposit") && transactionAmount >= 20000){

            System.out.println("Suspicious Deposit Detected!");
            return true;
        
        }else if(transactionType.equals("Withdraw") && transactionAmount > this.getAccountBalance() * 0.5){

            System.out.println("Suspicious Withdraw Detected!");
            return true;
        }

        return false;
    }

    public double getAccountBalance(){


        return this.accountBalance;
    }
    
    public void setAccountBalance(double newBalance){

        this.accountBalance = newBalance;    
    }

    public int getAccountNumber(){

        return this.accountNumber;
    }

    public double getfixedDepositBalance(){

        return this.fixedDepositBalance;        
    }

    public void setfixedDepositBalance(double newfixedDepositBalance){

        this.fixedDepositBalance = newfixedDepositBalance;
    }
}

class SavingsAccount extends BankAccount{
    
    private double interestRate = 0.05;
    
    public SavingsAccount(double accountBalance){

        super(accountBalance); //Calls parent constructor to initialize saving account object.
        
        if(accountBalance > 5000){

            this.setAccountBalance(5000);
            double remainingAmount = accountBalance - 5000;             
            this.setfixedDepositBalance(remainingAmount);

        }
    }

    @Override
    public void withdraw(double deductAmount){

        if(deductAmount <= 0){

            System.out.println("Invalid Withdrawal Amount");
            return;
        }

        if(suspiciousTransaction("Withdraw",deductAmount)){

            return;
        }
        
        double netAmount = this.getAccountBalance() - deductAmount;
        
        if(netAmount < 100){

            System.out.println("Withdraw Not Possible, Low Balance");
            return;
            
        }else{

            this.setAccountBalance(netAmount);
        }
        
    }

    @Override
    public void deposit(double depositAmount){

        if(depositAmount < 0){

            System.out.println("Invalid Deposit Amount");
            return;
        }

        if(suspiciousTransaction("Deposit",depositAmount)){

            return;
        }
        
        if(this.getAccountBalance() == 5000){

            double newfixedAccountBalance = this.getfixedDepositBalance() + depositAmount;
            this.setfixedDepositBalance(newfixedAccountBalance);
            
        }else if(this.getAccountBalance() < 5000){
                                         
            double requiredAmount = 5000 - this.getAccountBalance();
                          
            if(depositAmount > requiredAmount){

                double newAccountBalance = this.getAccountBalance() + requiredAmount;
                this.setAccountBalance(newAccountBalance);

                double remainingDeposit = depositAmount - requiredAmount;

                double newfixedAccountBalance = this.getfixedDepositBalance() + remainingDeposit;
                this.setfixedDepositBalance(newfixedAccountBalance);
                
            
            }else{

                double newAccountBalance = this.getAccountBalance() + depositAmount;
                this.setAccountBalance(newAccountBalance);
                
                
            }
        }else{

                double newfixedAccountBalance = this.getfixedDepositBalance() + depositAmount;
                this.setfixedDepositBalance(newfixedAccountBalance);
        }


            
        }

    public double getInterestRate(){

        return this.interestRate;
    }

    public void setInterestRate(double newInterestRate){

        this.interestRate = newInterestRate;
    }

    public double yearlyInterest(){

        double totalInterest = (this.getAccountBalance() + this.getfixedDepositBalance())* this.getInterestRate();
        return totalInterest;
    }
    
}

class CurrentAccount extends BankAccount{

    public CurrentAccount(double accountBalance){

        super(accountBalance);
    }

    @Override         
    public void withdraw(double deductAmount){
        
        if(deductAmount <= 0){

            System.out.println("Invalid Withdrawal Amount");
            return;
        }
        
        if(deductAmount > this.getAccountBalance()){

            System.out.println("Insufficient Balance");
            return;
        
        }       
        
        if(suspiciousTransaction("Withdraw",deductAmount)){

            return;
        }

            double netAmount = this.getAccountBalance() - deductAmount;
            this.setAccountBalance(netAmount);
    }
    
}
