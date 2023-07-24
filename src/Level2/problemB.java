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
        // Step 1: Setup Coordinates
        List<double[]> islands = readIslandCoordinates();

        // Step 2: Calculate Distances
        double[][] distances = calculateDistances(islands);

        // Now the 'distances' 2D array contains the distances between all pairs of islands.
        // You can use this array for further processing to find the optimal cost.
    }

    private static List<double[]>  readIslandCoordinates() {
        List<double[]> islands = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int mNumberOfIslands = Integer.parseInt(scanner.nextLine());
        for(int i = 1; i <= mNumberOfIslands; i++) {
            String input = scanner.nextLine();
            String coordinates[] = input.split(" ");
            double x = Double.parseDouble(coordinates[0]);
            double y = Double.parseDouble(coordinates[1]);

            double[] island = {x, y};
            islands.add(island);
        }
        return islands;
    }

    private static double[][] calculateDistances(List<double[]> islands) {
        int mNumberOfIslands = islands.size();
        double[][] distances = new double[mNumberOfIslands][mNumberOfIslands];

        for (int i = 0; i < mNumberOfIslands; i++) {
            for (int j = i + 1; j < mNumberOfIslands; j++) {
                double x1 = islands.get(i)[0];
                double y1 = islands.get(i)[1];
                double x2 = islands.get(j)[0];
                double y2 = islands.get(j)[1];

                double distance = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));

                // Since the graph is undirected, we store the distance in both directions.
                distances[i][j] = distance;
                distances[j][i] = distance;
            }
        }

        return distances;
    }

}