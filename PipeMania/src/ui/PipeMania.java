package ui;

import model.ControllerMain;
import java.util.Scanner;

/**
 * The class is named "PipeMania" and does not contain any code.
 */
public class PipeMania {
    private UserExperience userExperience;
    private Scanner reader;
    private ControllerMain controller;

    // The `public PipeMania()` constructor initializes the `reader`,
    // `userExperience`, and `controller`
    // objects.
    public PipeMania() {
        reader = new Scanner(System.in);
        userExperience = new UserExperience();
        controller = new ControllerMain();
    }

    /**
     * The main function creates an instance of the PipeMania class, calls the menu
     * method, and then
     * closes the userExperience.
     */
    public static void main(String[] args) {
        PipeMania main = new PipeMania();
        main.menu();
        main.userExperience.close();
    }

    /**
     * The menu function displays a menu with options for a game, allows the user to
     * select an option,
     * and performs the corresponding action.
     */
    public void menu() {
        println("\u001B[34m"); // Cambiar el color del texto a verde
        userExperience.displayCell("PipeMania");
        println("\u001B[0m"); // Cambiar el color del texto a verde

        String menuOptions = "1. New game\n" +
                "2. View Score\n" +
                "3. Exit";
        userExperience.displayCell(menuOptions);
        userExperience.print("Enter an option: ");

        int option = userExperience.validateInt();
        switch (option) {
            case 1 -> showGame();
            case 2 -> {
                String ranking = showRanking();
                userExperience.displayCellWithHeader(ranking, "Ranking");
                userExperience.lines();
                menu();
            }

            case 3 -> {
                println("\u001B[32m"); // Cambiar el color del texto a verde
                userExperience.displayCell("Thanks for playing, exited the game\n");
                println("\u001B[0m"); // Cambiar el color del texto a verde
            }
            default -> {
                println("\u001B[31m"); // Cambiar el color del texto a rojo
                userExperience.displayCell("Invalid option, try again\n");
                println("\u001B[0m"); // Restablecer el color del texto a su valor predeterminado
                menu();
            }
        }
    }

    /**
     * The function "showGame" displays the game, prompts the user for their name,
     * initializes the game
     * with the given name, and then calls the recursive function
     * "showGameRecursive" with the given
     * name.
     */
    public void showGame() {
        println("\u001B[33m"); // Cambiar el color del texto a verde
        userExperience.displayCell("Name user");
        println("\u001B[0m"); // Cambiar el color del texto a verde
        userExperience.print("Enter your name: ");
        String nickname = reader.nextLine();
        controller.initGame(nickname);
        showGameRecursive(nickname);
    }

    /**
     * The function `showGameRecursive` displays the game board, menu options, and
     * prompts the user for
     * an option, then performs the corresponding action based on the user's choice.
     * 
     * @param nickname The nickname is a string that represents the player's
     *                 nickname or username. It is
     *                 used as a parameter in the showGameRecursive method.
     */
    public void showGameRecursive(String nickname) {
        String boardRepresentation = controller.getCurrentBoardState();
        userExperience.displayCell("\n" + "\u001B[31m" + "Game board" + "\u001B[0m\n" + "\n" + boardRepresentation);
        String menuOptions = "1. Put Pipe\n" +
                "2. Simulate\n" +
                "3. Exit";
        userExperience.displayCell(menuOptions);
        userExperience.print("Enter an option: ");
        int option = userExperience.validateInt();
        switch (option) {
            case 1 -> {
                putPipe();
                showGameRecursive(nickname);
            }
            case 2 -> {
                String result = evaluatePipe();
                println("\u001B[32m"); // Cambiar el color del texto a verde
                userExperience.displayCell(result);
                println("\u001B[0m"); // Cambiar el color del texto a verde
                showGameRecursive(nickname);
            }
            case 3 -> {
                String result = finishMatch(); // Evaluación al salir del juego
                userExperience.displayCell(result); // Muestra el resultado
                println("\u001B[32m"); // Cambiar el color del texto a verde
                userExperience.displayCell("Return to main menu\n");
                println("\u001B[0m"); // Cambiar el color del texto a verde
                menu();
            }
            default -> {
                println("\u001B[31m"); // Cambiar el color del texto a rojo
                userExperience.displayCell("Invalid option, try again\n");
                println("\u001B[0m"); // Restablecer el color del texto a su valor predeterminado
                showGameRecursive(nickname);
            }
        }
    }

