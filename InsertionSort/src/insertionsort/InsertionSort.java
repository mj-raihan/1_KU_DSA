/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insertionsort;

/**
 *
 * @author nemesis
 */
public class InsertionSort {

    public static final String ANSI_BLUE = "\u001B[34m";

    public static void sort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            System.out.println("key: "+key);

            /* Move elements of arr[0..i-1], that are greater than key*/
            while (j >= 0 && arr[j] > key) {
                System.out.print("cycle " + j + ": ");
                arr[j + 1] = arr[j];
                --j;
                printArray(arr);

            }
            arr[j + 1] = key;
            System.out.print(ANSI_BLUE + "Phase " + i + ": ");
            printArray(arr);
            System.out.println("");
        }
    }

    /*print array of size n*/
    public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {17, 12, 18, 5, 7, 8, 10};

        System.out.print(ANSI_BLUE + "Given array: ");
        printArray(arr);
        System.out.println("");

        sort(arr);

        System.out.print(ANSI_BLUE + "Sorted array: ");
        printArray(arr);

    }

}
