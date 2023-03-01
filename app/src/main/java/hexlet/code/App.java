package hexlet.code;

import hexlet.code.games.GCD;
import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;
import java.util.Scanner;



public class App {

    public static void main(String[] args) {
        Scanner initialScanner = new Scanner(System.in);

        System.out.println("""
                Please enter the game number and press Enter.\s
                 1 - Greet
                 2 - Even
                 3 - Calc
                 4 - GCD
                 5 - Progression
                 6 - Prime
                 0 - Exit""");
        String playerInput = initialScanner.next();
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
