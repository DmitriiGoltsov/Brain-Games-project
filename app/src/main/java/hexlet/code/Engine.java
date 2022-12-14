package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;

import java.util.Scanner;

import static hexlet.code.App.playerInput;


public class Engine {
    public static String playerName;
    public static String startEngine() {
        if (playerInput.equals("0")) {
            return null;
        }
        if (playerInput.equals("1")) {
            Cli.makeTheAcquaintance();
            return null;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWelcome to the Brain Games!");
        System.out.println("May I have your name?");
        playerName = scanner.next();
        System.out.println("\nHello, " + playerName + "!");
        if (playerInput.equals("2")) {
            Even.startEvenGame();
        } else if (playerInput.equals("3")) {
            Calc.startCalcGame();
        } else if (playerInput.equals("4")) {
            GCD.findGCD();
        } else {
            System.out.println("Wrong input");
            return null;
        }
        return null;
    }
}
