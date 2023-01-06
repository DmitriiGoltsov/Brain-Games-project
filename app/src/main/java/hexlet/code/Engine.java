package hexlet.code;

import java.util.Scanner;

public class Engine {

    private static final int NUMBEROFROUND = 3;
    private static final int NUMBEROFROUNDSTOGENERATEFOR = 1;
    private static final int NUMBEROFQUESTIONSANDANSWERS = 2;

    public static int getNumberOfRound() {
        return NUMBEROFROUND;
    }

    public static int getNumberofquestionsandanswers() {
        return NUMBEROFQUESTIONSANDANSWERS;
    }

    public static int getNumberOfRoundsToGenerateFor() {
        return NUMBEROFROUNDSTOGENERATEFOR;
    }

    public static void run(String description, String[][] roundsData) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""

                Welcome to the Brain Games!
                May I have your name?""");
        String playerName = scanner.next();
        System.out.println("\nHello, " + playerName + "!");

        System.out.println(description);
        int victoryCount = 0;

        for (String[] roundsDatum : roundsData) {
            System.out.println("Question: " + roundsDatum[0]);
            String playerAnswer = scanner.next().toLowerCase();
            if (playerAnswer.equals(roundsDatum[1])) {
                System.out.println("Your answer: " + playerAnswer + "\nCorrect");
                victoryCount += 1;
                if (victoryCount == roundsData.length) {
                    System.out.println("Congratulations, " + playerName + "!");
                    return;
                }
            } else {
                System.out.println("Your answer: " + playerAnswer + "\n" + playerAnswer
                        + " is wrong answer ;(. Correct answer was " + roundsDatum[1]
                        + "\nLet's try again, " + playerName + "!");
                return;
            }
        }
    }
}
