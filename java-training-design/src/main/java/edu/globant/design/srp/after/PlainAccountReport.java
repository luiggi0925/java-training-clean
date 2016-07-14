package edu.globant.design.srp.after;

public class PlainAccountReport implements AccountReport {

    public String generate(final Account account) {
        return "The account balance is: " + account.getBalance();
    }

}
