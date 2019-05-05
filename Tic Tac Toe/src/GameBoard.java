/**
 * Created by sam on 7/7/17.
 */
import java.util.Scanner;

public class GameBoard {
    // Use a matrix to emulate a 3*3 grid.
    private String[][] board = new String[3][3];
    private String[][] players = { { "Player 1", "X" }, { "Player 2", "O" } };
    private int currentPlayer = -1;

    public boolean isBoardFull() {
        for (String[] row : board) {
            for (String col : row) {
                if (col == null) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean gameIsWon() {
        // I shall leave this to your imagination ;)
        return false;
    }

    public void printBoard() {
        for (String[] row : board) {
            for (String col : row) {
                System.out.print("|" + (col == null ? " " : col) + "|");
            }

            System.out.println("\n---------");
        }
    }

    public void play() {
        // Try-with-resource (Java 7+)

        try (Scanner scanner = new Scanner(System.in)) {
            while (!isBoardFull()) {
                currentPlayer = (currentPlayer + 1) % 2;

                boolean valid = false;

                // Loop until a certain player makes a valid move
                while (!valid) {
                    System.out.print(players[currentPlayer][0] + ", choose your row: \n> ");
                    int row = scanner.nextInt() - 1;

                    System.out.print(players[currentPlayer][0] + ", you have chosen row " + (row + 1) + ". Choose your column: \n> ");
                    int col = scanner.nextInt() - 1;

                    if (board[row][col] == null) {
                        board[row][col] = players[currentPlayer][1];

                        printBoard();

                        if (gameIsWon()) {
                            System.out.println(players[currentPlayer][0] + " wins!");

                            return;
                        }

                        valid = true; // This will allow players to switch turns
                    } else {
                        System.out.println("This slot is taken, try again!");
                    }
                }
            }

            System.out.println("Draw!");
        }
    }

    public static void main(String[] args) {
        new GameBoard().play();
    }
}
