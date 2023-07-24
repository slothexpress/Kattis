package Level3;
import java.util.Scanner;

public class problemC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = Integer.parseInt(scanner.nextLine());

        while (numberOfCases != 0) {
            solve(scanner);
            numberOfCases--;
        }

        scanner.close();
    }
    private static void solve(Scanner scanner) {
        // Get first line for each case/game: number of tiles
        int n = Integer.parseInt(scanner.nextLine());
        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }
        // Now we have the board configuration in the 'board' variable.
    }
}