    /**
     * The function `putPipe()` prompts the user to enter the position and type of a
     * pipe on a game
     * board, validates the input, and then calls the `putPipe()` method of the
     * `controller` object
     * with the specified parameters.
     */
    public void putPipe() {
        println("\u001B[33m"); // Cambiar el color del texto a verde
        userExperience.displayCell("Enter the position of the pipe on the board\n");
        println("\u001B[0m"); // Cambiar el color del texto a verde
        userExperience.print("Position (X,Y): ");
        String input = reader.nextLine();
        String errorMessage = userExperience.validateInput(input);

        if (errorMessage != null) {
            userExperience.printError(errorMessage);
            putPipe();
        } else {
            String[] position = input.split(",");
            int row = Integer.parseInt(position[0]);
            int column = Integer.parseInt(position[1]);

            // Validar las coordenadas aquí
            if (row > 7 || row < 0 || column > 7 || column < 0) {
                System.out.println("\u001B[31m"); // Cambiar el color del texto a rojo
                userExperience.displayCell("Failed, invalid index");
                System.out.println("\u001B[0m"); // Restablecer el color del texto a su valor predeterminado

                putPipe(); // Volver a solicitar las coordenadas
            } else {
                println("\u001B[34m"); // Cambiar el color del texto a verde
                userExperience.displayCell("Kind of pipes\n");
                println("\u001B[0m"); // Cambiar el color del texto a verde
                String menuOptions = "1. Horizontal pipe\n" +
                        "2. Vertical pipe\n" +
                        "3. Circular pipe\n" +
                        "4. remove pipe";
                userExperience.displayCell(menuOptions);
                userExperience.print("Enter an option pipe: ");
                int option = userExperience.validateInt();
                String type = " ";
                switch (option) {
                    case 1 -> type = "=";
                    case 2 -> type = "||";
                    case 3 -> type = "o";
                    case 4 -> type = "X";
                    default -> {
                        println("\u001B[31m"); // Cambiar el color del texto a rojo
                        userExperience.displayCell("Invalid option, try again\n");
                        println("\u001B[0m"); // Restablecer el color del texto a su valor predeterminado

                        putPipe();
                    }
                }

                controller.putPipe(type, column, row);
            }
        }
    }

    /**
     * The function returns the ranking from the controller.
     * 
     * @return The method is returning a String value.
     */
    public String showRanking() {
        return controller.getRanking();
    }

    /**
     * The function "evaluatePipe" returns the result of evaluating a pipe in a
     * controller.
     * 
     * @return The evaluatePipe() method is returning a String value.
     */
    public String evaluatePipe() {
        return controller.evaluatePipe();
    }

    /**
     * The function "finishMatch" returns the result of calling the "finishMatch"
     * method on the
     * "controller" object.
     * 
     * @return The method is returning a String value.
     */
    public String finishMatch() {
        return controller.finishMatch();
    }

    /**
     * The function prints the value of an object to the console.
     * 
     * @param println The parameter "println" is of type Object, which means it can
     *                accept any type of
     *                object as an argument.
     */
    public void println(Object println) {
        System.out.println(println);
    }

    /**
     * The function "print" in Java prints the given object to the console.
     * 
     * @param print The parameter "print" is of type Object, which means it can
     *              accept any type of
     *              object as an argument.
     */
    public void print(Object print) {
        System.out.print(print);
    }
}
