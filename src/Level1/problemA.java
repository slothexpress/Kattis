package Level1;

import java.io.*;
import java.util.Scanner;

public class problemA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String hangmanWord = scanner.nextLine();
        String permutation = scanner.nextLine();
        scanner.close();

        // Convert the second line to a char array
        char[] characters = permutation.toCharArray();

        String result = applyHangmanStrategy(hangmanWord, characters);
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