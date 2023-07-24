package Level1;

import java.io.*;
import java.util.Scanner;

public class problemA {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        System.out.print("Player 1 enter Hangman word: ");
        String line1 = scanner.nextLine();

        System.out.print("Player 2 enter permutation: ");
        String line2 = scanner.nextLine();

        // Close the scanner after taking input
        scanner.close();

        // Convert the second line to a char array
        char[] characters = line2.toCharArray();

        String result = applyHangmanStrategy(line1, characters);
        System.out.print(result);
    }

    private static String applyHangmanStrategy(String word, char[] letters) {
        int numberOfHangmanLetters = word.length();
        int numberOfCorrectLetters = 0;

        int numberOfFailsLeft = 10;
        int numberOfFails = 0;
        int letter = 0;

        while(numberOfFails < numberOfFailsLeft) {
            char guessingLetter = letters[letter];
            letter++;

            int occurrences = (int) word.chars()
                    .filter(l -> l == guessingLetter)
                    .count();
            if(occurrences == 0) {
                numberOfFails++;
            }

            numberOfCorrectLetters = numberOfCorrectLetters + occurrences;
            if(numberOfCorrectLetters == numberOfHangmanLetters) {
                return "WIN";
            }
        }
        return "LOSE";
    }
}