package Level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class problemB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nNumberOfCases = Integer.parseInt(scanner.nextLine());
        scanner.close();

        while(nNumberOfCases != 0) {


            calculateOptimalCost();

            nNumberOfCases--;
        }
    }

    private static void calculateOptimalCost() {
        Scanner scanner = new Scanner(System.in);
        int mNumberOfIslands = Integer.parseInt(scanner.nextLine());
        List<double[]> islands = new ArrayList<>();

        for(int i = 1; i <= mNumberOfIslands; i++) {
            String input = scanner.nextLine();
            String coordinates[] = input.split(" ");
            double x = Double.parseDouble(coordinates[0]);
            double y = Double.parseDouble(coordinates[1]);

            double[] island = {x, y};
            islands.add(island);
        }

    }

}