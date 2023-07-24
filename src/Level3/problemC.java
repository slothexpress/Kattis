package Level3;
import java.util.Scanner;

public class problemC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfCases; i++) {
            solve(scanner);
        }
        scanner.close();
    }

    private static void solve(Scanner scanner) {
        int n = readLengthForGameBoard(scanner);
        int[][] board = readGameBoardInput(scanner, n);
        int[] bestMoves = findBestMoves(board, n);
        outputResult(bestMoves);
    }

    private static int readLengthForGameBoard(Scanner scanner) {
        int[][] board = readGameBoardInput(scanner);
        int[] suggestedMoves = findBestMoves(board);

        // TODO output/print suggestedMoves
    }
    
    private static void readGameBoardInput(Scanner scanner) {
        // Get the size of the game board (number of tiles)
        int n = Integer.parseInt(scanner.nextLine());
        return n;
    }

    private static int[][] readGameBoardInput(Scanner scanner, int numberOfTiles) {
        int n = numberOfTiles;
        int[][] board = new int[n][n];

        // Read each line of the board configuration
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            // Extract the color information from each line and store it in the board array
            for (int j = 0; j < n; j++) {
                board[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }
        return board;
    }

    private static int[] findBestMoves(int[][] board, int n) {
        int numberOfColors = n;
        int[] suggestedMoves = new int[board.length * board[0].length];

        // Start DFS from the top-left cell (0, 0) with the color of the top-left cell
        dfs(board, 0, 0, board[0][0], numberOfColors, new boolean[board.length][board[0].length],
                suggestedMoves, 0);

        return suggestedMoves;
    }

    private static void dfs(int[][] board, int row, int col, int targetColor, int numberOfColors,
                            boolean[][] visited, int[] suggestedMoves, int moveCount) {
        // First check if out of bounds OR if the current cell was already visited
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col]) {
            return;
        }
        visited[row][col] = true;

        // Store the target color in the suggestedMoves array for this move
        suggestedMoves[moveCount] = targetColor;

        // TODO
        // If the entire board is filled with the target color, RETURN
        // Else make recursive calls to explore all possible color choices
    }

    private static void outputResult(int[] suggestedMoves) {
        // TODO
        // Print output as requested, based on suggestedMoves
        // First line: number of moves
        // Second line: number of times each color was selected
    }

}