package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Account;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		runProgram(UI.initialScreen());
		clearScreen();

		System.out.println("funfou");

	}

	public static void runProgram(int opt) {
		Integer choice = opt;
		Scanner sc = new Scanner(System.in);
		List<Account> accounts = new ArrayList<>();
		boolean acessACC = false;
		boolean acessPSS = false;

		while (choice != 3) {

			if (choice == 1) {

				while (acessACC == false && acessPSS == false) {
					clearScreen();
					while (acessACC == false) {
						System.out.print("Account: ");
						int acc = sc.nextInt();
						for (Account account : accounts) {
							if (acc == account.getAccNumber()) {
								acessACC = true;
								System.out.println("boa!");
							}
						}
						if (acessACC == false) {
							System.out.println("invalid account, try again!");
						}
					}

					while (acessPSS == false) {
						System.out.print("Password: ");
						String pss = sc.next();
						for (Account account : accounts) {
							if (pss.equals(account.getPassword())) {
								acessPSS = true;
								int index = accounts.indexOf(account);
								System.out.println("ACESS GRANTED!");
								UI.initialPage(accounts.get(index));
							}
						}
						if (acessPSS == false) {
							System.out.println("invalid Password, try again!");
						}
					}

				}

			} else if (choice == 2) {
				clearScreen();
				System.out.println("Enter data to create account:");

				System.out.print("Name: ");
				String name = sc.nextLine();

				System.out.print("Account number: ");
				int accNumber = sc.nextInt();

				System.out.print("Password; ");
				String password = sc.next();

				System.out.print("Initial balance: ");
				double balance = sc.nextDouble();
				sc.nextLine();

				accounts.add(new Account(name, accNumber, password, balance));
				choice = UI.initialScreen();

			}
		}
		sc.close();
	}

	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public static void option(int opt, Account acc) {
		switch (opt) {
		case 1:
			System.out.println("Balance: $$" + String.format("%.2f", acc.getBalance()));
			System.out.print("press 1 to go back");
			new Scanner(System.in).next();
			UI.initialPage(acc);
			break;

		case 2:
			System.out.print("type in the deposit amount:");
			double amount = new Scanner(System.in).nextDouble();
			acc.deposit(amount);
			System.out.println("Sucess, new balance is: $$ " + String.format("%.2f", acc.getBalance()));
			System.out.print("press 1 to go back");
			new Scanner(System.in).next();
			UI.initialPage(acc);
			break;

		case 3:
			System.out.print("type in the withdraw amount:");
			acc.withDraw(new Scanner(System.in).nextDouble());
			System.out.println("Sucess, new balance is: $$ " + String.format("%.2f", acc.getBalance()));
			System.out.print("press 1 to go back");
			new Scanner(System.in).next();
			UI.initialPage(acc);
			break;

		case 4:
			runProgram(UI.initialScreen());
			break;		

		default:
			System.out.println("Ivalid option, try again!");
			UI.initialPage(acc);
		}
	}

}
