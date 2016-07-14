package edu.globant.day1.designpatterns;

import java.util.Random;

class LendService {
	public void evaluateLend(String account, double amount) {
		System.out.println(String.format("A lend of $ %.2f is being evaluated for account %s.", amount, account));
	}

	public void approveLend(String account, double amount) {
		System.out.println(String.format("A lend of $ %.2f was approved for account %s.", amount, account));
	}

	public void rejectLend(String account, double amount) {
		System.out.println(String.format("A lend of $ %.2f was rejected for account %s.", amount, account));
	}
}

class BorrowService {
	public void checkCashBorrowal(String account, double amount) {
		System.out.println(String.format("Check if account %s can borrow $ %.2f.", account, amount));
	}

	public void allowCashBorrowal(String account, double amount) {
		System.out.println(String.format("Account %s has borrowed $ %.2f.", account, amount));
	}

	public void rejectCashBorrowal(String account, double amount) {
		System.out.println(String.format("Account %s can't borrow $ %.2f. There's not enough cash.", account, amount));
	}

	public double getCurrentCash(String account) {
		Random random = new Random();
		return 30 + random.nextDouble() * 20;
	}
}

class Facade {

	private LendService lendService;
	private BorrowService borrowService;

	public Facade() {
		lendService = new LendService();
		borrowService = new BorrowService();
	}

	public void approveLend(String account, double amount) {
		lendService.evaluateLend(account, amount);
		lendService.approveLend(account, amount);
	}

	public void rejectLend(String account, double amount) {
		lendService.evaluateLend(account, amount);
		lendService.rejectLend(account, amount);
	}

	public void allowCashBorrowal(String account, double amount) {
		borrowService.checkCashBorrowal(account, amount);
		borrowService.allowCashBorrowal(account, amount);
	}

	public void rejectCashBorrowal(String account, double amount) {
		borrowService.checkCashBorrowal(account, amount);
		borrowService.rejectCashBorrowal(account, amount);
	}

	public double getCurrentCash(String account) {
		return borrowService.getCurrentCash(account);
	}
}

class WebApplication {
	Facade facade;

	public WebApplication() {
		facade = new Facade();
	}

	public void approveLend(String account, double amount) {
		facade.approveLend(account, amount);
	}

	public void rejectLend(String account, double amount) {
		facade.rejectLend(account, amount);
	}

	public void showCurrentCash(String account) {
		System.out.println(String.format("Account %s currently has $ %.2f available.", account, facade.getCurrentCash(account)));
	}
}

class BackEndApplication {
	Facade facade;

	public BackEndApplication() {
		facade = new Facade();
	}

	public void approveLend(String account, double amount) {
		facade.approveLend(account, amount);
	}

	public void rejectLend(String account, double amount) {
		facade.rejectLend(account, amount);
	}

	public void allowCashBorrowal(String account, double amount) {
		facade.allowCashBorrowal(account, amount);
	}

	public void rejectCashBorrowal(String account, double amount) {
		facade.rejectCashBorrowal(account, amount);
	}
}

public class FacadePattern {

	public static void main(String[] args) {
		System.out.println("A day of work in the web application");
		WebApplication webApplication = new WebApplication();
		webApplication.approveLend("1234567890", 150);
		webApplication.rejectLend("0987654321", 1500);
		webApplication.showCurrentCash("1234509876");

		System.out.println("------------------------------------------------------------------------");

		System.out.println("A day of work in the backend application");
		BackEndApplication backEndApplication = new BackEndApplication();
		backEndApplication.approveLend("1234567890", 150);
		backEndApplication.rejectLend("0987654321", 1500);
		backEndApplication.allowCashBorrowal("1234509876", 90);
		backEndApplication.rejectCashBorrowal("017840324", 2587);
	}
}
