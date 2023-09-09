package ui;

import model.TypePipe;
import java.util.Scanner;

public class PipeMania {
    private static UserExperience userExperience;
    private static Scanner reader;

    public PipeMania() {
        reader = new Scanner(System.in);
        userExperience = new UserExperience();
    }

    public static void main(String[] args) {
        PipeMania main = new PipeMania();
        menu();
    }

    public static void menu() {
        userExperience.lines();
        userExperience.title("Starts the game");

        println("Enter an option");
        print("1. New game\n" + "2. View Score\n" + "3. Exit\n");
        int option = userExperience.validateInt();
        switch (option) {
            case 1 -> showGame();
            case 2 -> showScore();
            case 3 -> println("Thanks for playing, exited the game");
            default -> println("invalid option, try again");
        }
    }

    public static void showGame() {
        println("Enter your nickname");
        String nickname = reader.next();

    }

    public void simulatePipe() {
        println("Escriba la posicion en donde quiere ubicar el tablero:");
        println("Escriba la fila");
        int row = userExperience.validateInt();
        println("Escriba la columna");
        int column = userExperience.validateInt();
        print("Elija el tipo de tuberia:");
        print("1. Tuberia horizontal\n" + "2. Tuberia vertical\n" + "3. Tuberia circular\n");
        int option = userExperience.validateInt();
        TypePipe type;
        switch (option) {
            case 1 -> type = TypePipe.HORIZONTAL;
            case 2 -> type = TypePipe.VERTICAL;
            case 3 -> type = TypePipe.CIRCULAR;
        }
    }

    public static void showScore() {

    }

    public static void evaluatePipe() {

    }

    public static void println(Object println) {
        System.out.println(println);
    }

    public static void print(Object print) {
        System.out.print(print);
    }
}
