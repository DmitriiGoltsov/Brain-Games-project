package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner initialScanner = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter. \n 0 - Exit  \n 1 - Greet \n 2 - Even");
        var playerInput = initialScanner.next();

        if (playerInput.equals("1")) {
            System.out.println("Your choice: 1");
            Cli.makeTheAcquaintance();
        } else if (playerInput.equals("0")) {
            System.out.println("Your choice: 0");
        } else if (playerInput.equals("2")) {
            System.out.println("Your choice: 2");
            Even.isEven();
        } else {
            System.out.println("Wrong input");
        }
        initialScanner.close();
    }
}
