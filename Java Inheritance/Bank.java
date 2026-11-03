/*
->Write a Java program to create a class known as "BankAccount" with methods called deposit() and withdraw(). Create a subclass called SavingsAccount that overrides the withdraw() method to prevent withdrawals if the account balance falls below one hundred.

->Write a Java program where the "SavingsAccount" subclass automatically transfers excess funds to a fixed deposit.

->Write a Java program where the "BankAccount" class prevents duplicate account numbers.

->Write a Java program where the "SavingsAccount" subclass adds a method to calculate yearly interest.

->Write a Java program where the "BankAccount" class includes fraud detection for unusual transactions.
*/

public class Main{

    public static void main(String args[]){

        SavingsAccount acc1 = new SavingsAccount(1500);
        System.out.println(acc1.getAccountBalance());
        acc1.withdraw(500);
        System.out.println(acc1.getAccountBalance());
        
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

    public void deposit(){

        
    }

    public void withdraw(double deductAmount){

         double netAmount = this.getAccountBalance() - deductAmount;
         this.setAccountBalance(netAmount);
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
    
    
    
    public SavingsAccount(double accountBalance){

        super(accountBalance);
    }

    public void withdraw(double deductAmount){

        double netAmount = this.getAccountBalance() - deductAmount;
        
        if(netAmount < 100){

            System.out.println("Withdraw Not Possible, Low Balance");
            return;
            
        }else{

            this.setAccountBalance(netAmount);
        }
        
    }

    public void deposit(double depositAmount){

        double netSalary = this.getAccountBalance() + depositAmount;
    
        if(this.getAccountBalance() == 5000){

            this.setfixedDepositBalance(depositAmount);
            
        }else if(this.getAccountBalance() < 5000){
                 //3000                        //2000
            double requiredAmount = 5000 - this.getAccountBalance();
               //1000           //3000
            if(depositAmount > requiredAmount){
                       //7000                   //10000          //3000
                double availableAmount = depositAmount - requiredAmount;
                      //3000              //10000        //7000
                double remainingAmount = depositAmount - availableAmount;
                                        //2000                  //3000
                double newAccountBalance = this.getAccountBalance() + remainingAmount;
                this.setAccountBalance(newAccountBalance);
                
                double newfixedAccountBalance = this.getfixedDepositBalance() + availableAmount;
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
    
}
