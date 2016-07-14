package edu.globant.design.srp.after;

public class HtmlAccountReport implements AccountReport {

    public String generate(final Account account) {
        return "<html><body>The account balance is: <b>" + account.getBalance() + "</b></body></html>";
    }

}
