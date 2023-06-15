package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exception.BusinessException;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter account data");
		System.out.print("Number: ");
		int number = scanner.nextInt();
		System.out.print("Holder: ");
		scanner.next();
		String holder = scanner.nextLine();
		System.out.print("Initial balance: ");
		double initialBalance = scanner.nextDouble();
		System.out.print("Withdraw limit: ");
		double withdrawLimit = scanner.nextDouble();
		
		Account account = new Account(number, holder, initialBalance, withdrawLimit);
		
		System.out.println();
		System.out.print("Enter amount for withdraw: ");
		double amount = scanner.nextDouble();
	
		try {
			account.withdraw(amount);
			System.out.printf("New balance: %.2f%n ", account.getBalance());
		}
		catch(BusinessException e) {
			System.out.println(e.getMessage());
		}
		scanner.close();

	}

}
