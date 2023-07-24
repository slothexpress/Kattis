import java.io.*;

public class Main {
    public static void main(String[] args) {
        String inputFileName = "C:/Users/hello/Documents/repos/FileReaderWriter/src/STDINPUT.txt";
        String outputFileName = "C:/Users/hello/Documents/repos/FileReaderWriter/src/STDOUTPUT.txt";

        try {
            // Read data from input file
            BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
            StringBuilder inputData = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                inputData.append(line).append("\n");
            }
            reader.close();

            // Process the data (You can implement your processing logic here)
            String processedData = processData(inputData.toString());

            // Write data to output file (create or replace)
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));
            writer.write(processedData);
            writer.close();
            System.out.println("Data successfully processed and written to " + outputFileName);

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // Implement your data processing logic here
    private static String processData(String data) {
        // You can write your processing logic here
        // For example, you can manipulate the data, perform calculations, etc.
        // For now, let's just return the same data as it is.
        return data;
    }
}
