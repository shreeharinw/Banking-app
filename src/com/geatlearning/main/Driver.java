package com.geatlearning.main;

import java.util.Scanner;

import com.greatlearning.interfaces.InternetBanking;
import com.greatlearning.model.Customer;
import com.greatlearning.services.IndianBank;

public class Driver {

//	arr [10,20,30]
	//arr[0]
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Banking app");
//		System.out.println(args[0]);
		Customer customer1 = new Customer("1343", "myPassword");
		InternetBanking internetBanking = new IndianBank();
		displayWelcomeMessage();
		String bankAccountNo = getUserBankAccountNo();
		String password = getPassword();
		if(customer1.getBankAccountNo().equals(bankAccountNo) && 
				customer1.getPassword().equals(password)) {
			System.out.println("Successfully loggedin ");
			int choice=0;
			do {
				displayMenu();
				choice = scanner.nextInt();
				switch(choice) {
					case 1: System.out.println("Deposit option choosen");
					internetBanking.deposit();
					break;
					case 2: System.out.println("Withdraw is choosen");
					internetBanking.withdrawal();
					break;
					case 3: System.out.println("tranfer choosen");
					internetBanking.transfer();
					break;
					case 4: System.out.println("check balance option choosen");
					System.out.println("Bank balance is "+ internetBanking.checkBalance());
					break;
					case 5: System.out.println("Logout");
					break;
					default: System.out.println("Invalid option");
				}
				System.out.println("Choice is" + choice);
			}while(choice!=5);
		}else {
			System.out.println("Invalid creds");
		}
	}
	
	private static void displayMenu() {
		System.out.println("1. Deposit");
		System.out.println("2. Withdraw");
		System.out.println("3. Transfer");
		System.out.println("4. Check balance");
		System.out.println("5. Logout");
		System.out.println("Choose an option from the menu");
	}

	private static String getPassword() {
		System.out.println("Enter password");
		return scanner.nextLine();
	}

	private static String getUserBankAccountNo() {
		System.out.println("Enter BankAccountno");
		return scanner.nextLine();
	}

	public static void displayWelcomeMessage() {
		System.out.println("Welcome to Bank Services");
	}

}
