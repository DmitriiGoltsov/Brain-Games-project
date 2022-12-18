package hexlet.code.games;

import java.util.Scanner;

import static hexlet.code.Engine.playerName;

public class Prime {
    public static void startPrimeGame() {
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        var victoryCount = 0;
        Scanner scanner = new Scanner(System.in);

        //Start a cycle that counts player's victories and initialize the given number
        for (var i = 0; i <= 3; i++) {

            /* Initialize variable "number" that is shown to the player.
            * Player has to answer whether "number" is prime or not.
            * Initialize variable prime. It will be used in conditional checks below
            * the variable "count" counts how many divisors exist to "number" variable.
            * If there are more than 2 then "number" isn't a Prime */
            int number = (int) (2 + Math.random() * 100);
            boolean prime = true;
            var count = 0;

            /*This part of code checks whether "number" variable is prime or not. It also fills "prime" variable.
            * It divides "number" on every possible number from 1 to "number" itself.
            * Prime numbers can be divided only by 1 and per se. Thus, if a number can be divided more than 2 times,
            * then it is not a prime number. */
            for (var i2 = 1; i2 <= number; i2++) {
                var check = number % i2;
                if (check == 0) {
                    count++;
                }
                if (count >= 3) {
                    prime = false;
                }
            }
            System.out.println("Question: " + number);
            var playerAnswer = scanner.next();

            /*This part of code checks if player's answers were correct or no.
            If answers are correct, it decrements victoryCount variable for the sake of the next part of the code. */
            if (playerAnswer.equals("yes") && prime) {
                System.out.println("Your answer: yes \nCorrect!");
                victoryCount++;
            } else if (playerAnswer.equals("no") && !prime) {
                System.out.println("Your answer: no \nCorrect!");
                victoryCount++;
            } else if (playerAnswer.equals("yes") && !prime) {
                System.out.println("Your answer: " + playerAnswer);
                System.out.println("'" + playerAnswer + "'" + " is wrong answer ;(. Correct answer was 'no'"
                        + "\nLet's try again, " + playerName + "!");
                break;
            } else if (playerAnswer.equals("no") && prime) {
                System.out.println("Your answer: " + playerAnswer);
                System.out.println("'" + playerAnswer + "'" + " is wrong answer ;(. Correct answer was 'yes'"
                        + "\nLet's try again, " + playerName + "!");
                break;
            } else {
                System.out.println("Wrong input");
                break;
            }

            // This part of the code checks the victory condition. If player gives three correct answers,
            // the game shows congratulation text and finish itself.
            if (victoryCount == 3) {
                System.out.println("Congratulations, " + playerName + "!");
                break;
            }
        }
    }
}
