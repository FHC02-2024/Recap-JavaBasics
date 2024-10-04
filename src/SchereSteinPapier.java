import java.util.Random;
import java.util.Scanner;

public class SchereSteinPapier {

    public static void main(String[] args) {
        // Programmlogik

        String[] choices = new String[3];
        choices[0] = "Schere";
        choices[1] = "Stein";
        choices[2] = "Papier";

        // 2. Möglichkeit
        String[] choices2 = {"Schere", "Stein", "Papier"};

        //printChoices(choices);
        String playerChoice = playerMakesChoice(choices);
        System.out.println("playerChoice = " + playerChoice);

        String compChoice = computerMakesChoice(choices);
        System.out.println("compChoice = " + compChoice);

        checkWinner(playerChoice, compChoice);

    }

    public static String playerMakesChoice(String[] choices) {
        Scanner scanner = new Scanner(System.in);
        boolean isValid = false;
        String choice = "";

        while(!isValid) {
            printChoices(choices);
            System.out.println("Bitte treffe eine Auswahl: ");
            int userInput = scanner.nextInt();

            if (userInput > 0 && userInput <= 3) {
                isValid = true;
                choice = choices[userInput - 1];
            } else {
                System.out.println("Falsche Auswahl. Versuche es weiter");
            }
        }

        return choice;
    }

    public static void printChoices(String[] choices) {
        System.out.println("Auswahlmöglichkeiten:");
        for (int i = 0; i < choices.length; i++) {
            System.out.println("[" + (i + 1) + "] " + choices[i]);
        }
    }

    public static String computerMakesChoice(String[] choices) {
        Random rand = new Random();
        int randInt = rand.nextInt(3);
        return choices[randInt];
    }

    public static void checkWinner(String player, String comp) {
        if (player.equals("Schere") && comp.equals("Papier") ||
                player.equals("Stein") && comp.equals("Schere") ||
                player.equals("Papier") && comp.equals("Stein")
        ) {
            System.out.println("Juhuuu! Ich habe gewonnen");
        } else if (player.equals(comp)) {
            System.out.println("Unentschieden");
        } else {
            System.out.println("Oje! Ich habe leider die falsche Wahl getroffen");
        }
    }
}
