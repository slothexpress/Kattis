package Level1;

import java.io.*;

public class problemA {
    public static void main(String[] args) {
        String inputFileName = "C:/Users/hello/Documents/repos/FileReaderWriter/src/Level1/input.txt";
        String outputFileName = "C:/Users/hello/Documents/repos/FileReaderWriter/src/Level1/output.txt";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));

            String line1 = reader.readLine();
            String line2 = reader.readLine();
            char[] characters = line2.toCharArray();
            reader.close();


            String result = applyHangmanStrategy(line1, characters);
            System.out.println(result);

            // Write the processed data to the output file
            writer.write(result);
            writer.close();

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static String applyHangmanStrategy(String word, char[] characters) {
        int numberOfHangmanLetters = word.length();
        int numberOfFailsLeft = 10;
        int numberOfFails = 0;
        int character = 0;

        while(numberOfFails < numberOfFailsLeft) {
            char guessingLetter = characters[character];
            character++;

            int occurrences = (int) word.chars()
                    .filter(letter -> letter == guessingLetter)
                    .count();
            if(occurrences == 0) {
                numberOfFails++;
            }

            numberOfHangmanLetters = numberOfHangmanLetters - occurrences;
            if(numberOfHangmanLetters == 0) {
                return "WIN";
            }
        }
        return "LOSE";
    }


}