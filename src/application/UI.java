package application;

import java.util.Scanner;

import entities.Account;

public class UI {
	static Scanner sc = new Scanner(System.in);	
	
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
	
	public static int initialScreen() {
		System.out.println("Hello! welcome to Java Bank.");
		System.out.println("--------------------------------------------------");
		System.out.println("to sign in please press: 1");
		System.out.println("to create an account please press: 2");	
		System.out.println("to exit please press: 3");
		int choice = sc.nextInt();
		return choice;
	}
	
	public static Account logInScreen() {
		clearScreen();
		System.out.print("Account: ");
		int acc = sc.nextInt();
		System.out.print("Password:");
		String password = sc.next();
		return new Account(acc,password);
	}
	
	public static void initialPage(Account acc) {
		clearScreen();
		System.out.println("Welcome!");
		System.out.println("1 - balance.");
		System.out.println("2 - deposit");
		System.out.println("3 - withdraw");
		System.out.println("4 - log out");
		System.out.println("5 - exit");
		int option = sc.nextInt();
		Program.option(option, acc);
		
	}
	
	
	
	
}
