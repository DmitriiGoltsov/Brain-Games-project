package hexlet.code;

import java.util.Scanner;

public class Engine {

    public static final int NUMBER_OF_ROUND = 3;

    public static void run(String description, String[][] roundsData) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""

                Welcome to the Brain Games!
                May I have your name?""");
        String playerName = scanner.next();
        System.out.println("\nHello, " + playerName + "!");

        System.out.println(description);

        for (String[] roundData : roundsData) {
            String question = roundData[0];
            String answer = roundData[1];
            System.out.println("Question: " + question);
            String playerAnswer = scanner.next().toLowerCase();
            if (!answer.equals(playerAnswer)) {
                scanner.close();
                System.out.println("Your answer: " + playerAnswer + "\n" + playerAnswer
                        + " is wrong answer ;(. Correct answer was " + answer
                        + "\nLet's try again, " + playerName + "!");
                return;
            }
            System.out.println("Your answer: " + playerAnswer + "\nCorrect");
        }
        System.out.println("Congratulations, " + playerName + "!");
    }
}
