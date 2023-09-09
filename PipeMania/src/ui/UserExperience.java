package ui;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserExperience {

	private static Scanner reader;

	public UserExperience() {
		reader = new Scanner(System.in);
	}

	public int validateInt() {
		int option = 0;
		boolean validInput = false;
		while (!validInput) {
			try {
				option = reader.nextInt();
				validInput = true;
			} catch (InputMismatchException e) {
				reader.next();
				System.out.println("\tInvalid number!");
				System.out.print("\tConrrently Type: ");
			}
		}
		return option;
	}

	public double validateDouble() {
		double option = 0;
		boolean validInput = false;
		while (!validInput) {
			try {
				option = reader.nextDouble();
				validInput = true;
			} catch (InputMismatchException e) {
				reader.next();
				System.out.println("\tInvalid number!");
				System.out.print("\tConrrently Type: ");
			}
		}
		return option;
	}

}