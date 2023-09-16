package ui;

import model.ControllerMain;
import java.util.Scanner;

public class PipeMania {
    private UserExperience userExperience;
    private Scanner reader;
    private ControllerMain controller;

    public PipeMania() {
        reader = new Scanner(System.in);
        userExperience = new UserExperience();
        controller = new ControllerMain();
    }

    public static void main(String[] args) {
        PipeMania main = new PipeMania();
        main.menu();
        main.userExperience.close();
    }

    public void menu() {
        userExperience.displayCell("PipeMania");

        String menuOptions = "1. New game\n" +
                "2. View Score\n" +
                "3. Exit";
        userExperience.displayCell(menuOptions);
        userExperience.print("Enter an option: ");

        int option = userExperience.validateInt();
        switch (option) {
            case 1 -> showGame();
            case 2 -> showScore();
            case 3 -> userExperience.displayCell("Thanks for playing, exited the game\n");
            default -> {
                println("\u001B[31m"); // Cambiar el color del texto a rojo
                userExperience.displayCell("Invalid option, try again\n");
                println("\u001B[0m"); // Restablecer el color del texto a su valor predeterminado
                menu();
            }
        }
    }

    public void showGame() {
        userExperience.displayCell("Name user");
        userExperience.print("Enter your name: ");
        String nickname = reader.nextLine();
        controller.initGame(nickname);
        showGameRecursive(nickname);
    }

    public void showGameRecursive(String nickname) {
        String boardRepresentation = controller.getCurrentBoardState();
        userExperience.displayCell("\n" + "Game board\n" + "\n" + boardRepresentation);

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
                evaluatePipe();
                showGameRecursive(nickname);
            }
            case 3 -> {
                userExperience.displayCell("Return to main menu\n");
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

    public void putPipe() {

        userExperience.displayCell("Enter the position of the pipe on the board\n");
        userExperience.print("Position (row,column): ");
        String input = reader.nextLine();
        String errorMessage = userExperience.validateInput(input);

        if (errorMessage != null) {
            userExperience.printError(errorMessage);
            putPipe();
        } else {
            String[] position = input.split(",");
            int row = Integer.parseInt(position[0]);
            int column = Integer.parseInt(position[1]);

            userExperience.displayCell("Kind of pipes\n");
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
            }

            String message = controller.putPipe(type, column, row);
            System.out.println(message);
        }
    }

    public void showScore() {

    }

    public String evaluatePipe() {
        return controller.evaluatePipe();
    }

    public void println(Object println) {
        System.out.println(println);
    }

    public void print(Object print) {
        System.out.print(print);
    }
}
