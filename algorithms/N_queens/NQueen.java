/*
    For each column, place queen on board such that it is safe from other queens.
        1. If queen can be replaced safely: mark it down on the board, and recursively place queens for next column, until last column
        2. If there is a solution by placing queen in [row][col], return true
        3. If there is no solution, backtrack and unmark board and try other rows
    If there are no suitable rows, return false
 */

import java.util.Arrays;

public class NQueen {
    final int N = 4;

    public void printBoard(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Need to check row on the left, top left diagonal and bottom left diagonal
    public boolean isSafe(int[][] board, int row, int col) {
        // Check row
        for (int c = 0; c < col; c++) {
            // System.out.println(board[row][c]);
            if (board[row][c] == 1) {
                return false;
            }
        }
        // Check top left diagonal
        for (int i = row, j = col; i > -1 && j > -1; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        // Check bottom left diagonal
        for (int i = row, j = col; i < N && j > -1; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    public boolean solveRecursive(int[][] board, int col) {
        if (col == N) {
            return true;
        }
        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;

                // Recursively place queen for the next column
                if (solveRecursive(board, col + 1)) {
                    return true;
                }

                // Backtrack. If placing queen on [row][col] does not lead to a solution, remove it
                board[i][col] = 0;
            }
        }
        return false;
    }

    public boolean solve(int[][] board) {
        return solveRecursive(board, 0);
    }

    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };
        NQueen nq = new NQueen();

        System.out.println("Generating board...");
        nq.printBoard(board);

        if (nq.solve(board)) {
            System.out.println("Printing solution...");
            nq.printBoard(board);
        } else {
            System.out.println("There is no solution");
        }

    }
}
