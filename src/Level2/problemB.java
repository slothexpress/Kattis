package Level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class problemB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nNumberOfCases = Integer.parseInt(scanner.nextLine());
        while(nNumberOfCases != 0) {
            calculateOptimalCostForCase(scanner);
            nNumberOfCases--;
        }
        scanner.close();
    }

    private static void calculateOptimalCostForCase(Scanner scanner) {
        List<double[]> islands = readIslandCoordinates(scanner);
        double[][] distances = calculateDistances(islands);

        // Find the Minimum Spanning Tree (MPT) using Prim's Algorithm
        double minCost = applyPrimsAlgorithm(distances);
        System.out.println(minCost);
    }

    private static List<double[]> readIslandCoordinates(Scanner scanner) {
        List<double[]> islands = new ArrayList<>();

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

                // Store the distance in both directions.
                distances[i][j] = distance;
                distances[j][i] = distance;
            }
        }

        return distances;
    }

    private static double applyPrimsAlgorithm(double[][] distances) {
        int numberOfIslands = distances.length;
        boolean[] visited = new boolean[numberOfIslands];
        double[] costs = new double[numberOfIslands];

        // Step 1: Initialize arrays
        for (int i = 0; i < numberOfIslands; i++) {
            costs[i] = Double.MAX_VALUE;
            visited[i] = false;
        }

        // Step 2: Start with the first island (index 0)
        costs[0] = 0.0; // The cost to reach itself is set to 0.

        // Step 3: Grow the Minimum Spanning Tree (MST) by iteratively adding the next island
        for (int step = 0; step < numberOfIslands - 1; step++) {

            // Step 3.1: Find the unvisited island with the minimum cost to add to the MST
            int nextIsland = -1;
            for (int island = 0; island < numberOfIslands; island++) {
                if (!visited[island] && (nextIsland == -1 || costs[island] < costs[nextIsland])) {
                    nextIsland = island;
                }
            }

            // Step 3.2: Mark the next island as visited (it is now included in the MST)
            visited[nextIsland] = true;

            // Step 3.3: Update the costs of neighboring islands based on the next island
            for (int island = 0; island < numberOfIslands; island++) {
                if (!visited[island] && distances[nextIsland][island] < costs[island]) {
                    costs[island] = distances[nextIsland][island];
                }
            }
        }

        // Step 4: Calculate the total bridge length (minimum spanning tree cost).
        double totalCost = 0.0;
        for (double bridgeCost : costs) {
            totalCost = totalCost + bridgeCost;
        }

        return totalCost;
    }

}