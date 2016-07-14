package edu.globant.design.srp.after;

public class Application {

    public static void main(final String[] args) {

        Account account = new Account(100);
        account.deposit(50);

        AccountReport plainAccountReport = new PlainAccountReport();
        AccountReport htmlAccountReport = new HtmlAccountReport();

        System.out.println(plainAccountReport.generate(account));
        System.out.println(htmlAccountReport.generate(account));

    }

}
