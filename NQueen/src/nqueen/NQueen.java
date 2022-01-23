/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nqueen;

import java.util.Scanner;

/**
 *
 * @author nemesis
 */
public class NQueen {

    /**
     * @param args the command line arguments
     */
    public static final String ANSI_BLUE = "\u001B[34m";
public static boolean stepbystep = true;

    public static void solution(char board[][], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(" " + board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(char board[][], int row, int column, int n) {
        int i, j;
        if (stepbystep) System.out.println("\nPlaced Q in row, column: " + row + " " + column);
        /* Check this row on left side */

        for (i = 0; i < column; i++) {

            if (board[row][i] == 'Q') {
                if (stepbystep) System.out.println("Found Q on left side. Returned False. row, column: " + row + " " + i);
                return false;
            }
        }
        /* Check upper diagonal on left side */
        for (i = row, j = column; i >= 0 && j >= 0; i--, j--) {
//            System.out.println("check upper diagonal. row, column: " + i + " " + j);
            if (board[i][j] == 'Q') {
                if (stepbystep) System.out.println("Found Q upper diagonal. Returned False. row, column: " + i + " " + j);
                return false;
            }
        }
        /* Check lower diagonal on left side */
        for (i = row, j = column; i < n && j >= 0; i++, j--) {
//            System.out.println("check lower diagonal. row, column: " + i + " " + j);
            if (board[i][j] == 'Q') {
                if (stepbystep) System.out.println("Found Q lower diagonal. Returned False. row, column: " + i + " " + j);
                return false;
            }
        }
        return true;
    }

    /* Quenes are already placed in columns, check on the left side. Recursion on next column*/
    public static boolean solveNQueens(char board[][], int column, int n) {
        if (stepbystep) System.out.println(ANSI_BLUE + "New start. column: " + column);
        if (column >= n) {
            System.out.println(ANSI_BLUE+"\n\nComplete");
            solution(board, n);
            return false;
        }
//        iterate row
        for (int i = 0; i < n; i++) {

            if (isSafe(board, i, column, n)) {
                if (stepbystep) System.out.println("row safe: " + i);
                board[i][column] = 'Q';
                if (stepbystep) solution(board, n);
                if (solveNQueens(board, column + 1, n)) {
                    if (stepbystep) System.out.println("Return from recursion.");
                    return true;
                }
//               new Q is not possible, remove the previous Q and put .
                board[i][column] = '.';
            } else {

                if (stepbystep) System.out.println("Row safe");
            }
        }
        if (stepbystep) System.out.println("return from recursion");
        return false;
    }

    public static void main(String[] args) {
//        board size
//        Scanner sc=new Scanner(System.in);
//        System.out.println("Enter the value of n");
//        int n=sc.nextInt();
        int n = 4;

//        board
        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        if (solveNQueens(board, 0, n)) {
            solution(board, n);
        } 
    }

}
