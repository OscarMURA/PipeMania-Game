package ui;

import model.ControllerMain;
import model.PipeType;
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
                userExperience.displayCell("Invalid option, try again\n");
                menu();
            }
        }
    }

    public void showGame() {
        userExperience.displayCell("Name user");
        userExperience.print("Enter your name: ");
        String nickname = reader.nextLine();
        showGameRecursive(nickname);
    }

    public void showGameRecursive(String nickname) {
        String boardRepresentation = controller.initGame(nickname);
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
                userExperience.displayCell("Invalid option, try again\n");
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
            PipeType type = null;
            switch (option) {
                case 1 -> type = PipeType.HORIZONTAL;
                case 2 -> type = PipeType.VERTICAL;
                case 3 -> type = PipeType.ELBOW;
                case 4 -> type = PipeType.X;
            }

            controller.putPipe(type.toString(), row, column);
        }

    }

    public void showScore() {

    }

    public void evaluatePipe() {

    }

    public void println(Object println) {
        System.out.println(println);
    }

    public void print(Object print) {
        System.out.print(print);
    }
}
