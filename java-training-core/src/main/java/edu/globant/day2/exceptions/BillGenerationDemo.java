package edu.globant.day2.exceptions;

import static java.util.Arrays.asList;

import java.util.List;

public class BillGenerationDemo {

	public static void main(String[] args) {
		generateBill("", 10);
		System.out.println("--------------------------------------");
		generateBill("     ", 10);
		System.out.println("--------------------------------------");
		generateBill(null, 10);
		System.out.println("--------------------------------------");
		generateBill("12345", 0);
		System.out.println("--------------------------------------");
		generateBill("12345", 10);
		System.out.println("--------------------------------------");
		generateBill("67890", 10);
		System.out.println("--------------------------------------");
		generateBill("lj32nl4rnqweqd", 10);
	}

	public static void generateBill(String account, double amount) {
		try {
			doGenerateBill(account, amount);
		} catch (BillGenerationException e) {
			System.out.println("Keep calm and review the exception.");
			e.printStackTrace(System.out);
		} catch (Exception e) {
			System.out.println("Do not keep calm because it's an unexpected exception.");
			e.printStackTrace(System.out);
		}
//		} catch (Exception e) {
//			throw new BillGenerationException("Unexpected.", e);
//		}
	}

	public static void doGenerateBill(String account, double amount) throws BillGenerationException {
		if (account == null || account.trim().isEmpty()) {
			throw new IllegalArgumentException("Account cannot be empty.");
		}
		if (amount < 0) {
			throw new IllegalArgumentException("Amount cannot be less than 0.");
		}
		List<String> accounts = asList("12345", "67890", "09876", "54321");
		account = account.trim();
		if (!accounts.contains(account)) {
			throw new BillGenerationException("Account doesn't exist. Cannot be billed.");
		}
		System.out.println(String.format("Bill generated successfully for account %s with amount $ %.2f.", account, amount));
	}
}
