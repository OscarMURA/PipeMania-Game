package ui;

import java.util.Scanner;

public class UserExperience {

	private Scanner reader;

	public UserExperience() {
		reader = new Scanner(System.in);
	}

	public void clearScreen() {
		System.out.print("\033[H\033[2J"); // Limpia la pantalla
		System.out.flush();
	}

	public void displayCell(String content) {
		String horizontalLine = "═".repeat(49);
		System.out.println("╔" + horizontalLine + "╗");
		String[] lines = content.split("\n");
		for (String line : lines) {
			String ansiCode = "\u001B\\[[;\\d]*m";
			String lineWithoutAnsi = line.replaceAll(ansiCode, "");
			System.out.println("║" + centerText(line, 49) + "║"); // Imprimir la línea original
		}
		System.out.println("╚" + horizontalLine + "╝");
	}

	// valida los enteros
	public int validateInt() {
		int option = 0;
		if (reader.hasNextInt()) {
			option = reader.nextInt();
		} else {
			reader.next();
			printError("Invalid number!");
			print("Enter the correct option: ");
			option = validateInt();
		}
		return option;
	}

	// centrar el texto
	private String centerText(String text, int width) {
		String ansiCode = "\u001B\\[[;\\d]*m";
		String textWithoutAnsi = text.replaceAll(ansiCode, "");
		if (textWithoutAnsi.length() > width) {
			width = textWithoutAnsi.length(); // Ajusta el ancho al tamaño del texto
		}
		int paddingSize = (width - textWithoutAnsi.length()) / 2;
		String padding = " ".repeat(paddingSize);
		if ((width - textWithoutAnsi.length()) % 2 == 1) {
			// Si la longitud del texto y el ancho son diferentes en paridad, agrega un
			// espacio extra al final
			return padding + text + padding + " ";
		} else {
			return padding + text + padding;
		}
	}

	// valida el formato de las coordenadas
	public String validateInput(String input) {
		String[] parts = input.split(",");
		String errorMessage = null;

		if (parts.length != 2) {
			errorMessage = "Input must be: (number,number)";
		} else if (!parts[0].matches("\\d+") || !parts[1].matches("\\d+")) {
			errorMessage = "Both row and column must be numbers";
		} else {
			int row = Integer.parseInt(parts[0]);
			int column = Integer.parseInt(parts[1]);

			if (row < 0 || column < 0) {
				errorMessage = "Both must be non-negative numbers";
			}
		}

		return errorMessage;
	}

	public void print(String message) {
		System.out.print(message);
	}

	public void println(String message) {
		System.out.print(message);
	}

	public void printError(String message) {
		println("\u001B[31m");
		displayCell("Error: " + message);
		println("\u001B[0m"); // Restablecer el color del texto a su valor predeterminado
	}

	public void close() {
		reader.close();
	}
}