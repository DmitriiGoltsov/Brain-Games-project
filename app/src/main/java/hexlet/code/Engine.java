package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;

import java.util.Scanner;

import static hexlet.code.App.playerInput;


public class Engine {
    public static String playerName;
    public static void startEngine() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        playerName = scanner.next();
        System.out.println("Hello, " + playerName + "!");
        if (playerInput.equals("1")) {
            Cli.makeTheAcquaintance();
        } else if (playerInput.equals("0")) {
            System.out.println("Your choice: 0");
        } else if (playerInput.equals("2")) {
            Even.startEvenGame();
        } else if (playerInput.equals("3")) {
            Calc.startCalcGame();
        } else {
            System.out.println("Wrong input");
        }
    }
}
