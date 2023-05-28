package com.greatlearning.services;

import java.util.Scanner;

import com.greatlearning.interfaces.InternetBanking;

public class IndianBank implements InternetBanking {
	
	public static Scanner scanner = new Scanner(System.in);
	public int bankBalance = 1000;
	public void deposit() {
		System.out.println("Enter the amount to deposit");
		int amount = scanner.nextInt();
		if(amount>0) {
			bankBalance = bankBalance + amount;
			System.out.println("Amount "+ amount + "has been deposited successfully");
			System.out.println("Updated balance is "+ bankBalance);
		}else {
			System.out.println("Invalid amount entered");
		}
	}

	public boolean withdrawal() {
		System.out.println("Enter the amount to withdraw");
		int amount = scanner.nextInt();
		if(amount > 0) {
			if(bankBalance-amount>=0) {
				bankBalance -= amount;
				System.out.println("Amount "+ amount + "has been withdrawn successfully");
				System.out.println("Updated balance is "+ bankBalance);
				return true;
			}else {
				System.out.println("Cannot withdraw more than the balance " + bankBalance);
				return false;
			}
		}
		else {
			System.out.println("Invalid amount entered");
			return false;
		}
	}

	public int checkBalance() {
		return bankBalance;
	}

	public boolean transfer() {
		OTPGenerator otpGenerator = new OTPGenerator();
		int otpGenerated = otpGenerator.generateOTP();
		System.out.println(otpGenerated+" otp generated");
		System.out.println("Enter otp");
		int otp = scanner.nextInt();
		if(otp == otpGenerated) {
			System.out.println("Enter the amount you want to transfer");
			int amount = scanner.nextInt();
			System.out.println("Enter the bankAccountNo to tranfer");
			String bankAccountNo = scanner.next();
			if(bankBalance-amount>=0) {
				bankBalance -= amount;
				System.out.println("Amount "+ amount + "has been transferred successfully to "+ bankAccountNo);
				System.out.println("Updated balance is "+ bankBalance);
				return true;
			}else {
				System.out.println("Cannot transfer more than the balance " + bankBalance);
				return false;
			}
		}else {
			System.out.println("Invalid otp");
			return false;
		}
	}

}
