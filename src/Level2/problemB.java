package Level2;

import java.util.Scanner;

public class problemB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCases = Integer.parseInt(scanner.nextLine());
        while(numberOfCases != 0) {
            int numberOfIslands = Integer.parseInt(scanner.nextLine());

            calcalate();

            numberOfCases--;
        }
        scanner.close();
    }

    private static void calcalate() {
    }

}