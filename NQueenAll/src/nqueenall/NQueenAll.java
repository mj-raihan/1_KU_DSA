/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nqueenall;

import java.util.Arrays;

/**
 *
 * @author nemesis
 */
public class NQueenAll {

    /**
     * @param args the command line arguments
     */
    public static final String ANSI_BLUE = "\u001B[34m";
    public static boolean stepbystep = true;

    private static void printSolution(char[][] mat, int n) {
//        for (char[] chars : mat) {
//            System.out.println(Arrays.toString(chars).replaceAll(",", " "));
//        }
//        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(" " + mat[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println('\n');
    }

    // Function to check if two queens threaten each other or not
    private static boolean isSafe(char[][] mat, int row, int column) {
        if (stepbystep) {
            System.out.println("\nPlaced Q in row, column, n: " + row + " " + column);
        }
        // return false if two queens share the same column
        for (int i = 0; i < row; i++) {
            if (mat[i][column] == 'Q') {
                if (stepbystep) {
                    System.out.println("Found Q on same column. Returned False. row, column: " + i + " " + column);
                }
                return false;
            }
        }

        // return false if two queens share the same `` diagonal
        for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) {
            if (mat[i][j] == 'Q') {
                if (stepbystep) {
                    System.out.println("Found Q upper left diagonal. Returned False. row, column: " + i + " " + j);
                }
                return false;
            }
        }

        // return false if two queens share the same `/` diagonal
        for (int i = row, j = column; i >= 0 && j < mat.length; i--, j++) {
            if (mat[i][j] == 'Q') {
                if (stepbystep) {
                    System.out.println("Found Q upper right diagonal. Returned False. row, column: " + i + " " + j);
                }
                return false;
            }
        }

        return true;
    }

    private static boolean nQueen(char[][] mat, int row, int n) {
        // if `N` queens are placed successfully, print the solution
        if (stepbystep) {
            System.out.println(ANSI_BLUE + "New start. Row: " + row);
        }
        if (row == mat.length) {
            if (stepbystep) {
                System.out.println(ANSI_BLUE+"Complete");
            }
            printSolution(mat, n);
            return false;
        }

        // place queen at every square in the current row `r`
        // and recur for each valid movement
        for (int i = 0; i < mat.length; i++) {
            // if no two queens threaten each other
            if (isSafe(mat, row, i)) {
                if (stepbystep) {
                    System.out.println("column safe: " + i);
                }
                // place queen on the current square
                mat[row][i] = 'Q';
                if (stepbystep) {
                    printSolution(mat, n);
                }

                // recur for the next row
                if (nQueen(mat, row + 1, n)) {
                    if (stepbystep) {
                        System.out.println("Return from recursion.");
                    }
                    return true;
                }

                // backtrack and remove the queen from the current square
                mat[row][i] = '.';
            } else {

                if (stepbystep) {
                    System.out.println("not safe");
                }
            }
        }
        if (stepbystep) {
            System.out.println("return from recursion");
        }
        return false;
    }

    public static void main(String[] args) {
        // `N × N` chessboard
        int N = 4;

        // `mat[][]` keeps track of the position of queens in
        // the current configuration
        char[][] mat = new char[N][N];

        // initialize `mat[][]` by `-`
        for (int i = 0; i < N; i++) {
            Arrays.fill(mat[i], '.');
        }

        nQueen(mat, 0, N);

    }

}
