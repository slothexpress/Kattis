import java.io.*;

public class Main {
    public static void main(String[] args) {
        String inputFileName = "C:/Users/hello/Documents/repos/FileReaderWriter/src/STDINPUT.txt";
        String outputFileName = "C:/Users/hello/Documents/repos/FileReaderWriter/src/STDOUTPUT.txt";

            try {
                BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));

                String line;
                while ((line = reader.readLine()) != null) {
                    // Process the data line by line (You can implement your processing logic here)
                    String processedLine = processData(line);

                    // Write the processed data immediately to the output file
                    writer.write(processedLine);
                    writer.newLine();
                }

                reader.close();
                writer.close();

            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }

    // Implement your data processing logic here
    private static String processData(String data) {
        // You can write your processing logic here
        String dataArray[] = data.split(" ");

        long num1 = Long.parseLong(dataArray[0]);
        long num2 = Long.parseLong(dataArray[1]);

        if (num1 > num2) {
            return String.valueOf(num1 - num2);
        }
        return String.valueOf(num2 - num1);
    }
}
