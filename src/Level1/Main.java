package Level1;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String inputFileName = "C:/Users/hello/Documents/repos/FileReaderWriter/src/Level1/input.txt";
        String outputFileName = "C:/Users/hello/Documents/repos/FileReaderWriter/src/Level1/output.txt";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));

            String line1 = reader.readLine();
            String line2 = reader.readLine();
            String[] characters = line2.split("");
            reader.close();


            String result = processData(line1, characters);
            System.out.println(result);

            // Write the processed data to the output file
            writer.write(result);
            writer.close();

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static String processData(String word, String[] characters) {

        return "LOSE";
    }


}