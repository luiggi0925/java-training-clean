package edu.globant.design.srp.before;

public class Application {

    public static void main(final String[] args) {

        Account account = new Account(100);
        account.deposit(50);

        System.out.println(account.plainReport());
        System.out.println(account.htmlReport());

    }

}
