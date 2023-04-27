package com.driver;

public class CurrentAccount extends BankAccount{
    private String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception

            super(name,balance,5000);
            this.tradeLicenseId= tradeLicenseId;
                if (balance < 5000)
                    throw new Exception("Insufficient Balance");

             }

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception


            boolean valid= true;
            int n = tradeLicenseId.length();
            for (int pos = 1; pos < n; pos++) {
                char c = tradeLicenseId.charAt(pos);
                if (c == tradeLicenseId.charAt(pos - 1)) {
                    valid = false;
                    break;
                }

            if (!valid) throw new Exception("Valid License can not be generated");
        }

    }

}