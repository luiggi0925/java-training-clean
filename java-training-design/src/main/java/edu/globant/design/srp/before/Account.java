package edu.globant.design.srp.before;

import org.apache.commons.lang3.Validate;

public class Account {

    private int balance;

    public Account(final int initialBalance) {
        Validate.isTrue(initialBalance >= 0, "The initial balance should be no negative.");
        this.balance = initialBalance;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(final int amount) {
        Validate.isTrue(amount > 0, "The amount to deposit should be positive.");
        this.balance += amount;
    }

    public void withdraw(final int amount) {
        Validate.isTrue(amount > 0, "The amount to withdraw should be positive.");
        Validate.isTrue(amount <= balance, "The amount to withdraw should not be greater than the current balance.");
        this.balance -= amount;
    }

    public String plainReport() {
        return "The account balance is: " + balance;
    }

    public String htmlReport() {
        return "<html><body>The account balance is: <b>" + balance + "</b></body></html>";
    }

}
