package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import java.util.Scanner;

import static hexlet.code.App.getPlayerInput;


public class Engine {
    private static String playerName;
    public static String getPlayerName() {
        return playerName;
    }
    public static String startEngine() {
        if (getPlayerInput().equals("0")) {
            return null;
        }
        if (getPlayerInput().equals("1")) {
            Cli.makeTheAcquaintance();
            return null;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWelcome to the Brain Games!");
        System.out.println("May I have your name?");
        playerName = scanner.next();
        System.out.println("\nHello, " + playerName + "!");
        if (getPlayerInput().equals("2")) {
            Even.startEvenGame();
        } else if (getPlayerInput().equals("3")) {
            Calc.startCalcGame();
        } else if (getPlayerInput().equals("4")) {
            GCD.findGCD();
        } else if (getPlayerInput().equals("5")) {
            Progression.startProgressionGame();
        } else if (getPlayerInput().equals("6")) {
            Prime.startPrimeGame();
        } else {
            System.out.println("Wrong input");
            return null;
        }
        return null;
    }
}
