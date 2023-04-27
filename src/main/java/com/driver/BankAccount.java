package com.driver;


public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
        this.name= name;
        this.balance= balance;
        this.minBalance= minBalance;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        boolean accGenerated= true;

                if (9 * digits < sum) {
                    accGenerated = false;
                    throw new Exception("Account Number can not be generated");
                }
                    String number= "";
                    number= createAccountNumber(digits, sum);
                    return number;

            }

    public void deposit(double amount) {
        //add amount to balance
        balance+= amount;
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
            if (balance - amount < minBalance) {
                throw new Exception("Insufficient Balance");
            } else balance -= amount;
    }
    public String createAccountNumber(int digits, int sum){

        StringBuilder number= new StringBuilder("");

        while(digits > 0){
            if(sum > 9){
                number.append("9");
                sum -= 9;
                digits--;
            }
            else{
                number.append(String.valueOf(sum));
                sum= 0;
                digits--;
            }
        }
        return String.valueOf(number);
    }

}