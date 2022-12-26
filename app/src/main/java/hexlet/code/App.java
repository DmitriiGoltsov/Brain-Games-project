package hexlet.code;

import hexlet.code.games.*;

import java.util.Scanner;

public class App {
    private static String playerInput;
    public static String getPlayerInput() {
        return playerInput;
    }
    public static void main(String[] args) {
        Scanner initialScanner = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter. "
                + "\n 1 - Greet"
                + "\n 2 - Even"
                + "\n 3 - Calc"
                + "\n 4 - GCD"
                + "\n 5 - Progression"
                + "\n 6 - Prime"
                + "\n 0 - Exit");
        playerInput = initialScanner.next();
        System.out.println("Your choice: " + playerInput);
        switch (playerInput) {
            case "0":
                break;
            case "1":
                Cli.makeTheAcquaintance();
                break;
            case "2":
                Even.startEvenGame();
                break;
            case "3":
                Calc.startCalcGame();
                break;
            case "4":
                GCD.startGCDGame();
                break;
            case "5":
                Progression.startProgressionGame();
                break;
            case "6":
                Prime.startPrimeGame();
                break;
            default:
                System.out.println("Wrong input");
        }
        initialScanner.close();
    }
}
