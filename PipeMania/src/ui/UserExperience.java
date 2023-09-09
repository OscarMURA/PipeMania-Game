package ui;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserExperience {

	private static Scanner reader;

	public UserExperience() {
		reader = new Scanner(System.in);
	}

	public void lines() {
		System.out.println("\033[47;35m"
				+ "\n\3\3------------\4\4------------\3\3------------\4\4------------\3\3------------\4\4------------\3\3\033[0m\n");
	}

	public void title(Object title) {
		System.out.println("\t\033[47;35m \3 " + title + " \3 \033[0m \n");
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