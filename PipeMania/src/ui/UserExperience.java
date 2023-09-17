package ui;

import java.util.Scanner;

/**
 * The UserExperience class is used to manage and improve the user experience of
 * a software
 * application.
 */
public class UserExperience {

	private Scanner reader;

	// The `public UserExperience()` constructor initializes a new instance of the
	// `UserExperience` class.
	// It creates a new `Scanner` object named `reader` that reads input from the
	// standard input stream
	// (`System.in`). This `Scanner` object will be used to read user input
	// throughout the
	// `UserExperience` class.
	public UserExperience() {
		reader = new Scanner(System.in);
	}

	public void clearScreen() {
		System.out.print("\033[H\033[2J"); // Limpia la pantalla
		System.out.flush();
	}

	/**
	 * The function `displayCell` takes a string `content` and displays it inside a
	 * bordered cell with
	 * centered text.
	 * 
	 * @param content The content parameter is a string that represents the content
	 *                to be displayed in the
	 *                cell. It can contain multiple lines separated by newline
	 *                characters ("\n").
	 */
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

	public void displayCellWithHeader(String content, String header) {
		String horizontalLine = "═".repeat(49);
		System.out.println("╔" + horizontalLine + "╗");
		System.out.println("║" + centerText(header, 49) + "║"); // Agregar el encabezado
		System.out.println("╠" + horizontalLine + "╣"); // Agregar una línea divisoria
		String[] lines = content.split("\n");
		for (String line : lines) {
			String ansiCode = "\u001B\\[[;\\d]*m";
			String lineWithoutAnsi = line.replaceAll(ansiCode, "");
			System.out.println("║" + centerText(line, 49) + "║");
		}
		System.out.println("╚" + horizontalLine + "╝");
	}

	/**
	 * The function validates user input to ensure it is an integer.
	 * 
	 * @return The method is returning an integer value.
	 */
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

	/**
	 * The `centerText` function takes a string and an integer as input, and returns
	 * the string centered
	 * within a specified width.
	 * 
	 * @param text  The text that you want to center.
	 * @param width The width parameter represents the desired width of the centered
	 *              text.
	 * @return The method `centerText` returns a string that represents the input
	 *         text centered within the
	 *         specified width.
	 */
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

	/**
	 * The function `validateInput` checks if a given input string is in the format
	 * "(number,number)" and
	 * if both numbers are non-negative.
	 * 
	 * @param input The input parameter is a string that represents a pair of
	 *              numbers separated by a
	 *              comma.
	 * @return The method returns an error message as a String. If there are no
	 *         validation errors, the
	 *         method returns null.
	 */
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

	/**
	 * The function "print" in Java prints a given message to the console.
	 * 
	 * @param message The message parameter is a string that represents the message
	 *                to be printed.
	 */
	public void print(String message) {
		System.out.print(message);
	}

	/**
	 * The function "println" prints a given message to the console.
	 * 
	 * @param message The message parameter is a String that represents the message
	 *                to be printed.
	 */
	public void println(String message) {
		System.out.print(message);
	}

	/**
	 * The function "printError" prints an error message in red color.
	 * 
	 * @param message The "message" parameter is a string that represents the error
	 *                message that you want
	 *                to display.
	 */
	public void printError(String message) {
		println("\u001B[31m");
		displayCell("Error: " + message);
		println("\u001B[0m"); // Restablecer el color del texto a su valor predeterminado
	}

	// The `close()` method is used to close the `Scanner` object `reader` that was
	// created in the
	// constructor of the `UserExperience` class. This method is called to release
	// any system resources
	// associated with the `Scanner` object and to prevent any resource leaks.
	public void close() {
		reader.close();
	}
}